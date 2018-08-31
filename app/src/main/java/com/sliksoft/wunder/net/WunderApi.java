package com.sliksoft.wunder.net;

import retrofit2.http.GET;
import rx.Observable;

import com.sliksoft.wunder.model.ModelPlaceMarks;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface WunderApi {


@GET("wunderbucket/locations.json")
Observable<ModelPlaceMarks> getLocations();

}
