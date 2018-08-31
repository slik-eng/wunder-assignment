package com.sliksoft.wunder.ui.mvp.view;

import com.sliksoft.wunder.model.Placemark;
import com.sliksoft.wunder.ui.mvp.MvpView;
import com.sliksoft.wunder.ui.mvp.presenter.PresenterViewMain;

import java.util.List;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface ViewMain extends MvpView<PresenterViewMain>{
    void showResults(List<Placemark> results);
}
