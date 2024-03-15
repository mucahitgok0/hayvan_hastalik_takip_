package com.mucahit.newpproject.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "hastaliklar")
public class Hayvanlar implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    @NonNull
    private int id;
    @ColumnInfo(name="hayvanAdi")
    @NonNull
    private String hayvanAdi;
    @ColumnInfo(name="hayvanHastaligi")
    @NonNull
    private String hayvanHastaligi;
    @ColumnInfo(name="hayvanIlaclari")
    @NonNull
    private String hayvanIlaclari;

    public Hayvanlar(){}

    public Hayvanlar(int id, @NonNull String hayvanAdi, @NonNull String hayvanHastaligi, @NonNull String hayvanIlaclari) {
        this.id = id;
        this.hayvanAdi = hayvanAdi;
        this.hayvanHastaligi = hayvanHastaligi;
        this.hayvanIlaclari = hayvanIlaclari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getHayvanAdi() {
        return hayvanAdi;
    }

    public void setHayvanAdi(@NonNull String hayvanAdi) {
        this.hayvanAdi = hayvanAdi;
    }

    @NonNull
    public String getHayvanHastaligi() {
        return hayvanHastaligi;
    }

    public void setHayvanHastaligi(@NonNull String hayvanHastaligi) {
        this.hayvanHastaligi = hayvanHastaligi;
    }

    @NonNull
    public String getHayvanIlaclari() {
        return hayvanIlaclari;
    }

    public void setHayvanIlaclari(@NonNull String hayvanIlaclari) {
        this.hayvanIlaclari = hayvanIlaclari;
    }
}
