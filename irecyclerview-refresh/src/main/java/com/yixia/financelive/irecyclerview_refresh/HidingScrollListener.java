package com.yixia.financelive.irecyclerview_refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * 作者：俎金好
 * 日期：2016/9/20
 * 功能描述：头部隐藏或者显示的监听器
 */
public abstract class HidingScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "HidingScrollListener";
    private int headerHeight = 1600;
    private int scrolledDistance = 0;
    private boolean controlsVisible = false;
    private LinearLayoutManager layoutManager;

    public HidingScrollListener(int headerHeight){
        this.headerHeight = headerHeight;
        Log.d(TAG,"headerHeight:"+headerHeight);
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (layoutManager == null){
            layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        }
        if (scrolledDistance > headerHeight && !controlsVisible) {
            onShow();
            controlsVisible = true;
            scrolledDistance = 0;
        } else if (scrolledDistance < -headerHeight && controlsVisible) {
            onHide();
            controlsVisible = false;
            scrolledDistance = 0;
        }
        if((!controlsVisible && dy>0) || (controlsVisible && dy<0 && layoutManager.findFirstVisibleItemPosition() < 4)) {
            scrolledDistance += dy;
        }
        Log.d(TAG,"dy:"+dy+",scrolledDistance:"+scrolledDistance+",visible position:"+layoutManager.findFirstVisibleItemPosition());
    }

    public abstract void onHide();
    public abstract void onShow();
}
