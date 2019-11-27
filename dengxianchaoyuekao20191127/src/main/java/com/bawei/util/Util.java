package com.bawei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.Contract.Icontract;
import com.bawei.View.MyApp;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:23
 *@Description:${DESCRIPTION}
 **/
public class Util {
    RequestQueue queue= Volley.newRequestQueue(MyApp.context);
    public static Util util;
    private Util(){}
    public synchronized static Util getInstance(){
        if(util==null){
            util=new Util();
        }
        return util;
    }

    public boolean getConnected(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }


    public void toGits(String url, final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(0, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }
}
