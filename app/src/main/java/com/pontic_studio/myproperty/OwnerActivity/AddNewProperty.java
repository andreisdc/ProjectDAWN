package com.pontic_studio.myproperty.OwnerActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.MainActivity.Fragments.LoginFragment;
import com.pontic_studio.myproperty.Models.Property;
import com.pontic_studio.myproperty.R;

public class AddNewProperty extends Fragment {
    private EditText name;
    private EditText adress;
    private EditText price;
    private Spinner status;
    private Spinner type;
    private EditText description;
    private Button addButton;

    @SuppressLint("MissingInflatedId")
		@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_new_property, container, false);
        name=rootView.findViewById(R.id.nameEditText);
        adress=rootView.findViewById(R.id.adressEditText);
        price=rootView.findViewById(R.id.priceEditText);
        status=rootView.findViewById(R.id.statusSpinner);
        type=rootView.findViewById(R.id.typeSpinner);
        description=rootView.findViewById(R.id.descriptionEditText);
        addButton=rootView.findViewById(R.id.addButton);

				addButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if(name.getText().toString().isEmpty() == false && adress.getText().toString().isEmpty() == false && price.getText().toString().isEmpty() == false && description.getText().toString().isEmpty() == false)
						{
							DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
							String ownerName = dataBaseHelper.getOwnerNameByID(LoginFragment.ID);
							Property property = new Property(1,name.getText().toString(),ownerName,adress.getText().toString(),price.getText().toString(),status.getSelectedItem().toString(),type.getSelectedItem().toString(),description.getText().toString());
							dataBaseHelper.addOne(property);
							Log.e("TYPE: ", type.getSelectedItem().toString());
							Navigation.findNavController(v).navigate(R.id.ownerFragment4);
						}
					}
				});


        return rootView;
    }
}
