package com.pontic_studio.myproperty.MainActivity.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pontic_studio.myproperty.R;

public class PropertyDetailsFragment extends Fragment {

    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView adress;
    private TextView owner;
    private TextView description;
    private Button reserveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_property_details, container, false);
        image=rootView.findViewById(R.id.detailsImageView); 
        name = rootView.findViewById(R.id.deatilsPropertyName);
        price= rootView.findViewById(R.id.deatilsPropertyPrice);
        adress= rootView.findViewById(R.id.deatilsPropertyAdress);
        owner= rootView.findViewById(R.id.deatilsPropertyOwner);
        description= rootView.findViewById(R.id.deatilsPropertyDescription);
        reserveButton=rootView.findViewById(R.id.reserveButton);

        Bundle bundle = getArguments();
        String numeProprietate = bundle != null ? bundle.getString("property_name") : null;
        String pret = bundle != null ? bundle.getString("property_price") : null;
        String adresa = bundle != null ? bundle.getString("property_adress") : null;
        String owner2 = bundle != null ? bundle.getString("property_owner") : null;
        String description2 = bundle != null ? bundle.getString("propeerty_description") : null;
        String status = bundle != null ? bundle.getString("property_status") : null;
        Boolean type=  bundle != null ? bundle.getBoolean("property_type") : null;

        name.setText(numeProprietate);
        price.setText(pret);
        adress.setText(adresa);
        owner.setText(owner2);
        description.setText(description2);
        if(status.equals("ocupat"))
        {
            reserveButton.setEnabled(false);
        }
        if(type)
        {
            image.setImageResource(R.drawable.building_image);
        }
        else {
            image.setImageResource(R.drawable.house_image);
        }

        return rootView;
    }
}