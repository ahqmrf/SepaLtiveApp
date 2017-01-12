package com.example.lenovo.sepaltive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    Button imageSearch;
    EditText imageSearchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imageSearch = (Button) findViewById(R.id.bt_search_image);

        imageSearchKey = (EditText) findViewById(R.id.et_image_search_key);

        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ImageResultActivity.class);
                intent.putExtra("searchKey", imageSearchKey.getText().toString());

                startActivity(intent);
            }
        });
    }
}
