package com.example.perfyxu.shoppingmall.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;


import com.example.perfyxu.shoppingmall.R;
import com.example.perfyxu.shoppingmall.base.BaseFragment;
import com.example.perfyxu.shoppingmall.community.fragment.CommunityFragment;
import com.example.perfyxu.shoppingmall.home.fragment.HomeFragment;
import com.example.perfyxu.shoppingmall.shoppingcart.fragment.ShoppingCartFragment;
import com.example.perfyxu.shoppingmall.type.fragment.TypeFragment;
import com.example.perfyxu.shoppingmall.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    /**
     * 装载多个Fragment的实例集合
     */
    private ArrayList<Fragment> fragments;
    private int position = 0;
    /**
     * 缓存的Fragment或者上一次显示的Fragment
     */
    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife和当前的Activity绑定
        ButterKnife.bind(this);
        /**
         * 初始化Fragment
         */
        initFragment();
        /**
         * 设置RadioGroup的监听
         */
        initListener();

    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home://主页
                        position = 0;
                        break;
                    case R.id.rb_type://分类
                        position = 1;
                        break;
                    case R.id.rb_community://发现
                        position = 2;
                        break;
                    case R.id.rb_cart://购物车
                        position = 3;
                        break;
                    case R.id.rb_user://用户中心
                        position = 4;

                    default:
                        position = 0;
                        break;
                }
                //根据位置取不同的Fragment
                BaseFragment baseFragment = getFragment(position);
                /**
                 * 第一个参数：上次显示的Fragment
                 * 第二个参数：将要显示的Fragment
                 */
                switchFragment(tempFragment,baseFragment);
            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(Fragment fromFragment,BaseFragment nextFragment) {
        if(tempFragment != nextFragment){
            tempFragment = nextFragment;
            if(nextFragment != null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFrament是否被添加
                if (!nextFragment.isAdded()){
                    //隐藏当前的Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout,nextFragment).commit();
                }else {
                    //隐藏当前的Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    /**
     * 添加的时候要按照底部按钮的顺序
     */
    private void initFragment(){
        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragment());
    }

    private BaseFragment getFragment(int position){
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = (BaseFragment) fragments.get(position);
            return baseFragment;
        }
        return null;
    }
}
