package com.pramod.fragmentlogin.fragmentActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pramod.fragmentlogin.R;
import com.pramod.fragmentlogin.databinding.FragmentUserforgetBinding;


public class UserforgetFragment extends Fragment {

   FragmentUserforgetBinding fragmentUserforgetBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_userforget, container, false);
    }
}