package com.example.daggerpractice.di;


import com.example.daggerpractice.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

    //could also be like this
//    @Provides
//    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory factory){
//        return factory;
//    }

}
