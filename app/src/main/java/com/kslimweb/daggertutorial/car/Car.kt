package com.kslimweb.daggertutorial.car

import android.util.Log
import com.kslimweb.daggertutorial.MainActivity.Companion.TAG
import com.kslimweb.daggertutorial.PerActivity
import javax.inject.Inject

// inject necessary dependency to class Car
// we could do field injection but the downside is we cannot hide the fields anymore (private)
// if we have access to constructor best just use constructor injection
// and pass all the necessary dependency as constructor arguments

// When dependency is interface
// Dagger doest know which implementation that should use
@PerActivity
class Car @Inject constructor(private val engine: Engine,
                              private val wheels: Wheels,
                              private val driver: Driver) {

    fun drive() {
        engine.start()
        Log.d(TAG, "Driver ${driver.name} Driving... $this")
    }

    /**
     * Method injection is very rare
     * if you had to pass the injected object that served as dependency
     * this is the only good use case to use method injection
     * cannot execute remote.setListener in Constructor since the object is not fully instantiate
     * generally u should avoid passing in constructor and only pass this after the constructor finished
     * method cannot be private Dagger need to find it
     *
     * Dagger will Inject dependency by order one by one after constructor
     * Constructor -> Field -> Method
     * Field and method injection will auto happen when there is a Constructor injection
     */
    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }
}