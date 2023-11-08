package com.gt.gestexmobile.security;

import com.gt.gestexmobile.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiUser {
    @FormUrlEncoded
    @POST("login")
    Call<User> LOGIN_CALL(
            @Field("useDni") String useDni,
            @Field("usePassword") String usePassword
            );
}
