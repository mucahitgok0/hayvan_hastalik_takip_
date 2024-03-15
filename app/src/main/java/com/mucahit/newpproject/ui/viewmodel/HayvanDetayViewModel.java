package com.mucahit.newpproject.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mucahit.newpproject.data.repo.HayvanlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HayvanDetayViewModel extends ViewModel {
    public HayvanlarDaoRepository krepo;

    @Inject
    public HayvanDetayViewModel(HayvanlarDaoRepository krepo) {
        this.krepo = krepo;
    }

    public void guncelle(int id, String hayvanAd, String hayvanHastaliklari, String hayvanIlaclari ){
        krepo.guncelle(id, hayvanAd,hayvanHastaliklari,hayvanIlaclari);
    }
}
