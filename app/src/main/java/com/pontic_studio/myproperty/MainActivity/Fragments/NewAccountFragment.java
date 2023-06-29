package com.pontic_studio.myproperty.MainActivity.Fragments;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pontic_studio.myproperty.ClientActivity.ClientActivity;
import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.Models.Client;
import com.pontic_studio.myproperty.Models.Owner;
import com.pontic_studio.myproperty.OwnerActivity.OwnerActivity;
import com.pontic_studio.myproperty.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewAccountFragment extends Fragment {

		EditText nameEditText;
		EditText surnameEditText;

		Button button;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewAccountFragment newInstance(String param1, String param2) {
        NewAccountFragment fragment = new NewAccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		nameEditText = view.findViewById(R.id.newAccountName);
		surnameEditText = view.findViewById(R.id.newAccountSurname);
		button = view.findViewById(R.id.buttonAddClient);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(nameEditText.getText().toString().isEmpty() == false && surnameEditText.getText().toString().isEmpty() == false)
				{
					DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
					SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

					if(dataBaseHelper.getStatusUser(LoginFragment.ID) == false)
					{
						Client client = new Client(1, nameEditText.getText().toString(), surnameEditText.getText().toString(), LoginFragment.ID);
						dataBaseHelper.addOne(client);
						Navigation.findNavController(v).navigate(R.id.loginFragment);

						Intent intent = new Intent(getContext(), ClientActivity.class);
						startActivity(intent);

					}else
					{
						Owner owner = new Owner(1, nameEditText.getText().toString(), surnameEditText.getText().toString(), LoginFragment.ID);
						dataBaseHelper.addOne(owner);
						Navigation.findNavController(v).navigate(R.id.loginFragment);

						Intent intent = new Intent(getContext(), OwnerActivity.class);
						startActivity(intent);
					}



				}

			}
		});




	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_account, container, false);

    }
}
