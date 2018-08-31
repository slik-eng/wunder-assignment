package com.sliksoft.wunder.ui.mvp;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public interface MvpView<PresenterType extends MvpPresenter> {

    int getLayoutResourceId();
    PresenterType getPresenterInstance();
    void showError(Throwable throwable);
}