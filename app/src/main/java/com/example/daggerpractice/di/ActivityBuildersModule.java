package com.example.daggerpractice.di;


import com.example.daggerpractice.AuthActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();


    //example
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
}
