package com.example.testnetworkcontent_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private TextView tv;
    private ImageView iv;
    private ConnectivityManager connManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.button);
        bt1.setOnClickListener(v -> {
            System.out.println("Hola boto 1");
        });
        bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(v -> {
            System.out.println("Hola boto 2");
        });
        tv = findViewById(R.id.textView);
        iv = findViewById(R.id.imageView);

        connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        checkNetwork();
    }

    private void checkNetwork() {
        NetworkInfo netInfo = connManager.getActiveNetworkInfo();
        String message = null;
        if(netInfo != null && netInfo.isConnected()) {
            if(netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                message = "Wifi connected!";
            }
            else if(netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                message = "Mobile connected!";
            }
        }
        else {
            message = "No network operating!";
        }
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    private class AsyncTaskRunnerText extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    private class AsyncTaskRunnerImage extends AsyncTask<String, String, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }
    }
}