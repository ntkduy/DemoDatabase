package com.ntkduy1604.demodatabase;

import android.app.Application;

import com.ntkduy1604.demodatabase.di.ApplicationComponent;
import com.ntkduy1604.demodatabase.di.ApplicationModule;
import com.ntkduy1604.demodatabase.di.DaggerApplicationComponent;
import com.ntkduy1604.demodatabase.di.DatabaseModule;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
public class DatabaseDemoApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
