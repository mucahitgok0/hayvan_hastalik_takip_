package com.mucahit.newpproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mucahit.newpproject.R;
import com.mucahit.newpproject.databinding.FragmentHayvanDetayBinding;
import com.mucahit.newpproject.databinding.FragmentHayvanKayitBinding;
import com.mucahit.newpproject.ui.viewmodel.AnaSayfaViewModel;
import com.mucahit.newpproject.ui.viewmodel.HayvanKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HayvanKayitFragment extends Fragment {
    private FragmentHayvanKayitBinding binding;
    private HayvanKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHayvanKayitBinding.inflate(inflater, container, false);
        binding.toolbarKayit.setTitle("Kayıt Sayfası");

        binding.buttonGuncelle.setOnClickListener(view->{
            String hayvanAd = binding.editTextHayvanAd.getText().toString();
            String hayvanHastaliklari = binding.editTextHayvanHastaliklari.getText().toString();
            String hayvanIlaclari = binding.editTextIlaclari.getText().toString();
            viewModel.kaydet(hayvanAd,hayvanHastaliklari,hayvanIlaclari);
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HayvanKayitViewModel.class);
    }
}