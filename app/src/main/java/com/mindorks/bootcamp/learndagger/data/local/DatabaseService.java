package com.mindorks.bootcamp.learndagger.data.local;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Dummy class to simulate the actual Database using Room or Realm etc
 */
@Singleton
public class DatabaseService {

    private Context context;
    private String databaseName;
    private int version;

    @Inject
    public DatabaseService(@ApplicationContext Context context,
                           @DatabaseInfo String databaseName,
                           @DatabaseInfo Integer version) {
        // do the initialisation here
        this.context = context;
        this.databaseName = databaseName;
        this.version = version;
    }

    public String getDummyData() {
        return "DATABASE_DUMMY_DATA";
    }
}
