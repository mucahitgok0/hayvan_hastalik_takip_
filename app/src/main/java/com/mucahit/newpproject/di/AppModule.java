package com.mucahit.newpproject.di;

import android.content.Context;

import androidx.room.Room;

import com.mucahit.newpproject.data.repo.HayvanlarDaoRepository;
import com.mucahit.newpproject.room.HayvanlarDao;
import com.mucahit.newpproject.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public HayvanlarDaoRepository provideHayvanlarDaoRepository(HayvanlarDao kdao){
        return new HayvanlarDaoRepository(kdao);
    }

    @Provides
    @Singleton
    public HayvanlarDao provideHayvanlarDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class,"hastaliklar")
                .createFromAsset("hastaliklar").build();
        return vt.getHayvanlarDao();
    }
}
