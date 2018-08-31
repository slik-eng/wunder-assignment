package com.sliksoft.wunder.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Osama Slik on 31/08/2018.
 */
public class ModelPlaceMarks {

@SerializedName("placemarks")
private List<Placemark> placemarks = null;

public List<Placemark> getPlacemarks() {
return placemarks;
}

public void setPlacemarks(List<Placemark> placemarks) {
this.placemarks = placemarks;
}

}