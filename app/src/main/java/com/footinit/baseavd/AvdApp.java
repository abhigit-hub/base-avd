package com.footinit.baseavd;

import android.app.Application;

import com.footinit.baseavd.di.component.ApplicationComponent;
import com.footinit.baseavd.di.component.DaggerApplicationComponent;
import com.footinit.baseavd.di.module.ApplicationModule;

import javax.inject.Inject;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Abhijit on 28-11-2017.
 */

public class AvdApp extends Application {

    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Instantiate ApplicationComponent
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        CalligraphyConfig.initDefault(calligraphyConfig);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
