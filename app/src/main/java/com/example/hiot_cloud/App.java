package com.example.hiot_cloud;

import android.app.Application;

import com.example.hiot_cloud.injection.component.ApplicationComponent;
import com.example.hiot_cloud.injection.module.ApplicationModule;

import com.example.hiot_cloud.injection.component.DaggerApplicationComponent;


/**
 * 所有程序的入口
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}

