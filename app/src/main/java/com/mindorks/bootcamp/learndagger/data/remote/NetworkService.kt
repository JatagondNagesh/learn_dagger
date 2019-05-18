package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(
        @ApplicationContext private val context: Context,
        @NetworkInfo private val apiKey: String
) {
    fun getDummyData() = "NETWORK_DUMMY_DATA"
}