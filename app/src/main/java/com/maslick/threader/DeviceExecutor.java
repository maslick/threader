package com.maslick.threader;

import android.util.Log;

import java.util.concurrent.Executor;

/**
 * Created by maslick on 04/02/18.
 */

public class DeviceExecutor {

    private LifecycleCallback lifecycleCallback;
    private Executor mCallbackHandler;
    private final String TAG = this.getClass().getName();

    public DeviceExecutor(LifecycleCallback lifecycleCallback) {
        this(lifecycleCallback, Threading.USER_THREAD);
    }

    public DeviceExecutor(LifecycleCallback lifecycleCallback, Executor mCallbackHandler) {
        this.lifecycleCallback = lifecycleCallback;
        this.mCallbackHandler = mCallbackHandler;
    }

    public void connect() {
        Log.d(TAG, "connecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        mCallbackHandler.execute(() -> {
            try {
                Log.d(TAG, "##################");
                Log.d(TAG, "thread inside handler: " + Thread.currentThread().getName());
                Log.d(TAG, "##################");
                Thread.sleep(2000);
                lifecycleCallback.onConnected("123-456");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void disconnect() {
        Log.d(TAG, "disconnecting...");
        Log.d(TAG, "thread before: " + Thread.currentThread().getName());
        mCallbackHandler.execute(() -> {
            try {
                Log.d(TAG, "##################");
                Log.d(TAG, "thread inside handler: " + Thread.currentThread().getName());
                Log.d(TAG, "##################");
                Thread.sleep(3000);
                lifecycleCallback.onDisconnected();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
