package com.ntkduy1604.demodatabase.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.ntkduy1604.demodatabase.db.ItemDatabase;
import com.ntkduy1604.demodatabase.db.dao.ListItemDao;
import com.ntkduy1604.demodatabase.db.entity.ListItem;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
public class ListItemRepository {
    private final ListItemDao listItemDao;
    private LiveData<List<ListItem>> allItems;

    @Inject
    public ListItemRepository(ListItemDao listItemDao) {

        this.listItemDao = listItemDao;
    }

    public LiveData<List<ListItem>> getAllItems() {


        return listItemDao.getAllItems();
    }

    public void deleteAllItems() {
        listItemDao.deleteAllItems();
    }

    public void insertItem(ListItem listItem) {
        new insertAsyncTask(listItemDao).execute(listItem);
    }

    public void deleteItem(ListItem listItem) {
        listItemDao.deleteItem(listItem);
    }

    /**
     * Async tasks
     */
    private static class insertAsyncTask extends AsyncTask<ListItem, Void, Void> {

        private ListItemDao listItemDao;

        insertAsyncTask(ListItemDao listItemDao) {
            this.listItemDao = listItemDao;
        }

        @Override
        protected Void doInBackground(final ListItem... params) {
            listItemDao.insertItem(params[0]);
            return null;
        }
    }


}
