package com.footinit.baseavd.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Abhijit on 08-11-2017.
 */

public interface MvpView {

    void hideLoading();

    void showLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resID);

    void onError(String message);

    void onError(@StringRes int resID);

    void hideKeyboard();

    boolean isNetworkConnected();
}
