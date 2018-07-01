package com.ntkduy1604.demodatabase.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.ntkduy1604.demodatabase.DatabaseDemoApplication;
import com.ntkduy1604.demodatabase.repository.ListItemRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final ListItemRepository repository;
    private DatabaseDemoApplication databaseDemoApplication;

    @Inject
    public CustomViewModelFactory(ListItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListItemCollectionViewModel.class)) {
            return (T) new ListItemCollectionViewModel(databaseDemoApplication, repository);
        }

//        else if (modelClass.isAssignableFrom(ListItemViewModel.class))
//            return (T) new ListItemViewModel(repository);
//
//        else if (modelClass.isAssignableFrom(NewListItemViewModel.class))
//            return (T) new NewListItemViewModel(repository);

        else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
