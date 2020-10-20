package com.alibaba.lib_core.mvp.view.fragment;

import android.view.View;

import androidx.annotation.IdRes;

import com.alibaba.lib_core.mvp.view.activity.IActivity;

public interface IFragment extends IActivity {

    <V extends View> V findViewById(@IdRes int id);
}
