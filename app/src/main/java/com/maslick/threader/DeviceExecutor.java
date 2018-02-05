package com.maslick.threader;

import java.util.concurrent.Executor;

/**
 * Created by maslick on 04/02/18.
 */

public class DeviceExecutor {

    private LifecycleCallback lifecycleCallback;
    private Executor mCallbackHandler;

    public DeviceExecutor(LifecycleCallback lifecycleCallback) {
        this(lifecycleCallback, Threading.USER_THREAD);
    }

    public DeviceExecutor(LifecycleCallback lifecycleCallback, Executor mCallbackHandler) {
        this.lifecycleCallback = lifecycleCallback;
        this.mCallbackHandler = mCallbackHandler;
    }

    public void connect() {
        mCallbackHandler.execute(() -> {
            try {
                System.out.println("##################");
                System.out.println("thread: " + " " + Thread.currentThread().getName());
                System.out.println("##################");
                Thread.sleep(2000);
                lifecycleCallback.onConnected("123-456");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void disconnect() {
        mCallbackHandler.execute(() -> {
            try {
                System.out.println("##################");
                System.out.println("disconnecting..." + " " + Thread.currentThread().getName());
                System.out.println("##################");
                Thread.sleep(3000);
                lifecycleCallback.onDisconnected();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
