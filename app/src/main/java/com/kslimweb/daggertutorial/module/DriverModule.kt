package com.kslimweb.daggertutorial.module

import com.kslimweb.daggertutorial.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// if u want to pass arguments in constructor
//@Module
//class DriverModule {
//    @Module
//    companion object {
//        @JvmStatic
//        @Provides
//        @Singleton
//        fun provideDriver(): Driver = Driver()
//    }
//    // add other non-static provides here
//}

@Module
class DriverModule(private val driverName: String) {
    @Provides
    @Singleton
    fun provideDriver(): Driver = Driver(driverName)

    // add other non-static provides here
}

//@Module
//object DriverModule {
//    @Provides
//    @JvmStatic
//    @Singleton
//    fun provideDriver() : Driver {
//        return Driver()
//    }
//}
