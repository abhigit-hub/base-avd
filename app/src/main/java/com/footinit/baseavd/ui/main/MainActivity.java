package com.footinit.baseavd.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.footinit.baseavd.R;
import com.footinit.baseavd.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

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

    @Inject
    MainListAdapter adapter;

    @Inject
    LinearLayoutManager layoutManager;


    @BindView(R.id.avd_rv)
    RecyclerView avdRV;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

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
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        avdRV.setLayoutManager(layoutManager);
        avdRV.setItemAnimator(new DefaultItemAnimator());
        avdRV.setAdapter(adapter);
        adapter.addItems(prepareAVDList());
    }

    private List<Drawable> prepareAVDList() {
        List<Drawable> list = new ArrayList<Drawable>();

        list.add(getResources().getDrawable(R.drawable.avd_browser_enhanced));
        list.add(getResources().getDrawable(R.drawable.avd_briefcase));
        list.add(getResources().getDrawable(R.drawable.avd_start_tracking));
        list.add(getResources().getDrawable(R.drawable.avd_stop_tracking));
        list.add(getResources().getDrawable(R.drawable.avd_path));
        list.add(getResources().getDrawable(R.drawable.avd_tea));

        return list;
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
