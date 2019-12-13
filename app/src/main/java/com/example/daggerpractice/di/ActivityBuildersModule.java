package com.example.daggerpractice.di;


import com.example.daggerpractice.di.auth.AuthViewModelsModule;
import com.example.daggerpractice.ui.auth.AuthActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuildersModule {

    //AuthActivity Subcomponent.. can be found in generated file
//    @ContributesAndroidInjector(modules =
//            {AuthViewModelsModule.class})
//    abstract AuthActivity contributeAuthActivity();


    //there is  something important in AppComponent


    @Binds
    @IntoMap
    @ClassKey(AuthActivity.class)
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory( AuthActivitySubcomponent.Factory builder);

    @Subcomponent(modules = AuthViewModelsModule.class)
    public interface AuthActivitySubcomponent extends AndroidInjector<AuthActivity> {
        @Subcomponent.Factory
        interface Factory extends AndroidInjector.Factory<AuthActivity> {}
    }

}
