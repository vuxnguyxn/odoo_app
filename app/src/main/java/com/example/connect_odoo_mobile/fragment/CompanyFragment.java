package com.example.connect_odoo_mobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.connect_odoo_mobile.MainActivity;
import com.example.connect_odoo_mobile.R;
import com.example.connect_odoo_mobile.adapter.CompanyAdapter;
import com.example.connect_odoo_mobile.data.ConnectOdoo;
import com.example.connect_odoo_mobile.data_models.Company;

import org.apache.xmlrpc.XmlRpcException;

import java.util.List;

public class CompanyFragment extends Fragment {
    private View view;
    private CompanyAdapter companyAdapter;
    private List<Company> companyArrayList;
    private RecyclerView layoutView;
    private ConnectOdoo getDataFromOdoo = new ConnectOdoo();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_company, container, false);
        //mapping view
        mapping();
        //set contact recycler view
        setContactRecyclerView();
        return view;
    }

    private void mapping() {
        layoutView = view.findViewById(R.id.layoutView);
    }

    private void setContactRecyclerView() {
        String db,url,user,pass;
        url = MainActivity.url;
        db = MainActivity.db;
        user = MainActivity.user;
        pass = MainActivity.pass;
        try {
            companyArrayList = getDataFromOdoo.getCompany(db,url,user,pass);
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        companyAdapter = new CompanyAdapter(getContext(), companyArrayList);
        LinearLayoutManager companyManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        layoutView.setLayoutManager(companyManager);
        layoutView.setAdapter(companyAdapter);
    }
}