package com.pontic_studio.myproperty.OwnerActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.pontic_studio.myproperty.R;

public class AddNewProperty extends Fragment {
    private TextView name;
    private TextView adress;
    private TextView price;
    private Spinner status;
    private Spinner type;
    private TextView description;
    private Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_new_property, container, false);
        name=rootView.findViewById(R.id.propertyNameTextView);
        adress=rootView.findViewById(R.id.propertyAdressTextView);
        price=rootView.findViewById(R.id.propertyPriceTextView);
        status=rootView.findViewById(R.id.statusSpinner);
        type=rootView.findViewById(R.id.typeSpinner);
        description=rootView.findViewById(R.id.propertyDescriptionTextView);
        addButton=rootView.findViewById(R.id.addButton);


        return rootView;
    }
}