package com.footinit.baseavd.data;

import android.content.Context;

import com.footinit.baseavd.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Abhijit on 28-11-2017.
 */

@Singleton
public class AppDataManager implements DataManager {

    private Context context;

    @Inject
    public AppDataManager(@ApplicationContext Context context) {
        this.context = context;
    }
}
