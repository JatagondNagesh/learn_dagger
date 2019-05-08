package com.mindorks.bootcamp.learndagger.di.component;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.module.ApplicationModule;
import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @ApplicationContext
    Context getContext();

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

    NetworkHelper getNetworkHelper();
}
