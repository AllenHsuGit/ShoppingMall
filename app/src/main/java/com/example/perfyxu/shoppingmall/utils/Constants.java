package com.example.perfyxu.shoppingmall.utils;

import android.os.Environment;

/**
 *
 *
 *
 * 作用：配置各个页面联网地址
 */
public class Constants {

    //    public static String BASE_URL = "http://192.168.1.8:8080/ShoppingMallData";
//    public static String BASE_URL = "http://192.168.1.8:8080/ShoppingMallData";
    //private static final String BASE_URL = Environment.getExternalStorageDirectory( ) + "/ShoppingMallData";
    private static final String BASE_URL = System.getenv("EXTERNAL_STORAGE")+"/ShoppingMallData";//获取真机内部SD卡1的根目录
    /**
     * 主页面的路径
     */
    public static String HOME_URL = BASE_URL + "/json/HOME_URL.json";
    /**
     * 图片的基本路径
     */
    public static String BASE_URL_IMAGE = BASE_URL + "/img";


}
