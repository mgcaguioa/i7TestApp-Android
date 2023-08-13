package com.mgcaguioa.i7testapp_android.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActionDao {

    @Query("SELECT * FROM `action`")
    fun getAllActions(): List<ActionModel>

    @Insert
    fun insertAction(action: ActionModel)
}
