package com.example.daggerpractice.ui.auth;

import android.util.Log;

import com.example.daggerpractice.network.auth.AuthApi;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        if(this.authApi==null){
            Log.d(TAG, "Auth Api is null");
        }else{
            Log.d(TAG, "Auth api is not null");
        }
        Log.d(TAG, "View model injected");
    }

}
