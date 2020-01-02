package com.kslimweb.daggertutorial.module

import com.kslimweb.daggertutorial.car.Engine
import com.kslimweb.daggertutorial.car.DieselEngine
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

//@Module
//abstract class DieselEngineModule {
//    // @Provides turn in concrete class
//    // @Binds turn in abstract class
//    // binds generate less codes
//
//    // under the hood Dagger did not generate implementation for this class and methods
//    // and never call the methods. It just instantiate PetrolEngine directly
//    // so whenever we just wanna bind implementation to a interface
//    // @Binds only take single argument, which is the class implementation
//    // for the interface that the function defined
//    @Binds
//    abstract fun bindEngine(petrolEngine: DieselEngine) : Engine
//}

@Module
class DieselEngineModule(private val horsePower: Int) {

    // need to pass value to DieselEngine at run time
    // now we cant make this method static since it now depends on instance variable
    // Dagger only care about the return type in @Provides and it will caused problem

    @Provides
    fun provideHorsePower() = horsePower

    @Provides
    fun provideEngine(engine: DieselEngine): Engine = engine
}