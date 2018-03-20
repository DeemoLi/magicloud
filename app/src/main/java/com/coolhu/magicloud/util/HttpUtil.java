package com.coolhu.magicloud.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
*@author Administrator
*@create 2018/3/20 16:04
*@desc
*@e-mail:850812987@qq.com
**/

public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(address).build();

        client.newCall(request).enqueue(callback);

    }

}
