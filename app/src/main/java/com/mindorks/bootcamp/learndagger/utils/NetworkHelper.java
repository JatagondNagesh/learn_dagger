package com.mindorks.bootcamp.learndagger.utils;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkHelper {
    // Should be Application Context
    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        // will check for network connectivity
        return false;
    }
}
