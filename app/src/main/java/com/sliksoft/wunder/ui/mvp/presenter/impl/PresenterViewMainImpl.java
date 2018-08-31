package com.sliksoft.wunder.ui.mvp.presenter.impl;

import android.util.Log;

import com.sliksoft.wunder.Constant;
import com.sliksoft.wunder.helpers.HelperPreference;
import com.sliksoft.wunder.model.ModelPlaceMarks;
import com.sliksoft.wunder.model.Placemark;
import com.sliksoft.wunder.net.ApiClient;
import com.sliksoft.wunder.ui.mvp.MvpPresenterBase;
import com.sliksoft.wunder.ui.mvp.presenter.PresenterViewMain;
import com.sliksoft.wunder.ui.mvp.view.ViewMain;
import com.sliksoft.wunder.utils.ReadFile;
import com.sliksoft.wunder.utils.UtilRx;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class PresenterViewMainImpl extends MvpPresenterBase<ViewMain> implements PresenterViewMain{
    String TAG = this.getClass().getName();
    private Subscription networkSubscription;
    @Override
    public void loadData() {
        //start networkConnection
        //rxjava2 is disposable :p
        //start networkConnection
        networkSubscription =ApiClient.get()
                .getWunderApi()
                .getLocations()
                .subscribeOn(Schedulers.io())
                .map(ModelPlaceMarks::getPlacemarks)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onDataLoaded,this::onError);

    }

    @Override
    public void onDataLoaded(List<Placemark> results) {
        getView().showResults(results);
        HelperPreference.get().saveObject(Constant.KEY.PLACE_MARK,results);
    }

    @Override
    public void onError(Throwable throwable) {
        onDataLoaded(ReadFile.loadFrom().getPlacemarks());
    }

    @Override
    public void onDettach() {
        UtilRx.unsubscribe(networkSubscription);
        super.onDettach();
    }
}
