package com.pramod.fragmentlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.pramod.fragmentlogin.databinding.ActivityMainBinding;
import com.pramod.fragmentlogin.databinding.ActivityRegisterBinding;
import com.pramod.fragmentlogin.fragmentActivity.LoginFragment;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding activityRegisterBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = activityRegisterBinding.getRoot();
        setContentView(view);
         getSupportActionBar().setTitle("Login");

        setFragement(new LoginFragment());
    }

    private void setFragement(Fragment fragement) {

         FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
         fragmentTransaction.replace (activityRegisterBinding.registerFrameLayout.getId(),fragement);
         fragmentTransaction.commit();
    }
}