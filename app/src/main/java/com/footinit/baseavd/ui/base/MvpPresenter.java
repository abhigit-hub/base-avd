package com.footinit.baseavd.ui.base;


/**
 * Created by Abhijit on 08-11-2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
