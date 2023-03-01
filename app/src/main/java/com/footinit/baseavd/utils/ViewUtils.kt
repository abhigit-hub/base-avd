package com.footinit.baseavd.utils

import android.graphics.Color

object ViewUtils {

    private lateinit var colors: Array<String>

    fun setUpColors(stringArray: Array<String>) {
        colors = stringArray
    }

    fun getRandomColor(): Int {
        return Color.parseColor(colors[(colors.indices).random()])
    }
}