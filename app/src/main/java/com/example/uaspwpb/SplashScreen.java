package com.example.uaspwpb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadingApp();
                toHome();
                finish();
            }
        }).start();
    }

    private void loadingApp(){
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("ERROR",e.getMessage());
            }
        }
    }

    private void toHome(){
        Intent homie = new Intent(SplashScreen.this,LihatData.class);
        startActivity(homie);
    }
}
