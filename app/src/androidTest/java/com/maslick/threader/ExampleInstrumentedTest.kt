package com.maslick.threader

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun usingDeviceExecutor() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.maslick.threader", appContext.packageName)

        val device = DeviceExecutor(callback)

        println("Calling thread: ${Thread.currentThread().name}")
        device.connect()
        device.disconnect()
        Thread.sleep(10000)
    }

    @Test
    fun usingHandler() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.maslick.threader", appContext.packageName)

        val device = DeviceHandler(callback)

        println("Calling thread: ${Thread.currentThread().name}")
        device.connect()
        device.disconnect()
        Thread.sleep(10000)
    }

    val callback = object : LifecycleCallback {
        override fun onConnected(device: String) {
            println("Successfully connected: ${device}, thread: ${Thread.currentThread().name}")
        }

        override fun onDisconnected() {
            println("Disconnected, thread: ${Thread.currentThread().name}")
        }

    }
}
