package com.tuya.smart.android.personalcenter;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tuya.smart.api.router.UrlBuilder;
import com.tuya.smart.api.service.RouteEventListener;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.wrapper.api.TuyaWrapper;

public class TuyaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TuyaSdk.init(this);
        TuyaWrapper.init(this, new RouteEventListener() {
            @Override
            public void onFaild(int errorCode, UrlBuilder urlBuilder) {

            }
        });
        Fresco.initialize(this);
    }
}
