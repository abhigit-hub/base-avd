package com.footinit.baseavd.ui.base;


import com.footinit.baseavd.data.DataManager;
import com.footinit.baseavd.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Abhijit on 08-11-2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;
    private DataManager dataManager;

    private V mvpView;

    public BasePresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable,
                         DataManager dataManager) {
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        this.mvpView = null;
    }

    public V getMvpView() {
        return mvpView;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }
}
