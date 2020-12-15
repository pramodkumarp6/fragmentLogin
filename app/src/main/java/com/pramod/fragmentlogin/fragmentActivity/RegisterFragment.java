package com.pramod.fragmentlogin.fragmentActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pramod.fragmentlogin.R;
import com.pramod.fragmentlogin.app.RetrofitClient;
import com.pramod.fragmentlogin.databinding.FragmentRegisterBinding;
import com.pramod.fragmentlogin.model.loginModel.registerModel.RegisterResponse;
import com.pramod.fragmentlogin.model.loginModel.registerModel.RegisterSender;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterFragment extends Fragment {

    FragmentRegisterBinding fragmentRegisterBinding;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentRegisterBinding = FragmentRegisterBinding.inflate(inflater, container, false);


        View view = fragmentRegisterBinding.getRoot();




        fragmentRegisterBinding.registerid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });






        return view;

    }

    private void register(){

        progressDialog = new ProgressDialog(getActivity());
        String name = fragmentRegisterBinding.editTextName.getText().toString().trim();
        String lastname = fragmentRegisterBinding.editTextLastname.getText().toString().trim();
        String email = fragmentRegisterBinding.editTextLastname.getText().toString().trim();
        String password = fragmentRegisterBinding.editTextPassword.getText().toString().trim();
        String mobile = fragmentRegisterBinding.editTextMobile.getText().toString().trim();
        String gender = fragmentRegisterBinding.edittextGender.getText().toString().trim();
        String country = fragmentRegisterBinding.edittextCountry.getText().toString().trim();
        String state = fragmentRegisterBinding.edittextState.getText().toString().trim();
        String city = fragmentRegisterBinding.edittextCity.getText().toString().trim();
        String address = fragmentRegisterBinding.edittextAddress.getText().toString().trim();
        RegisterSender registerSender = new RegisterSender(name, lastname, email, password, mobile, gender, country, state, city, address);


        progressDialog.show();
        Call<RegisterResponse> call = RetrofitClient.getInstance().getApi().userRegister(registerSender);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                progressDialog.hide();

                if(registerResponse.getStatus() == 200){
                    Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });


    }
}