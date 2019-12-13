package com.example.daggerpractice.di.auth;


import com.example.daggerpractice.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retofit){
        return retofit.create(AuthApi.class);
    }
}