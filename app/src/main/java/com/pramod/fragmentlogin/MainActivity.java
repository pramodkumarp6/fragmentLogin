package com.pramod.fragmentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.pramod.fragmentlogin.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
  ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
         setContentView(view);


        getSupportActionBar().hide();


        SystemClock.sleep(3000);
                    Intent intent =new Intent(MainActivity.this,RegisterActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


    }
    }

