package com.mucahit.newpproject.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.mucahit.newpproject.data.entity.Hayvanlar;
import com.mucahit.newpproject.room.HayvanlarDao;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HayvanlarDaoRepository {
    public MutableLiveData<List<Hayvanlar>> hayvanlarListesi = new MutableLiveData<>();
    private HayvanlarDao kdao;

    public HayvanlarDaoRepository(HayvanlarDao kdao){
        this.kdao = kdao;
    }

    public void kaydet(String hayvanAd, String hayvanHastaliklari,String hayvanIlaclari ){
        Log.e("Hayvan Kaydet:",hayvanAd+"-"+hayvanHastaliklari+"-"+hayvanIlaclari);
    }
    public void guncelle(int id,String hayvanAd, String hayvanHastaliklari,String hayvanIlaclari ){
        Log.e("Hayvan Güncelle:",id+"-"+hayvanAd+"-"+hayvanHastaliklari+"-"+hayvanIlaclari);
    }
    public void ara(String aramaKelimesi){
        Log.e("Hayvan Ara",aramaKelimesi);
    }
    public void sil(int hayvanid){
        Log.e("Hayvan Sil",String.valueOf(hayvanid));
        hayvanlariYukle();
    }
    public void hayvanlariYukle(){
        kdao.hayvanlariYukle().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Hayvanlar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Hayvanlar> hayvanlars) {
                        hayvanlarListesi.setValue(hayvanlars);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
