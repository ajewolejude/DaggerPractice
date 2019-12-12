package com.example.daggerpractice;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.support.DaggerAppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";


    //if you use named annotation you can pass two strings

    @Inject
    @Named("someString1")
    String message;

    @Inject
    @Named("someString2")
    String message2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_main);

        Log.d(TAG, "Oncreate: "+ message);
        Log.d(TAG, "Oncreate: "+ message2);

    }
}
