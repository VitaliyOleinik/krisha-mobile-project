package com.kbtu.krisha.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.kbtu.krisha.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class PostAdvertisementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_advertisement);

        //Start ProgressBar first (Set visibility VISIBLE)
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> {
            //Starting Write and Read data with URL
            //Creating array for parameters
            String[] field = new String[2];
            field[0] = "apartment";
            field[1] = "id";
            //Creating array for data
            String[] data = new String[2];
            data[0] = "apartment";
            data[1] = "id";
            PutData putData = new PutData("https://localhost/save", "POST", field, data);
            if (putData.startPut()) {
                if (putData.onComplete()) {
                    String result = putData.getResult();
                    //End ProgressBar (Set visibility to GONE)
                    Log.i("PutData", result);
                }
            }
            //End Write and Read data with URL
        });
    }
}