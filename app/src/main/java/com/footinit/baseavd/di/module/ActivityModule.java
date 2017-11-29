package com.footinit.baseavd.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.footinit.baseavd.di.ActivityContext;
import com.footinit.baseavd.di.PerActivity;
import com.footinit.baseavd.ui.main.MainMvpPresenter;
import com.footinit.baseavd.ui.main.MainMvpView;
import com.footinit.baseavd.ui.main.MainPresenter;
import com.footinit.baseavd.utils.rx.AppSchedulerProvider;
import com.footinit.baseavd.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Abhijit on 29-11-2017.
 */

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }

    @Provides
    AppCompatActivity providesActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable providesCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider providesSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> providesMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}
