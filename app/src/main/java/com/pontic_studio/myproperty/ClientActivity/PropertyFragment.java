package com.pontic_studio.myproperty.ClientActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.Models.Client;
import com.pontic_studio.myproperty.Models.Property;
import com.pontic_studio.myproperty.R;
import com.pontic_studio.myproperty.adapter.PropertyAdapter;

import java.util.ArrayList;
import java.util.List;

public class PropertyFragment extends Fragment {

		Client client;

    private RecyclerView recyclerView;
    private PropertyAdapter adapter;
    private GridLayoutManager layoutManager;
    private TextView message;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property, container, false);

        return view;
    }
    private void animateOnScrollDown() {
        TransitionManager.beginDelayedTransition(recyclerView, new Slide());
        // Apply your desired animation to the elements in the RecyclerView
        // For example, you can change the visibility, alpha, or translation of the elements
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.propertyRecycleView);
			DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        List<Property> listOfProperty = new ArrayList<>();
				listOfProperty = dataBaseHelper.getProperties();
       PropertyAdapter adapter = new PropertyAdapter(listOfProperty);
        recyclerView.setAdapter(adapter);
				message = view.findViewById(R.id.messageTextView);
        message.setText("Hello!\nThese are all available properties:");

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

                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        // Reached the bottom of the list, apply animation
                        animateOnScrollDown();
                    }
                }
            }
        });
    }
}
