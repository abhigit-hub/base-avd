package com.footinit.baseavd.ui.main;

import com.footinit.baseavd.data.DataManager;
import com.footinit.baseavd.ui.base.BasePresenter;
import com.footinit.baseavd.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Abhijit on 28-11-2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {


    @Inject
    public MainPresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable,
                         DataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }
}
