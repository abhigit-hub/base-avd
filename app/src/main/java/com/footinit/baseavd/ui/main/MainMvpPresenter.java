package com.footinit.baseavd.ui.main;

import com.footinit.baseavd.di.PerActivity;
import com.footinit.baseavd.ui.base.MvpPresenter;

/**
 * Created by Abhijit on 28-11-2017.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
}
