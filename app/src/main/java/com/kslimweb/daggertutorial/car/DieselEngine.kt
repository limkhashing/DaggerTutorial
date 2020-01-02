package com.kslimweb.daggertutorial.car

import android.util.Log
import com.kslimweb.daggertutorial.MainActivity.Companion.TAG
import javax.inject.Inject

// what if we need to inject values at run-time when we are building the component
// since we dont know what is the value will be coming in and need to do DI
class DieselEngine @Inject constructor(private val horsePower: Int) : Engine {
    override fun start() {
        Log.d(TAG, "Start diesel engine. Horsepower : $horsePower")
    }
}