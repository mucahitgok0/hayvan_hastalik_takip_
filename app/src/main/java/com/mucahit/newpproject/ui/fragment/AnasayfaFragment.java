package com.mucahit.newpproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.mucahit.newpproject.R;
import com.mucahit.newpproject.databinding.FragmentAnasayfaBinding;
import com.mucahit.newpproject.ui.adapter.HayvanlarAdapter;
import com.mucahit.newpproject.ui.viewmodel.AnaSayfaViewModel;



import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    private AnaSayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);
        binding.toolbarAnasayfa.setTitle("Anasayfa");


        binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.hayvanlarListesi.observe(getViewLifecycleOwner(),hayvanlarListesi->{
            HayvanlarAdapter hayvanlarAdapter = new HayvanlarAdapter(requireContext(),hayvanlarListesi,viewModel);
            binding.rv.setAdapter(hayvanlarAdapter);
        });

        binding.fab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.hayvanKayitGecis);
        });
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.ara(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.ara(newText);
                return true;
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnaSayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.hayvanlariYukle();
    }
}