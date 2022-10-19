package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("posts")
    Call<List<postpojo>>getpost();
}
