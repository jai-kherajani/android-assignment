package com.example.assignment.network;

import com.example.assignment.model.Attribute;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ResponseApi {

    @GET("api/marketplace/v1/products/{id}")
    Call<ResponseBody> getAttribute(@Path("id") int id);
}
