package com.example.daggerpractice.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggerpractice.R;
import com.example.daggerpractice.util.Constants;


import javax.inject.Singleton;

import androidx.core.content.ContextCompat;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    //EVERYTHING THAT WILL EXIST FOR THE ENTIRE TIME OF THE APPLICATION

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    //dependency  to use glide
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    //dependency for glide instance
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    //dependency for drawable res for logo
    @Provides
    static Drawable provideAppDrwable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.logo);
    }

}
