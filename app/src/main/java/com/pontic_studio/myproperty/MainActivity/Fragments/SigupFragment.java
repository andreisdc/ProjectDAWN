package com.pontic_studio.myproperty.MainActivity.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.Models.User;
import com.pontic_studio.myproperty.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SigupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SigupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SigupFragment newInstance(String param1, String param2) {
        SigupFragment fragment = new SigupFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sigup, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton buttonClinetSelect=view.findViewById(R.id.clientButton);
        ImageButton buttonOwnerSelect=view.findViewById(R.id.ownerButton);

        Button buttonSignUp=view.findViewById(R.id.signInButtonChangeView);

        EditText usernameEditText=view.findViewById(R.id.signupTextUsername);
        EditText passwordEditText=view.findViewById(R.id.signupTextPassword);

        TextView messageText=view.findViewById(R.id.customMessageTextView);

        ImageView clientImageView=view.findViewById(R.id.clientImageView);
        ImageView ownerImageView=view.findViewById(R.id.ownerImageView);
        messageText.setText("");
        clientImageView.setVisibility(View.INVISIBLE);
        ownerImageView.setVisibility(View.INVISIBLE);

			buttonClinetSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText.setText(R.string.customMessageForClient);
                clientImageView.setVisibility(View.VISIBLE);
                ownerImageView.setVisibility(View.INVISIBLE);
            }
        });

			buttonOwnerSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText.setText(R.string.customMessageForOwner);
                clientImageView.setVisibility(View.INVISIBLE);
                ownerImageView.setVisibility(View.VISIBLE);
            }
        });
			buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                messageText.setText(usernameEditText.getText());
                if(((usernameEditText.getText()).toString()).isEmpty() || ((passwordEditText.getText()).toString()).isEmpty())
                {
                    usernameEditText.setHintTextColor(Color.RED);
                    passwordEditText.setHintTextColor(Color.RED);
                }
                else {
                    if(clientImageView.getVisibility()==View.VISIBLE || ownerImageView.getVisibility()==View.VISIBLE)
                    {
											boolean isOwner;
											if(clientImageView.getVisibility() == View.VISIBLE)
											{
												isOwner = false;
											}
											else
											{
												isOwner = true;
											}
											User user = new User(1,usernameEditText.getText().toString(),passwordEditText.getText().toString(), isOwner);
											DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
											boolean succes = 	dataBaseHelper.addOne(user);

											Navigation.findNavController(v).navigate(R.id.mainFragment);
											Toast.makeText(getActivity(), "SUCCES+ " + succes, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
