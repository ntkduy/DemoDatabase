package com.ntkduy1604.demodatabase.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ntkduy1604.demodatabase.db.entity.ListItem;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by NTKDUY on 7/1/2018
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */
@Dao
public interface ListItemDao {

    // Get all entities of type ListItem
    @Query("SELECT * FROM item_table ORDER BY item_name ASC")
    LiveData<List<ListItem>> getAllItems();

    /**
     * Get entity by itemId.
     * @param itemId: A Unique identifier for a given record within the Database.
     * @return
     */
    @Query("SELECT * FROM item_table WHERE item_id = :itemId")
    LiveData<ListItem> getItemById(long itemId);

    /**
     * Insert a new ListItem
     * @param listItem: New item with ListItem datatype
     */
    @Insert(onConflict = REPLACE)
    void insertItem(ListItem listItem);

    /**
     * Delete a given ListItem
     * @param listItem
     */
    @Delete
    void deleteItem(ListItem listItem);


    /**
     * Kill them all :)
     */
    @Query("DELETE FROM item_table")
    void deleteAllItems();

}
