package com.mucahit.newpproject.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mucahit.newpproject.data.entity.Hayvanlar;
import com.mucahit.newpproject.databinding.CardTasarimBinding;
import com.mucahit.newpproject.databinding.FragmentAnasayfaBinding;
import com.mucahit.newpproject.ui.fragment.AnasayfaFragmentDirections;
import com.mucahit.newpproject.ui.viewmodel.AnaSayfaViewModel;

import java.util.List;

public class HayvanlarAdapter extends RecyclerView.Adapter<HayvanlarAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Hayvanlar> hayvanlarList;
    private AnaSayfaViewModel viewModel;

    public HayvanlarAdapter(Context mContext, List<Hayvanlar> hayvanlarList, AnaSayfaViewModel viewModel) {
        this.mContext = mContext;
        this.hayvanlarList = hayvanlarList;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }


    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Hayvanlar hayvan = hayvanlarList.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewHayvanAdi.setText(hayvan.getHayvanAdi());
        t.textViewHayvanHastaligi.setText(hayvan.getHayvanHastaligi());
        t.textViewHayvanIlaclar.setText(hayvan.getHayvanIlaclari());

        t.cardViewSatir.setOnClickListener(view->{
            AnasayfaFragmentDirections.HayvanDetayGecis gecis = AnasayfaFragmentDirections.hayvanDetayGecis(hayvan);
            Navigation.findNavController(view).navigate(gecis);
        });
        t.imageViewSil.setOnClickListener(view->{
            Snackbar.make(view,hayvan.getHayvanAdi()+
                    " silinsin mi ?",Snackbar.LENGTH_SHORT).
                    setAction("EVET",view1->{
                        viewModel.sil(hayvan.getId());
                    }).show();

        });
    }

    @Override
    public int getItemCount() {
        return hayvanlarList.size();
    }

}
