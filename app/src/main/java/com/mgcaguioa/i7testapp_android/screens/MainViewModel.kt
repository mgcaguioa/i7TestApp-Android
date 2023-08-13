package com.mgcaguioa.i7testapp_android.screens

import androidx.lifecycle.ViewModel
import com.mgcaguioa.i7testapp_android.data.ActionModel
import com.mgcaguioa.i7testapp_android.data.AppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: AppRepo
) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun saveAction(btnId: String) {
        val action = ActionModel(
            buttonId = btnId,
            date = getCurrentDateTime()
        )
        coroutineScope.launch(Dispatchers.IO) {
            repo.saveAction(action)
        }
    }

    private fun getCurrentDateTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())
        return formatter.format(time)
    }
}