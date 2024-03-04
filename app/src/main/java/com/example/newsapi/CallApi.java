package com.example.newsapi;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallApi {
    static ArrayList<Articles> mList;
    static ObjectModel objectModel;
    static Adapter adapter;
    static  ApiService apiInterface;
    public static void displayApiData(RecyclerView recyclerView,
                                      ProgressBar progressBar,
                                      String category )
    {
        apiInterface = ApiClient.getClient().create(ApiService.class);

        Call<ObjectModel> call = apiInterface.getCategory(category);
        call.enqueue(new Callback<ObjectModel>() {
            @Override
            public void onResponse(Call<ObjectModel> call, Response<ObjectModel> response) {
                if(response.isSuccessful()){
                    objectModel = response.body();
                    if(objectModel.getTotalResults()==0){
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    else{
                        mList = (ArrayList<Articles>) objectModel.getList();
                        for(int i=0;i<mList.size();i++) {
                            Log.d("RESPONSE IS SUCCESSFULL for TITLE",mList.get(i).getTitle());
                            Log.d("RESPONSE IS SUCCESSFULL for Name",mList.get(i).getSource().getName());
                            Log.d("RESPONSE IS SUCCESSFULL FOR CONTENT","NULL"+mList.get(i).getContent());
                            Log.d("RESPONSE IS SUCCESSFULL FOR AUTHOR","NULL"+mList.get(i).getAuthor());
                            Log.d("RESPONSE IS SUCCESSFULL FOR PUBLISHED",mList.get(i).getPublishedAt());
//                            Log.d("RESPONSE IS SUCCESSFULL FOR DESCRIPTION",mList.get(i).getDescription());

                        }
                        adapter = new Adapter(mList);
                        recyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            }
            @Override
            public void onFailure(Call<ObjectModel> call, Throwable t) {
                Log.d("FAILURE OF FETCHING THE DATA FROM API","BECAUSE "+t.getMessage());
            }
        });
    }
}
