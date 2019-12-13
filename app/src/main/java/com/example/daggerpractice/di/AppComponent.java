package com.example.daggerpractice.di;


import android.app.Application;

import com.example.daggerpractice.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//need the module thing because we extended AndroidInjector
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        ViewModelFactoryModule.class
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    //if we are using the old way.
    ActivityBuildersModule.AuthActivitySubcomponent.Factory authSubcomponent();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);



        //overriding regular build and returning Appcomponent build
        AppComponent build();
    }
}
