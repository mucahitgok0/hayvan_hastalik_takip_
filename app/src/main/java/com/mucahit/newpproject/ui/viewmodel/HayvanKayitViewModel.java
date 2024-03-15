package com.mucahit.newpproject.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mucahit.newpproject.data.repo.HayvanlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HayvanKayitViewModel extends ViewModel {
    public HayvanlarDaoRepository krepo;

    @Inject
    public HayvanKayitViewModel(HayvanlarDaoRepository krepo) {
        this.krepo = krepo;
    }

    public void kaydet(String hayvanAd, String hayvanHastaliklari, String hayvanIlaclari ){
        krepo.kaydet(hayvanAd,hayvanHastaliklari,hayvanIlaclari);
    }
}
