package com.kslimweb.daggertutorial.module

import com.kslimweb.daggertutorial.car.Engine
import com.kslimweb.daggertutorial.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {
    // @Provides turn in concrete class
    // @Binds turn in abstract class
    // binds generate less codes

    // under the hood Dagger did not generate implementation for this class and methods
    // and never call the methods. It just instantiate PetrolEngine directly
    // so whenever we just wanna bind implementation to a interface
    // @Binds only take single argument, which is the class implementation
    // for the interface that the function defined

    // we can also @Singleton for @Binds object but it makes more sense
    // to use @Singleton for implementation
    @Binds
    abstract fun bindEngine(petrolEngine: PetrolEngine) : Engine
}