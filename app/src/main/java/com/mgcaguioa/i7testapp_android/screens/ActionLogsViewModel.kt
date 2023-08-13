package com.mgcaguioa.i7testapp_android.screens

import androidx.lifecycle.ViewModel
import com.mgcaguioa.i7testapp_android.data.ActionModel
import com.mgcaguioa.i7testapp_android.data.AppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActionLogsViewModel @Inject constructor(
    private val repo: AppRepo
) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    var actions = mutableListOf<ActionModel>()

    init {
        getActions()
    }

    private fun getActions() {
        coroutineScope.launch(Dispatchers.IO) {
            actions = repo.getActions().toMutableList()
        }
    }
}