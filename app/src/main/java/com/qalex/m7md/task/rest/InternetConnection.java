package com.qalex.m7md.task.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by m7md on 17/02/18.
 */
public class InternetConnection {


    public static boolean checkConnection(Context context) {
    final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

    if (activeNetworkInfo != null) { // connected to the internet
//        Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

        if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;

        } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }
    }
    return false;
}
}
