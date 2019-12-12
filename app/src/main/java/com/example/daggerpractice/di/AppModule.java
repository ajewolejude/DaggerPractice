package com.example.daggerpractice.di;

import android.app.Application;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    //provides is for creating dependencies
    //documentations says we shpuld use static for dependencies.
    @Provides
    @Named("someString1")
    static String someString(){
        return "This is a test string";
    }

    @Provides
    @Named("someString2")
    static String someString2(){
        return "This is a test string2";
    }

    //false because we passed application in BindInstance in AppComponent
    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }


}
