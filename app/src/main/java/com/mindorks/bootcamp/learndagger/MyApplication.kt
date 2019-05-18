package com.mindorks.bootcamp.learndagger

import android.app.Application
import android.util.Log
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.component.ApplicationComponent
import com.mindorks.bootcamp.learndagger.di.component.DaggerApplicationComponent
import com.mindorks.bootcamp.learndagger.di.module.ApplicationModule
import com.mindorks.bootcamp.learndagger.ui.HomeFragment
import javax.inject.Inject

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    @Inject
    lateinit var networkService: NetworkService
    @Inject
    lateinit var databaseService: DatabaseService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
        Log.d(HomeFragment.TAG, networkService.getDummyData())
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }
}