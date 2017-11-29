package com.footinit.baseavd.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.footinit.baseavd.AvdApp;
import com.footinit.baseavd.R;
import com.footinit.baseavd.di.component.ActivityComponent;
import com.footinit.baseavd.di.component.DaggerActivityComponent;
import com.footinit.baseavd.di.module.ActivityModule;
import com.footinit.baseavd.utils.CommonUtils;
import com.footinit.baseavd.utils.NetworkUtils;

import butterknife.Unbinder;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Abhijit on 08-11-2017.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback {

    private ProgressDialog progressDialog;
    private Unbinder unBinder;
    private ActivityComponent activityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Instantiate ActivityComponent
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AvdApp) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.cancel();
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void showMessage(String message) {
        if (message != null)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, R.string.some_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(int resID) {
        showMessage(getString(resID));
    }

    @Override
    public void onError(String message) {
        if (message != null)
            showSnackbar(message);
        else showSnackbar(getString(R.string.some_error));
    }

    @Override
    public void onError(int resID) {
        onError(getString(resID));
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (NetworkUtils.isNetworkConnected(getApplicationContext()))
            return true;
        else {
            onError("No Internet");
            return false;
        }
    }

    private void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_SHORT);

        View view = snackbar.getView();

        TextView snackTV = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        snackTV.setTextColor(ContextCompat.getColor(this, R.color.white));

        snackbar.show();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setUnBinder(Unbinder unBinder) {
        this.unBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        if (unBinder != null)
            unBinder.unbind();
        super.onDestroy();
    }

    protected abstract void setUp();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
