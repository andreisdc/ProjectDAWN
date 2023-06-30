package com.pontic_studio.myproperty.OwnerActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pontic_studio.myproperty.MainActivity.Fragments.LoginFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.Models.Property;
import com.pontic_studio.myproperty.R;
import com.pontic_studio.myproperty.adapter.PropertyAdapter;
import com.pontic_studio.myproperty.adapter.PropertyAdapterOwner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ownerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ownerFragment extends Fragment {

	private RecyclerView recyclerView;
	private PropertyAdapter adapter;
	private GridLayoutManager layoutManager;
	private TextView message;
	Button addButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ownerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ownerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ownerFragment newInstance(String param1, String param2) {
        ownerFragment fragment = new ownerFragment();
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
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		addButton = view.findViewById(R.id.buttonAddProperty);

		recyclerView = view.findViewById(R.id.propertyRecycleViewOwner);
		DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
		List<Property> listOfProperty = new ArrayList<>();
		String ownerName = dataBaseHelper.getOwnerNameByID(LoginFragment.ID);
		listOfProperty = dataBaseHelper.getPropertiesByID(ownerName);
		PropertyAdapterOwner adapter = new PropertyAdapterOwner(listOfProperty);

		message=view.findViewById(R.id.messageTextView);
		message.setText("Hello "+ownerName+"\nThis is your properties:");

		recyclerView.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		layoutManager=new GridLayoutManager(requireContext(), 2);
		recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setLayoutManager(layoutManager);

		// Add scroll listener to RecyclerView
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);

				if (dy > 0) {
					// Scrolling down
					int visibleItemCount = layoutManager.getChildCount();
					int totalItemCount = layoutManager.getItemCount();
					int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
				}
			}
		});
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Navigation.findNavController(v).navigate(R.id.addNewProperty2);
			}
		});

	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner, container, false);
    }
}
