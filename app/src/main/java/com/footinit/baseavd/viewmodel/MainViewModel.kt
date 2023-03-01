package com.footinit.baseavd.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.footinit.baseavd.R

class MainViewModel(application: Application): AndroidViewModel(application) {

    private var avdList = listOf(
        AppCompatResources.getDrawable(application, R.drawable.avd_browser_enhanced)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_briefcase)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_start_tracking)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_stop_tracking)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_left)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_right)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_path)!!,
        AppCompatResources.getDrawable(application, R.drawable.avd_tea)!!,
    )

    private var _avdList = MutableLiveData(avdList)

    fun getAvdList(): LiveData<List<Drawable>> {
        return _avdList
    }
}