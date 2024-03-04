package com.example.newsapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("top-headlines?country=us&apiKey=61e2181d273346578823cc7a3474b048")
    Call<ObjectModel> getCategory(@Query("category") String category);

}
