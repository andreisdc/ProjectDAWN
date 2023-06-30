package com.pontic_studio.myproperty.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.pontic_studio.myproperty.Models.Property;
import com.pontic_studio.myproperty.R;

import java.util.List;

public class PropertyAdapterOwner extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Property> movies;
    private int itemsPerRow;

    public PropertyAdapterOwner(List<Property> movies) {
        this.movies = movies;
        this.itemsPerRow=2;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_model, parent, false);


//        Log.e("Adapter", "onCreateViewHolder movie");

//        int screenWidth = parent.getContext().getResources().getDisplayMetrics().widthPixels;
//        int itemWidth = screenWidth / itemsPerRow;

//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.width = itemWidth;
//        view.setLayoutParams(layoutParams);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_model, parent, false);
//        int screenWidth = parent.getContext().getResources().getDisplayMetrics().widthPixels;
//        int itemWidth = screenWidth / itemsPerRow;
//        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
//        layoutParams.width = itemWidth;
//        itemView.setLayoutParams(layoutParams);
//        return new MovieViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MovieViewHolder) {
            Property movieModel = (Property) movies.get(position);

            ImageView currentElementImage=holder.itemView.findViewById(R.id.propertyImage);

            ((MovieViewHolder)holder).bind(movieModel);
            ViewGroup.LayoutParams params = currentElementImage.getLayoutParams();
            params.width = 300; // Set the desired width
            params.height = 200; // Set the desired height
            currentElementImage.setLayoutParams(params);
            if(!movieModel.isType().equals("Casa"))
            {
                currentElementImage.setBackgroundResource(R.drawable.building_image);
            }
            else {
                currentElementImage.setBackgroundResource(R.drawable.house_image);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController = Navigation.findNavController(v);
                    Bundle bundle = new Bundle();
                    bundle.putString("property_name", movieModel.getPropertyName());
                    bundle.putString("property_price",movieModel.getPrice());
                    bundle.putString("property_adress", movieModel.getAddress());
                    bundle.putString("property_owner", movieModel.getOwnerName());
                    bundle.putString("property_description", movieModel.getDescription());
                    bundle.putString("property_status", movieModel.getStatus());
                    bundle.putString("property_type", movieModel.isType());

//                    String message = movieModel.getPropertyName();
//                    Bundle bundle = new Bundle();
//                    bundle.putString("message", message);
                    navController.navigate(R.id.propertyDetailsFragment2, bundle);
                }
            });
        }

//        Log.e("Adapter", "onBindViewHolder; position=" + position);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }



    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView propertyImage;
        TextView propertyNameTextView;
        TextView propertyPriceTextView;
        TextView propertyAdressTextView;
        TextView ownerNameTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            propertyImage=itemView.findViewById(R.id.propertyImage);
            propertyNameTextView = itemView.findViewById(R.id.propertyName);
            propertyPriceTextView = itemView.findViewById(R.id.propertyPrice);
            propertyAdressTextView = itemView.findViewById(R.id.propertyAdress);
            ownerNameTextView = itemView.findViewById(R.id.propertyOwner);
        }

        public void bind(Property movieModel) {

            propertyNameTextView.setText(movieModel.getPropertyName());
            propertyPriceTextView.setText(movieModel.getPrice()+" euro");
            propertyAdressTextView.setText(movieModel.getAddress());
            ownerNameTextView.setText(movieModel.getOwnerName());
        }
    }
}
