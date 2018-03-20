package com.coolhu.magicloud.util;

import android.text.TextUtils;

import com.coolhu.magicloud.db.City;
import com.coolhu.magicloud.db.County;
import com.coolhu.magicloud.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
*@author Administrator
*@create 2018/3/20 16:21
*@desc
*@e-mail:850812987@qq.com
**/

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){

        if (!TextUtils.isEmpty(response)) {

            try {

                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {

                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProviceCode(provinceObject.getInt("id"));
                    province.save();

                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return false;

    }

    /**
     * 分析和处理服务器返回的市级信息
     */
    public static boolean handleCityResponse(String response,int provinceId){

        if (!TextUtils.isEmpty(response)) {

            try {

                JSONArray cityResponse = new JSONArray(response);
                for (int i = 0; i < cityResponse.length(); i++) {

                    JSONObject cityObject = cityResponse.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();

                }

                return true;
                
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return false;

    }

    /**
     * 分析和处理服务器返回的县级信息
     */
    public static boolean handleCounty(String response,int cityId){

        if (!TextUtils.isEmpty(response)) {

            try {

                JSONArray countyResponse = new JSONArray(response);
                for (int i = 0; i < countyResponse.length(); i++) {

                    JSONObject countyObject = countyResponse.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setCountyCode(countyObject.getInt("id"));
                    county.setCityId(cityId);
                    county.save();

                }

                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return false;

    }

}
