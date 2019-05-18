package com.mindorks.bootcamp.learndagger.ui

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
) {
    fun getSomeData() = databaseService.getDummyData() + " " + networkService.getDummyData()
}