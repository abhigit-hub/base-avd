package com.footinit.baseavd.di.component;

import android.app.Application;
import android.content.Context;

import com.footinit.baseavd.data.DataManager;
import com.footinit.baseavd.di.ApplicationContext;
import com.footinit.baseavd.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Abhijit on 29-11-2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();
}
