package com.mindorks.bootcamp.learndagger.di.module;

import android.app.Activity;
import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityContext
    @Provides
    Context provideContext() {
        return activity;
    }
}
