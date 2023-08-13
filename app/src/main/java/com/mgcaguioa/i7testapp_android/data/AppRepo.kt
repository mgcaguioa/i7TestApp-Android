package com.mgcaguioa.i7testapp_android.data

import javax.inject.Inject

interface AppRepo {

    suspend fun getActions(): List<ActionModel>

    suspend fun saveAction(action: ActionModel)
}

class AppRepoImpl @Inject constructor(
    private val actionDao: ActionDao
) : AppRepo {

    override suspend fun getActions(): List<ActionModel> {
        return actionDao.getAllActions().sortedByDescending { it.date }
    }

    override suspend fun saveAction(action: ActionModel) {
        actionDao.insertAction(action)
    }

}