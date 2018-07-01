package com.ntkduy1604.demodatabase.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.ntkduy1604.demodatabase.db.dao.ListItemDao;
import com.ntkduy1604.demodatabase.db.entity.ListItem;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */

@Database(entities = {ListItem.class}, version = 1, exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase {
    public abstract ListItemDao listItemDao();
}
