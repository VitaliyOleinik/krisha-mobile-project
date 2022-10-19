 package com.kbtu.krisha.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kbtu.krisha.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_main);

        Button to_sign_up = findViewById(R.id.signUp);

        to_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //Start ProgressBar first (Set visibility VISIBLE)
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> {
            //Starting Write and Read data with URL
            //Creating array for parameters
            String[] field = new String[2];
            field[0] = "email";
            field[1] = "password";
            //Creating array for data
            String[] data = new String[4];
            data[0] = "email";
            data[1] = "password";
            PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
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
