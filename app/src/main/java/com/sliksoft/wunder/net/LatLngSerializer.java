package com.sliksoft.wunder.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sliksoft.wunder.utils.UtilLocation;

import java.lang.reflect.Type;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class LatLngSerializer implements JsonSerializer<LatLng>{
    @Override
    public JsonElement serialize(LatLng src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return null;
        }
        String value = UtilLocation.latLngToString(src);
        return new JsonPrimitive(value);
    }
}
