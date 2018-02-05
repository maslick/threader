package com.maslick.threader;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by maslick on 04/02/18.
 */

public class DeviceHandler {

    private LifecycleCallback lifecycleCallback;
    private Handler mCallbackHandler;


    private static HandlerThread makeThread() {
        HandlerThread handlerThread = new HandlerThread("MyDevice_callback_thread_Handler");
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
        mCallbackHandler.postDelayed(() -> {
            System.out.println("##################");
            System.out.println("connecting..." + " " + Thread.currentThread().getName());
            System.out.println("##################");
            lifecycleCallback.onConnected("123-456");
        }, 2000);
    }

    public void disconnect() {
        mCallbackHandler.postDelayed(() -> {
            System.out.println("##################");
            System.out.println("disconnecting..." + " " + Thread.currentThread().getName());
            System.out.println("##################");
            lifecycleCallback.onDisconnected();
        }, 2000);
    }
}
