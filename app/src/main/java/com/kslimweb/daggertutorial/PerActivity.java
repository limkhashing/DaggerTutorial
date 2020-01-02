package com.kslimweb.daggertutorial;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Singleton definition
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity { }