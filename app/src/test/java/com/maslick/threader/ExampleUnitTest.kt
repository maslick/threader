package com.maslick.threader

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun asd() {
        val device = DeviceExecutor(object : LifecycleCallback {
            override fun onConnected(device: String) {
                println("Successfully connected: ${device}, thread: ${Thread.currentThread().name}")
            }

            override fun onDisconnected() {
                println("Disconnected, thread: ${Thread.currentThread().name}")
            }

        })

        println("Calling thread: ${Thread.currentThread().name}")
        device.connect()
        device.disconnect()
        Thread.sleep(10000)
    }
}
