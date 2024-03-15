package com.mucahit.newpproject.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mucahit.newpproject.data.entity.Hayvanlar;
import com.mucahit.newpproject.data.repo.HayvanlarDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnaSayfaViewModel extends ViewModel {
    public HayvanlarDaoRepository krepo;
    public MutableLiveData<List<Hayvanlar>> hayvanlarListesi;

    @Inject
    public AnaSayfaViewModel(HayvanlarDaoRepository krepo){
        this.krepo = krepo;
        hayvanlariYukle();
        hayvanlarListesi = krepo.hayvanlarListesi;
    }
    public void ara(String aramaKelimesi){
        krepo.ara(aramaKelimesi);
    }
    public void sil(int hayvanid){
        krepo.sil(hayvanid);
    }
    public void hayvanlariYukle(){
        krepo.hayvanlariYukle();
    }
}
