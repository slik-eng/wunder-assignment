package com.sliksoft.wunder.ui.mvp;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface MvpPresenter<ViewType extends MvpView> {

    void onCreate(ViewType view);

    void onAttach();

    void onDettach();

    void onPause();

    ViewType getView();

    boolean isViewAttached();

}
