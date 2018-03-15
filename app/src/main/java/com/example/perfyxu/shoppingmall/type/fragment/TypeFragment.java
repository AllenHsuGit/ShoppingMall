package com.example.perfyxu.shoppingmall.type.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.perfyxu.shoppingmall.base.BaseFragment;

/**
 * Created by lenovo on 2018/3/15.
 */

public class TypeFragment extends BaseFragment {
    private static final String TAG = TypeFragment.class.getSimpleName();
    private TextView textView;

    @Override
    public View initView() {
        Log.e(TAG, "分类的Fragment的UI被初始化了！");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "分类的Fragment的数据被初始化了！");
        textView.setText("分类内容！");
    }
}
