package com.example.lenovo.sepaltive;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Lenovo on 1/12/2017.
 */

public interface PixaBayAPI {
    @GET("api/")
    Call<ImageData> getImages(
            @QueryMap Map<String, String> options
    );
}
