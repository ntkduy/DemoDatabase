package com.ntkduy1604.demodatabase.di;

import android.app.Application;

import com.ntkduy1604.demodatabase.DatabaseDemoApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Module
public class ApplicationModule {
    private final DatabaseDemoApplication application;
    public ApplicationModule(DatabaseDemoApplication application) {
        this.application = application;
    }

    @Provides
    DatabaseDemoApplication provideDatabaseDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
