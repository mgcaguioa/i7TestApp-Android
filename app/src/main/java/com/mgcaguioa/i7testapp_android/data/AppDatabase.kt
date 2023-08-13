package com.mgcaguioa.i7testapp_android.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ActionModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun actionDao(): ActionDao
}