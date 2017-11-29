package com.footinit.baseavd.di.module;

import android.app.Application;
import android.content.Context;

import com.footinit.baseavd.R;
import com.footinit.baseavd.data.AppDataManager;
import com.footinit.baseavd.data.DataManager;
import com.footinit.baseavd.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Abhijit on 29-11-2017.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context providesContext() {
        return application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    DataManager providesDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    CalligraphyConfig providesCalligraphyConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/fonts.source-sans-pro/SourceSansPro-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
