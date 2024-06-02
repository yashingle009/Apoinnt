package com.vaish.apoinnt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PopularSalonsAdapter extends RecyclerView.Adapter<PopularSalonsAdapter.ViewHolder> {

    private List<PopularSalon> popularSalons;
    private static Context context;

    public PopularSalonsAdapter(List<PopularSalon> popularSalons, Context context) {
        this.popularSalons = popularSalons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popularsalon, parent, false);
        return new ViewHolder(view, popularSalons);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularSalon salon = popularSalons.get(position);

        // Load the salon image using a library like Glide or Picasso
//        Glide.with(holder.itemView.getContext())
//                .load(salon.getImageUrl())
//                .into(holder.ivSalonImage);

        holder.tvStatus.setText(salon.isOpen() ? "Open" : "Closed");
        holder.tvStatus.setTextColor(holder.itemView.getResources().getColor(salon.isOpen() ? android.R.color.holo_green_dark : android.R.color.holo_red_dark));
        holder.tvTiming.setText(salon.isOpen() ? salon.getTiming() : "Opens at " + salon.getTiming());
        holder.tvSalonName.setText(salon.getName());
        holder.tvDistance.setText(String.format("%.1f km", salon.getDistance()));
    }

    @Override
    public int getItemCount() {
        return popularSalons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSalonImage;
        TextView tvStatus;
        TextView tvTiming;
        TextView tvSalonName;
        TextView tvDistance;
        ImageView ivBook;
        Button btnBOOK;
        private List<PopularSalon> popularSalons;

        public ViewHolder(@NonNull View itemView, List<PopularSalon> popularSalons) {
            super(itemView);
            this.popularSalons = popularSalons;
            ivSalonImage = itemView.findViewById(R.id.ivSalonImage);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvTiming = itemView.findViewById(R.id.tvTiming);
            tvSalonName = itemView.findViewById(R.id.tvSalonName);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            ivBook = itemView.findViewById(R.id.ivBook);
            btnBOOK= itemView.findViewById(R.id.btnBook);

            btnBOOK.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    PopularSalon salon = this.popularSalons.get(position);
                    navigateToShopDescriptionFragment(salon);
                }

            });
        }
    }

    private static void navigateToShopDescriptionFragment(PopularSalon salon) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("salon_data", salon);
        ShopDescriptionFragment shopDescriptionFragment = new ShopDescriptionFragment();
        shopDescriptionFragment.setArguments(bundle);

        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_main_layout, shopDescriptionFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}