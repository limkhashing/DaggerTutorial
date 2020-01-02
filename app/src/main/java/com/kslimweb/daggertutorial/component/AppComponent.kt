package com.kslimweb.daggertutorial.component

import com.kslimweb.daggertutorial.car.Driver
import com.kslimweb.daggertutorial.module.DieselEngineModule
import com.kslimweb.daggertutorial.module.DriverModule
import dagger.Component
import javax.inject.Singleton

// At some point we need to exit the object graph
// Bind all the dependency into single component / object as exit point
// code will be generated by Dagger automatically when compile project

// by swapping modules we can easily unit test our codes because we can also
// a fake engine module or a fake wheels module
// but we cannot put put two Engine together and
// Dagger would not know which Engine should use

// why we don't annotated singleton on all of them
// is because we don't put the module into the wrong component
// if the @Provides method have the @PerActivity annotation it
// will not make sense to turn getActivityComponent to singleton
@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {
    // a different component and u need to expose it to get the object
//    fun getDriver(): Driver

    // sub component can access the driver of the AppComponent without exposing it explicitly
    // can add more modules that have arguments inside the parameter
//    fun getActivityComponent(dieselEngineModule: DieselEngineModule) : ActivityComponent

//    fun getActivityComponentBuilder() : ActivityComponent.Builder

    fun getActivityComponentFactory() : ActivityComponent.Factory

    @Component.Factory
    interface Factory {
        // if you have other dependencies, put as arguments in methods
        fun create(driverModule: DriverModule): AppComponent
    }
}