package com.example.perfyxu.shoppingmall.home.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.perfyxu.shoppingmall.base.BaseFragment;

/**
 * Created by lenovo on 2018/3/15.
 */

public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private TextView textView;

    @Override
    public View initView() {
        Log.e(TAG, "主页面的Fragment的UI被初始化了！");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "主页面的Fragment的数据被初始化了！");
        textView.setText("主页面内容！");
    }
}
