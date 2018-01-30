package com.footinit.baseavd.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.footinit.baseavd.R;
import com.footinit.baseavd.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Abhijit on 28-11-2017.
 */

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;


    @BindView(R.id.iv_chrome)
    AppCompatImageView ivChrome;

    @BindView(R.id.iv_tea)
    AppCompatImageView ivTea;

    @BindView(R.id.iv_path)
    AppCompatImageView ivPath;

/*
    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        setUpAnimation();
    }


    @OnClick(R.id.iv_chrome)
    void onChromeClicked() {
        setUpAnimation1();
    }

    @OnClick(R.id.iv_tea)
    void onTeaClicked() {
        setUpAnimation2();
    }

    @OnClick(R.id.iv_path)
    void onPathClicked() {
        setUpAnimation3();
    }

    private void setUpAnimation() {
        setUpAnimation1();
        setUpAnimation2();
        setUpAnimation3();
    }

    private void setUpAnimation1() {
        Drawable drawable = ivChrome.getDrawable();

        if (drawable != null && drawable instanceof Animatable)
            ((Animatable) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawableCompat)
            ((AnimatedVectorDrawableCompat) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawable)
            ((AnimatedVectorDrawable) drawable).start();
    }

    private void setUpAnimation2() {
        Drawable drawable = ivTea.getDrawable();

        if (drawable != null && drawable instanceof Animatable)
            ((Animatable) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawableCompat)
            ((AnimatedVectorDrawableCompat) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawable)
            ((AnimatedVectorDrawable) drawable).start();
    }

    private void setUpAnimation3() {
        Drawable drawable = ivPath.getDrawable();

        if (drawable != null && drawable instanceof Animatable)
            ((Animatable) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawableCompat)
            ((AnimatedVectorDrawableCompat) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawable)
            ((AnimatedVectorDrawable) drawable).start();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}