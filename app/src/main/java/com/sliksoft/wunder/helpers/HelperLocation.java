package com.sliksoft.wunder.helpers;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.maps.model.LatLng;
import com.sliksoft.wunder.utils.UtilLocation;
/**
 * Created by Osama Slik on 31/08/2018.
 */

public class HelperLocation {
    private static HelperLocation INSTANCE;
    private LocationManager lm;

    public  static HelperLocation get() {
        return INSTANCE;
    }
    public static HelperLocation init(Context context)
    {
        INSTANCE = new HelperLocation();
        INSTANCE.lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return INSTANCE;
    }
    public LatLng getBestLastKnowLocation()
    {
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location==null)
            location=lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if(location==null)
            location=lm.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

        return UtilLocation.toLatLng(location);
    }
    public LocationManager getLocationManager()
    {
        return lm;
    }
}
