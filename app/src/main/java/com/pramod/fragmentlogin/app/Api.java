package com.pramod.fragmentlogin.app;

import com.pramod.fragmentlogin.model.LoginResponse;
import com.pramod.fragmentlogin.model.LoginSender;
import com.pramod.fragmentlogin.model.loginModel.forgetModel.UserForgetResponse;
import com.pramod.fragmentlogin.model.loginModel.forgetModel.UserForgetSender;
import com.pramod.fragmentlogin.model.loginModel.registerModel.RegisterResponse;
import com.pramod.fragmentlogin.model.loginModel.registerModel.RegisterSender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("api/public/login")
    Call<LoginResponse>userLogin(@Body LoginSender loginSender);

    @POST("api/public/register")
    Call<RegisterResponse>userRegister(@Body RegisterSender registerSender);

    @POST("api/public/forget")
    Call<UserForgetResponse>userForget(@Body UserForgetSender userForgetSender);
}
