package com.vaish.apoinnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class homepage extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    private RecyclerView rvPopularSalons;
    private PopularSalonsAdapter popularSalonsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        // Initialize category recycler view
        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        // Initialize category data list
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.tatto, "tattoo"));
        categoryList.add(new Category(R.drawable.salons, "salons"));
        categoryList.add(new Category(R.drawable.spa, "spa"));
        categoryList.add(new Category(R.drawable.barbers, "barber"));
        categoryList.add(new Category(R.drawable.health, "health"));

        categoryAdapter = new CategoryAdapter(categoryList, new CategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category category) {
                navigateToCategory(category);
            }
        });
        categoryRecyclerView.setAdapter(categoryAdapter);

        // Initialize popular salons recycler view
        rvPopularSalons = view.findViewById(R.id.category_recycler_view_popular);
        rvPopularSalons.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        popularSalonsAdapter = new PopularSalonsAdapter(getDummyPopularSalons(), requireContext());
        rvPopularSalons.setAdapter(popularSalonsAdapter);

        return view;
    }

    private void navigateToCategory(Category category) {
        Fragment fragment = null;

        // Determine which fragment to navigate to based on the category
        switch (category.getName()) {
            case "tattoo":
                fragment = new TattooFragment();
                break;
            case "salons":
                fragment = new SalonFragment();
                break;
            case "spa":
                fragment = new SpaFragment();
                break;
            case "barber":
                fragment = new BarberFragment();
                break;
            case "health":
                fragment = new HealthFragment();
                break;
            default:
                throw new IllegalArgumentException("Unknown category: " + category.getName());
        }

        if (fragment != null) {
            // Perform the fragment transaction to navigate to the selected category
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_layout, fragment); // Assuming `home_main_layout` is the ID of the container for fragments
            transaction.addToBackStack(null); // Add transaction to back stack to allow back navigation
            transaction.commit();
        }
    }

    private List<PopularSalon> getDummyPopularSalons() {
        List<PopularSalon> popularSalons = new ArrayList<>();
        popularSalons.add(new PopularSalon("Salon A", "https://example.com/salon_a.jpg", true, "10 AM - 8 PM", 1.2f));
        popularSalons.add(new PopularSalon("Salon B", "https://example.com/salon_b.jpg", false, "Closed, Opens at 9 AM", 2.5f));
        // Add more dummy data here
        return popularSalons;
    }
}
