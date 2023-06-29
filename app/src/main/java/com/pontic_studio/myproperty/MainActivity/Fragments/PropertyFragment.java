package com.pontic_studio.myproperty.MainActivity.Fragments;

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

import com.pontic_studio.myproperty.Models.Property;
import com.pontic_studio.myproperty.R;
import com.pontic_studio.myproperty.adapter.PropertyAdapter;

import java.util.ArrayList;
import java.util.List;

public class PropertyFragment extends Fragment {

    private RecyclerView recyclerView;
    private PropertyAdapter adapter;
    private GridLayoutManager layoutManager;
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

        List<Property> movies = new ArrayList<>();
        movies.add(new Property("Casa1","Alex","Sighisoara", "200","liber",false,"Descriere1"));
        movies.add(new Property("Casa2","Andrei","Constanta", "300","liber",false,"Descriere2"));
        movies.add(new Property("Casa3","Denis","Brasov", "100","ocupat",false,"Descriere3"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));
        movies.add(new Property("Casa4","Mihai","Bucuresti", "500","ocupat",true,"Descriere4"));

        PropertyAdapter adapter = new PropertyAdapter(movies);

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

                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        // Reached the bottom of the list, apply animation
                        animateOnScrollDown();
                    }
                }
            }
        });
    }
}