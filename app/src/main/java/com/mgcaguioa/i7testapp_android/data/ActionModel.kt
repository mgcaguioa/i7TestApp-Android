package com.mgcaguioa.i7testapp_android.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "action")
data class ActionModel(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "buttonId") var buttonId: String,
    @ColumnInfo(name = "date") var date: String,
)
