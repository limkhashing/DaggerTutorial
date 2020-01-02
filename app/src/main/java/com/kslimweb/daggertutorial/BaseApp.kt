package com.kslimweb.daggertutorial

import android.app.Application
import com.kslimweb.daggertutorial.component.AppComponent
import com.kslimweb.daggertutorial.component.DaggerAppComponent
import com.kslimweb.daggertutorial.module.DriverModule

class BaseApp : Application() {

    lateinit var carComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        carComponent = DaggerAppComponent.create()
        carComponent = DaggerAppComponent.factory().create(DriverModule("Shing"))
    }

    fun getAppComponent(): AppComponent {
        return carComponent
    }
}