package com.example.lenovo.sepaltive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageResultActivity extends AppCompatActivity {

    private static final String TAG = "ImageResultActivity";

    private TextView totalHits;
    private EditText searchText;
    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ImageData.HitsBean> images;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_result);

        totalHits = (TextView) findViewById(R.id.tv_hits);
        searchText = (EditText) findViewById(R.id.searchKey);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_image);
        searchButton = (Button) findViewById(R.id.bt_search_again);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doInBackground(2);
            }
        });

        doInBackground(1);
    }

    private void doInBackground(int type) {
        OkHttpClient okClient = new OkHttpClient.Builder().addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().
                                newBuilder().
                                addHeader("Accept", "Application/JSON").build();
                        return chain.proceed(request);
                    }
                }
        ).build();

        Retrofit retrofitRef = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PixaBayAPI service = retrofitRef.create(PixaBayAPI.class);
        Map<String, String> data = new HashMap<>();
        data.put("key", Constants.API_KEY);
        if(type == 1) data.put("q", getSearchKey(getIntent().getStringExtra("searchKey")));
        else data.put("q", getSearchKey(searchText.getText().toString()));
        data.put("image_type", "photo");

        Call<ImageData> call = service.getImages(data);
        call.enqueue(new Callback<ImageData>() {
            @Override
            public void onResponse(Call<ImageData> call, retrofit2.Response<ImageData> response) {
                Log.d(TAG, "onResponse: " + response.code());

                if(response.isSuccessful()) {
                    images = new ArrayList<>();
                    ImageData result = response.body();
                    images = result.getHits();
                    adapter = new ImageAdapter(images, getApplicationContext());
                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    totalHits.setText("Total hits: " + result.getTotalHits());
                    searchText.setText(getIntent().getStringExtra("searchKey"));
                }
            }

            @Override
            public void onFailure(Call<ImageData> call, Throwable t) {

            }
        });
    }

    private String getSearchKey(String initialKey) {
        String searchKey = "";
        String [] keys = initialKey.split(" ");
        if(keys.length > 0) {
            searchKey = keys[0];
            for (int i = 1; i < keys.length; i++) {
                searchKey = searchKey + "+" + keys[i];
            }
        }

        return searchKey;
    }
}
