package com.kslimweb.daggertutorial.car

import android.util.Log
import com.kslimweb.daggertutorial.MainActivity.Companion.TAG

class Tyres {
    //we don't own this class so we can't annotate it with @Inject
    fun inflate() {
        Log.d(TAG, "tyres inflated")
    }
}