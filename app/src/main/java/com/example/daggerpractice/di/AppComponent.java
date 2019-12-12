package com.example.daggerpractice.di;


import android.app.Application;

import com.example.daggerpractice.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//singleton annotation is to tell dagger that dependency should persis in memory
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);


        //overriding regular build and returning Appcomponent build
        AppComponent build();
    }
}
