package com.ntkduy1604.demodatabase.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.ntkduy1604.demodatabase.DatabaseDemoApplication;
import com.ntkduy1604.demodatabase.db.dao.ListItemDao;
import com.ntkduy1604.demodatabase.db.entity.ListItem;
import com.ntkduy1604.demodatabase.repository.ListItemRepository;

import java.util.List;


/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
public class ListItemCollectionViewModel extends AndroidViewModel {

    private ListItemRepository repository;

    ListItemCollectionViewModel(Application application, ListItemRepository repository) {
        super(application);
        this.repository = repository;
    }

    public LiveData<List<ListItem>> getAllItems() {
        return repository.getAllItems();
    }

//    public void deleteListItem(ListItem listItem) {
//        DeleteItemTask deleteItemTask = new DeleteItemTask();
//        deleteItemTask.execute(listItem);
//    }

//    private class DeleteItemTask extends AsyncTask<ListItem, Void, Void> {
//
//        @Override
//        protected Void doInBackground(ListItem... item) {
//            repository.deleteListItem(item[0]);
//            return null;
//        }
//    }

}
