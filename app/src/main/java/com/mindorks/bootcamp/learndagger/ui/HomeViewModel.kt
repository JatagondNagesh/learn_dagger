package com.mindorks.bootcamp.learndagger.ui

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.scope.FragmentScope
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper
import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
        private val networkHelper: NetworkHelper
) {
    fun getSomeData() = databaseService.getDummyData() + " : " + networkService.getDummyData()+ " : " + networkHelper.isNetworkConnected()
}