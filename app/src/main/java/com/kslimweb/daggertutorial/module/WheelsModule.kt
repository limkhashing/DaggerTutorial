package com.kslimweb.daggertutorial.module

import com.kslimweb.daggertutorial.car.Rims
import com.kslimweb.daggertutorial.car.Tyres
import com.kslimweb.daggertutorial.car.Wheels
import dagger.Module
import dagger.Provides

@Module
object WheelsModule {

    // whenever these provides method no depend on any instance state of the module
    // we should put static for optimization to add better performance
    // so that dagger don't need to always instantiate this module
    // and can call these @Provides method directly from the class

    @JvmStatic
    @Provides
    fun provideRims(): Rims {
        return Rims()
    }

    // if class does not come from @Inject annotated constructor and comes from
    // @Provices method, then u had to put @Singleton directly in @Provides
    // if the object is same across application
    @JvmStatic
    @Provides
    fun provideTyres(): Tyres {
        val tyres = Tyres()
        tyres.inflate()
        return tyres
    }

    @JvmStatic
    @Provides
    fun provideWheels(rims: Rims, tyres: Tyres): Wheels {
        // most of the time u will need to call .build() method
        // like build retrofit
        return Wheels(rims, tyres)
    }

    // another way to put static method in kotlin
//    @Module
//    companion object {
//        // Static @Provides
//    }
}
