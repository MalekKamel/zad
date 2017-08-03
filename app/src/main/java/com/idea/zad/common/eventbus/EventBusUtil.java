package com.idea.zad.common.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Sha on 6/26/17.
 */

public class EventBusUtil {

    private static EventBus defaulEb = EventBus.getDefault();

    public static void register(Object o){
        if (!defaulEb.isRegistered(o))
            defaulEb.register(o);
    }

    public static void unregister(Object o){
        defaulEb.unregister(o);
    }

    public static void post(Object o){
        defaulEb.post(o);
    }


}
