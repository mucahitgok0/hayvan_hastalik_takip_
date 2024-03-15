package com.mucahit.newpproject.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mucahit.newpproject.data.entity.Hayvanlar;

@Database(entities = {Hayvanlar.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract HayvanlarDao getHayvanlarDao();
}
