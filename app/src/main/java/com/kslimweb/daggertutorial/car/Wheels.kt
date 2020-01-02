package com.kslimweb.daggertutorial.car

// inject necessary dependency to class Wheels
// @Inject constructor()
//class Wheels @Inject constructor() {
//
//}

class Wheels(private val rims: Rims, private val tyres: Tyres) {

    // But what if the is from other class that are not in your control?
    // like Wheels but from 3rd party. We can't annotate @Inject
    // So we create WheelsModule
}
