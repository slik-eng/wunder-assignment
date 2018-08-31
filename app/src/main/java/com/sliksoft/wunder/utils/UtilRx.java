package com.sliksoft.wunder.utils;

import rx.Subscription;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class UtilRx {
    public static Subscription unsubscribe(Subscription sub) {
        if (sub != null && !sub.isUnsubscribed()) {
            sub.unsubscribe();
        }
        return null;
    }
}
