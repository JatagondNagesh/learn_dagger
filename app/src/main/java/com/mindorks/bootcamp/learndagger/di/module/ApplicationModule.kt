package com.mindorks.bootcamp.learndagger.di.module

import android.content.Context
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseInfo
import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext() = application as Context

    @DatabaseInfo
    @Provides
    fun provideDatabaseName() = "dummy_db"

    @DatabaseInfo
    @Provides
    fun provideDatabaseVersion() = 1

    @NetworkInfo
    @Provides
    fun provideApiKey() = "SOME_API_KEY"
}