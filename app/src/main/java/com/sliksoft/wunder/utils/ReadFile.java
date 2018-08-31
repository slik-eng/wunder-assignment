package com.sliksoft.wunder.utils;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.sliksoft.wunder.MainApplication;
import com.sliksoft.wunder.model.ModelPlaceMarks;
import com.sliksoft.wunder.model.Placemark;

public class ReadFile {
    public static ModelPlaceMarks loadFrom(){
        InputStream is = null;
        //if (!preloadv3File.exists()) {
        try {
            is = MainApplication.CONTEXT.getAssets().open("locations.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // memData is null => load default
        Reader reader = new BufferedReader(new InputStreamReader(is));
        GsonBuilder gson = new GsonBuilder();
        ModelPlaceMarks body = gson.create().fromJson(reader, ModelPlaceMarks.class);
        return body;
    }

}
