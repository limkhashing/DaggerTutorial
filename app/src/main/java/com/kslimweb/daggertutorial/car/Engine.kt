package com.kslimweb.daggertutorial.car

import android.util.Log
import javax.inject.Inject

// inject necessary dependency to class Engine
//class Engine @Inject constructor() {
//    fun start() {
//        Log.d(TAG, "Start engine")
//    }
//}

// when dependency is interface instead of implementation
// we can to use @Bind to reduce code
interface Engine {
    fun start()
}