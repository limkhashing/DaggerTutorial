package com.kslimweb.daggertutorial.car

import android.util.Log
import com.kslimweb.daggertutorial.AppConstants
import com.kslimweb.daggertutorial.AppConstants.ENGINE_CAPACITY
import com.kslimweb.daggertutorial.AppConstants.HORSE_POWER
import com.kslimweb.daggertutorial.MainActivity.Companion.TAG
import javax.inject.Inject
import javax.inject.Named

// another way to get value beside using @Provides method
// it is best practices to put @Named even don't have multiple bindings just to avoid confusion later on
// can use static qualifier value for @Named
class PetrolEngine @Inject constructor(@Named(HORSE_POWER) private val horsePower: Int,
                                       @Named(ENGINE_CAPACITY) private val engineCapacity: Int) : Engine {

    override fun start() {
        Log.d(TAG, "Start Petrol engine. Horsepower : $horsePower \nCapacity: $engineCapacity")
    }
}