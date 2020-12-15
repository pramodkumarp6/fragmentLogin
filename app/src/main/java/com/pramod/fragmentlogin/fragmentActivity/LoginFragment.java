package com.pramod.fragmentlogin.fragmentActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.pramod.fragmentlogin.R;
import com.pramod.fragmentlogin.app.RetrofitClient;
import com.pramod.fragmentlogin.databinding.FragmentLoginBinding;
import com.pramod.fragmentlogin.model.LoginResponse;
import com.pramod.fragmentlogin.model.LoginSender;
import com.pramod.fragmentlogin.navigation.DashBoard;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
  private  FragmentLoginBinding fragmentLoginBinding;
   private ProgressDialog progressDialog;
   private FrameLayout p;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = fragmentLoginBinding.getRoot();

        p = getActivity().findViewById(R.id.register_frameLayout);



        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentLoginBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        fragmentLoginBinding.textViewRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setregisterFragment(new RegisterFragment());

            }
        });

        fragmentLoginBinding.textViewRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setforgetUserFragment(new UserforgetFragment());
            }
        });

    }


    private void setregisterFragment (Fragment fragment){

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace (p.getId(),fragment);
        fragmentTransaction.commit();
    }

        private void setforgetUserFragment (Fragment fragment){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(p.getId(), fragment);
            fragmentTransaction.commit();

        }


        private void Login(){
        progressDialog = new ProgressDialog(getActivity());

        final String email = fragmentLoginBinding.editTextemail.getText().toString();
        final String password = fragmentLoginBinding.editTextPassword.getText().toString();
        if(email.isEmpty()){
            Toast.makeText(getActivity(),"Enter email ",Toast.LENGTH_LONG).show();

            return;
        }


            if(password.isEmpty()){
                Toast.makeText(getActivity(),"Entter password",Toast.LENGTH_LONG).show();

                return;
            }




            progressDialog.show();
            progressDialog.setMessage("loding");

            LoginSender loginSender = new LoginSender(email,password);

            Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(loginSender);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                      progressDialog.hide();
                    LoginResponse loginResponse = response.body();
                    if(loginResponse.getStatus() == 200){
                        Intent intent = new Intent(getActivity(), DashBoard.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getActivity(),"Email or Password is not  valid",Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });



        }



    }
