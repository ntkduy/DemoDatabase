package com.ntkduy1604.demodatabase.di;

import android.app.Application;

import com.ntkduy1604.demodatabase.ui.list.ListFragment;

import javax.inject.Singleton;

import dagger.Component;
/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Singleton
@Component(modules = {ApplicationModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(ListFragment listFragment);

    Application application();

}