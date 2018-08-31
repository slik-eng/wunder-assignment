package com.sliksoft.wunder.ui.mvp.view;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sliksoft.wunder.model.Placemark;
import com.sliksoft.wunder.ui.mvp.MvpView;
import com.sliksoft.wunder.ui.mvp.presenter.PresenterViewMap;

import java.util.List;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface ViewMap extends MvpView<PresenterViewMap> {
    void loadMapMarker(MarkerOptions markerOptions);

    void
    updateZoomMap(LatLngBounds.Builder builder);

    void enableListeners();

    void clearMap();
}
