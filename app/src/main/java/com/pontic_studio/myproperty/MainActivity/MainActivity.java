package com.pontic_studio.myproperty.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.pontic_studio.myproperty.DataBaseHelper;
import com.pontic_studio.myproperty.Models.User;
import com.pontic_studio.myproperty.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
