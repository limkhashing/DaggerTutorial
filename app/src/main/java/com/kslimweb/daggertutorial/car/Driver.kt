package com.kslimweb.daggertutorial.car

import javax.inject.Inject


// @Singleton is usually for implementation and
// had to be in same component for same object
//@Singleton
//class Driver @Inject constructor() {
//
//}

class Driver(val name: String) {
    //we don't own this class so we can't annotate it with @Inject
}