package com.mgcaguioa.i7testapp_android.di

import android.content.Context
import androidx.room.Room
import com.mgcaguioa.i7testapp_android.data.ActionDao
import com.mgcaguioa.i7testapp_android.data.AppDatabase
import com.mgcaguioa.i7testapp_android.data.AppRepo
import com.mgcaguioa.i7testapp_android.data.AppRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "i7TestApp"
        ).build()
    }

    @Provides
    @Singleton
    fun provideActionDao(appDatabase: AppDatabase): ActionDao {
        return appDatabase.actionDao()
    }

    @Provides
    @Singleton
    fun provideAppRepo(actionDao: ActionDao): AppRepo {
        return AppRepoImpl(actionDao)
    }
}