package com.example.lenovo.sepaltive;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BigImageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bigImageView;
    private Button downloadButton;
    private ImageDataParcelable imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);

        bigImageView = (ImageView) findViewById(R.id.iv_big_image);
        downloadButton = (Button) findViewById(R.id.bt_download);
        downloadButton.setOnClickListener(this);

        imageData = getIntent().getParcelableExtra("imageData");

        Picasso.with(this).load(imageData.getPreviewURL()).resize(imageData.getImageWidth(), imageData.getImageHeight())
                .centerCrop().into(bigImageView);
    }

    @Override
    public void onClick(View v) {
        new DownloadTask().execute();
    }

    public class DownloadTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL url = new URL(imageData.getPreviewURL());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");
                connection.connect();

                File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "sepaltive");
                if(!directory.exists()) {
                    directory.mkdirs();
                }
                String[] values = imageData.getPreviewURL().split("/");
                String fileName = values[values.length - 1];
                File file = new File(directory, fileName);
                file.createNewFile();
                InputStream inputStream = connection.getInputStream();
                FileOutputStream output = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int byteCount = 0;

                while((byteCount = inputStream.read(buffer)) > 0) {
                    output.write(buffer, 0, byteCount);
                }

                output.close();
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.parse(imageData.getPreviewURL()));
                getApplicationContext().sendBroadcast(intent);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Download complete", Toast.LENGTH_SHORT).show();
        }
    }
}
