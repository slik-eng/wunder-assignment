package com.sliksoft.wunder.helpers;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sliksoft.wunder.net.LatLngDeserializer;
import com.sliksoft.wunder.net.LatLngSerializer;

import java.util.Date;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class HelperGson {
    private Gson gson;
    private static HelperGson INSTANCE;

    public static HelperGson get() {
        return INSTANCE;
    }

    public static HelperGson init() {
        INSTANCE = new HelperGson();

        INSTANCE.gson = new GsonBuilder()
                .registerTypeAdapter(LatLng.class, new LatLngDeserializer())
                .registerTypeAdapter(LatLng.class, new LatLngSerializer())
                .create();

        return INSTANCE;
    }


    public Gson getGson() {
        return gson;
    }
}
