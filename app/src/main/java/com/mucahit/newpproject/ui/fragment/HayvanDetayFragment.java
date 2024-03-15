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
import com.mucahit.newpproject.data.entity.Hayvanlar;
import com.mucahit.newpproject.databinding.FragmentAnasayfaBinding;
import com.mucahit.newpproject.databinding.FragmentHayvanDetayBinding;
import com.mucahit.newpproject.ui.viewmodel.AnaSayfaViewModel;
import com.mucahit.newpproject.ui.viewmodel.HayvanDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HayvanDetayFragment extends Fragment {
    private FragmentHayvanDetayBinding binding;
    private HayvanDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHayvanDetayBinding.inflate(inflater, container, false);
        binding.toolbarAnasayfa2.setTitle("Detay Sayfası");
        HayvanDetayFragmentArgs bundle = HayvanDetayFragmentArgs.fromBundle(getArguments());
        Hayvanlar gelenhayvan = bundle.getHayvan();

        binding.editTextHayvanAd.setText(gelenhayvan.getHayvanAdi());
        binding.editTextHayvanHastaliklari.setText(gelenhayvan.getHayvanHastaligi());
        binding.editTextIlaclari.setText(gelenhayvan.getHayvanIlaclari());

        binding.buttonGuncelle.setOnClickListener(view->{
            String hayvanAd = binding.editTextHayvanAd.getText().toString();
            String hayvanHastaliklari = binding.editTextHayvanHastaliklari.getText().toString();
            String hayvanIlaclari = binding.editTextIlaclari.getText().toString();
            viewModel.guncelle(gelenhayvan.getId(),hayvanAd,hayvanHastaliklari,hayvanIlaclari);
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HayvanDetayViewModel.class);
    }
}