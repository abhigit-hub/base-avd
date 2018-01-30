package com.footinit.baseavd.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Abhijit on 08-11-2017.
 */

interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}
