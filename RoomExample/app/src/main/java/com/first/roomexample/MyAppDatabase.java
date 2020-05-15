package com.first.roomexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase
{

    public abstract MyDao myDao();

}
