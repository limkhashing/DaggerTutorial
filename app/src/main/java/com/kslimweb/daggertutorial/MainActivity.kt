package com.kslimweb.daggertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kslimweb.daggertutorial.car.Car
import com.kslimweb.daggertutorial.module.DieselEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Car"
    }
    // 3 Dependency injection place
    // Constructor, Field, Method
    // field injection or members injection
    // field injection is meant for framework types like Activities and Fragments
    // so we dont create our MainActivity object
    // Dagger does not support injection into private fields->cannot make "PRIVATE" of "FINAL"

    // Inside Dagger, for every @Inject constructor / field or @Provides annotated method
    // will create a ClassName_MethodFactory
    @Inject
    lateinit var car1: Car
    // kotlin cannot declaring variable with same type in same line
    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ctrl + b to see the generated code
//        val carComponents: CarComponent = DaggerCarComponent.create()

        // get value from run-time and do DI
//        val carComponents: ActivityComponent = (application as BaseApp).getAppComponent()

//        val component = DaggerActivityComponent
//                .builder()
//                //.dieselEngineModule(DieselEngineModule(hp = 100))
//                .horsePower(150)
//                .engineCapacity(1400)
//                .build()

//        val carComponents: ActivityComponent = DaggerActivityComponent
//            .builder()
//            .horsePower(100)
//            .engineCapacity(1000)
//            .appComponent((application as BaseApp).getAppComponent())
//            .build()

//        val carComponents = (application as BaseApp).getAppComponent()
//            .getActivityComponent(DieselEngineModule(120))

//        val carComponents = (application as BaseApp).getAppComponent()
//            .getActivityComponentBuilder()
//            .horsePower(150)
//            .engineCapacity(1400)
//            .build()

        // Try to favour factory over builder whenever possible
        // using factory will be more concise and compile time safety
        // Ex: using builder might forget to call one of the builder method
        // and it will crash on run-time if one of it is missing.
        // Use builder when you need to make optional
        // to pass in instances of the module
        val carComponents = (application as BaseApp).getAppComponent()
            .getActivityComponentFactory()
            .create(150, 1400)

        // field injection already. so don't need to carComponents.getCar()
//        car = carComponents.getCar()

        // dagger will take activity and inject into the member variables which are annotated with @Inject
        // the benefit of field injection is u can add multiple variables and just call one method to inject all
        // With this, u don't need to get every other objects from provision methods
        // cannot inject Superclass
        // we cant do constructor injection here
        // so we had to trigger the process manually by calling inject this
        carComponents.inject(this)
        car1.drive()
        car2.drive()
    }
}
