package com.kslimweb.daggertutorial.car

import android.util.Log
import com.kslimweb.daggertutorial.MainActivity.Companion.TAG
import javax.inject.Inject

class Remote @Inject constructor() {
    fun setListener(car: Car) {
        Log.d(TAG, "Remote connected")
    }
}
