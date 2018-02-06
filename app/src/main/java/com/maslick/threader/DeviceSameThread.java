package com.maslick.threader;

import android.util.Log;

/**
 * Created by maslick on 04/02/18.
 */

public class DeviceSameThread {

    private LifecycleCallback lifecycleCallback;
    private final String TAG = this.getClass().getName();

    public DeviceSameThread(LifecycleCallback lifecycleCallback) {
        this.lifecycleCallback = lifecycleCallback;
    }


    public void connect() {
        Log.d(TAG, "connecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        lifecycleCallback.onConnected("123-456");
    }

    public void disconnect() {
        Log.d(TAG, "disconnecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        lifecycleCallback.onDisconnected();
    }
}
