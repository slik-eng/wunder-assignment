package com.sliksoft.wunder.ui.mvp.presenter;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.sliksoft.wunder.ui.mvp.MvpPresenter;
import com.sliksoft.wunder.ui.mvp.view.ViewMap;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface PresenterViewMap extends MvpPresenter<ViewMap>{
    void onMapReady(LatLngBounds bounds);
    void addMarker(Marker marker);

    void onMarkerClick(Marker marker);

    void showPartialCars(LatLngBounds latLngBounds);

    void showAllCars();

    void showSingleCarList(LatLngBounds latLngBounds);
}
