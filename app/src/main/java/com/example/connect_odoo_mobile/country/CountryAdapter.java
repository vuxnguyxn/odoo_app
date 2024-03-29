package com.example.connect_odoo_mobile.country;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.connect_odoo_mobile.R;
import com.example.connect_odoo_mobile.contact.AddContactActivity;
import com.example.connect_odoo_mobile.handle.CountryInterface;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private final List<Country> countryList;
    private CountryInterface countryInterface;

    public CountryAdapter(List<Country> countryList, CountryInterface countryInterface) {
        this.countryList = countryList;
        this.countryInterface = countryInterface;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        if (!country.getName().equals(false)) {
            holder.txtName.setText((String) country.getName());
        }
        holder.layoutCountry.setOnClickListener(view -> {
            countryInterface.onClickCountryItemRecyclerView(country);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtName;
        private final ConstraintLayout layoutCountry;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtCountry);
            layoutCountry = itemView.findViewById(R.id.layoutCountry);
        }
    }
}
