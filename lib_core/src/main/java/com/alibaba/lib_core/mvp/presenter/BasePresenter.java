package com.alibaba.lib_core.mvp.presenter;

import com.alibaba.lib_core.mvp.model.IModel;
import com.alibaba.lib_core.mvp.view.view.IView;

public
class BasePresenter<M extends IModel,V extends IView> implements IPresenter{
    protected M mModel;
    protected V mView;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void destory() {
        if (mModel != null){
            mModel.destory();
            mModel = null;
        }
        System.gc();
    }
}
