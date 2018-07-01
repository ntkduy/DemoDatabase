package com.ntkduy1604.demodatabase.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.ntkduy1604.demodatabase.db.ItemDatabase;
import com.ntkduy1604.demodatabase.db.dao.ListItemDao;
import com.ntkduy1604.demodatabase.db.entity.ListItem;
import com.ntkduy1604.demodatabase.repository.ListItemRepository;
import com.ntkduy1604.demodatabase.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Module
public class DatabaseModule {

    private final ItemDatabase database;
    private static final String DATABASE_NAME = "item_list.db";


    public DatabaseModule(Application application) {
        this.database = Room.databaseBuilder(
                application,
                ItemDatabase.class,
                DATABASE_NAME
        )
                .addCallback(sRoomDatabaseCallback)
                .build();
    }

    @Provides
    @Singleton
    ListItemRepository provideListItemRepository(ListItemDao listItemDao){
        return new ListItemRepository(listItemDao);
    }

    @Provides
    @Singleton
    ListItemDao provideListItemDao(ItemDatabase database){
        return database.listItemDao();
    }

    @Provides
    @Singleton
    ItemDatabase provideListItemDatabase(Application application){
        return database;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ListItemRepository repository){
        return new CustomViewModelFactory(repository);
    }

    /**
     *  Generate FAKE data
     */
    private RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new FakeListOfItems(database).execute();
                }
            };


    private static class FakeListOfItems extends AsyncTask<Void, Void, Void> {
        private final ListItemDao listItemDao;

        public FakeListOfItems(ItemDatabase db) {
            listItemDao = db.listItemDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            ListItem listItem;
            listItemDao.deleteAllItems();
            listItem = new ListItem(1, "pencil", 3.25, 10, "OfficeWorkd", "0432074017");
            listItemDao.insertItem(listItem);
            listItem = new ListItem(2, "pen", 3.25, 10, "OfficeWorkd", "0432074017");
            listItemDao.insertItem(listItem);
            return null;
        }
    }
}
