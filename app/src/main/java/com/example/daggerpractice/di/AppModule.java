package com.example.daggerpractice.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggerpractice.R;


import javax.inject.Singleton;

import androidx.core.content.ContextCompat;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    //dependency  to use glide
    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    //dependency for glide instance
    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    //dependency for drawable res for logo
    @Singleton
    @Provides
    static Drawable provideAppDrwable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.logo);
    }

}
