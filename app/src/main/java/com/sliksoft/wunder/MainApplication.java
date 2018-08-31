package com.sliksoft.wunder;

import android.app.Application;
import android.content.Context;

import com.sliksoft.wunder.helpers.HelperGson;
import com.sliksoft.wunder.helpers.HelperLocation;
import com.sliksoft.wunder.helpers.HelperPreference;
import com.sliksoft.wunder.net.ApiClient;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class MainApplication extends Application {
    public static Context CONTEXT;
    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
        HelperGson.init();
        HelperPreference.init(getApplicationContext(),HelperGson.get().getGson());
        ApiClient.get().init(HelperGson.get().getGson());
        HelperLocation.init(getApplicationContext());
    }
}
