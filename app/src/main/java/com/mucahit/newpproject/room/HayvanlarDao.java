package com.mucahit.newpproject.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.mucahit.newpproject.data.entity.Hayvanlar;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface HayvanlarDao {
    @Query("SELECT * FROM hastaliklar")
    Single<List<Hayvanlar>> hayvanlariYukle();
}
