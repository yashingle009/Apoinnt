package com.vaish.apoinnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SalonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SalonFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<salon> salonList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salon, container, false);

        recyclerView = view.findViewById(R.id.recylerview_salon_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the salon list with dummy data
        salonList = new ArrayList<>();
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));
        salonList.add(new salon("Javed Habib", "High-quality services", "₹500", 4.5f, "1.5 km", R.drawable.javed_habib));
        salonList.add(new salon("capello salon", "Affordable and best", "₹300", 4.0f, "2.0 km", R.drawable.capello_salon));
        salonList.add(new salon("yo yo salons", "Luxury experience", "₹700", 4.8f, "2.5 km", R.drawable.javed_habib));



        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter logic here (to be implemented)
                return false;
            }
        });

        return view;
    }
}
