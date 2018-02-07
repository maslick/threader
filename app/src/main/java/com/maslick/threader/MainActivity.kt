package com.maslick.threader

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usingNothing()
        usingHandler()
        usingDeviceExecutor()
    }

    private fun usingDeviceExecutor() {
        val device = DeviceExecutor(callback, sameThreadExecutor)
        device.connect()
        device.disconnect()
    }

    private fun usingHandler() {
        val device = DeviceHandler(callback)
        device.connect()
        device.disconnect()
    }

    private fun usingNothing() {
        val device = DeviceSameThread(callback)
        device.connect()
        device.disconnect()
    }

    private val callback = object : LifecycleCallback {
        override fun onConnected(device: String) {
            Log.d("CALLBACK", "Successfully connected: $device, thread: ${Thread.currentThread().name}")
        }

        override fun onDisconnected() {
            Log.d("CALLBACK", "Disconnected, thread: ${Thread.currentThread().name}")
        }
    }

    private val uiExecutor = object : Executor {
        private val mHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mHandler.post(command)
        }
    }

    private val newThreadExecutor = Threading.USER_THREAD

    private val sameThreadExecutor = Threading.SAME_THREAD
}
