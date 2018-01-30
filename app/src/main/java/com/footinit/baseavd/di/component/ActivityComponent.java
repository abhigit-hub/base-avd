package com.footinit.baseavd.di.component;

import com.footinit.baseavd.di.PerActivity;
import com.footinit.baseavd.di.module.ActivityModule;
import com.footinit.baseavd.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Abhijit on 29-11-2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
