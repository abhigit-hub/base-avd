package com.footinit.baseavd.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Abhijit on 08-11-2017.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
