package com.sliksoft.wunder.ui.mvp.presenter;

import com.sliksoft.wunder.model.Placemark;
import com.sliksoft.wunder.ui.mvp.MvpPresenter;
import com.sliksoft.wunder.ui.mvp.view.ViewMain;

import java.util.List;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface PresenterViewMain extends MvpPresenter<ViewMain>{

    void loadData();
    void onDataLoaded(List<Placemark> results);
    void onError(Throwable throwable);
}
