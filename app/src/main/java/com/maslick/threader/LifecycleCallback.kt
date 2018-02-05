package com.maslick.threader

/**
 * Created by maslick on 04/02/18.
 */
interface LifecycleCallback {
    fun onConnected(device: String)
    fun onDisconnected()
}