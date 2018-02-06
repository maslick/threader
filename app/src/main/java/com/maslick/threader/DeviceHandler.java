package com.maslick.threader;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by maslick on 04/02/18.
 */

public class DeviceHandler {

    private LifecycleCallback lifecycleCallback;
    private Handler mCallbackHandler;
    private final String TAG = this.getClass().getName();

    private static HandlerThread makeThread() {
        HandlerThread handlerThread = new HandlerThread("DeviceHandler_thread");
        handlerThread.start();
        return handlerThread;
    }

    public DeviceHandler(LifecycleCallback lifecycleCallback) {
        this(lifecycleCallback, new Handler(makeThread().getLooper()));
    }

    public DeviceHandler(LifecycleCallback lifecycleCallback, Handler mCallbackHandler) {
        this.lifecycleCallback = lifecycleCallback;
        this.mCallbackHandler = mCallbackHandler;
    }

    public void connect() {
        Log.d(TAG, "connecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        mCallbackHandler.postDelayed(() -> {
            Log.d(TAG, "##################");
            Log.d(TAG, "thread inside handler: " + Thread.currentThread().getName());
            Log.d(TAG, "##################");
            lifecycleCallback.onConnected("123-456");
        }, 2000);
    }

    public void disconnect() {
        Log.d(TAG, "disconnecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        mCallbackHandler.postDelayed(() -> {
            Log.d(TAG, "##################");
            Log.d(TAG, "thread inside handler: " + Thread.currentThread().getName());
            Log.d(TAG, "##################");
            lifecycleCallback.onDisconnected();
        }, 2000);
    }
}
