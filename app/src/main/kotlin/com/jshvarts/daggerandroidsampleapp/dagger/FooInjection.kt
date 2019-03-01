package com.jshvarts.daggerandroidsampleapp.dagger

import android.app.*

import com.jshvarts.daggerandroidsampleapp.lobby.*

import dagger.android.*

interface HasFooInjector {

  fun fooInjector(): AndroidInjector<BaseFragmentFoo>
}

object FooInjection {

  fun inject(application: Application, foo: BaseFragmentFoo) {
    if (application !is HasFooInjector) {
      throw RuntimeException(
        "${application.javaClass.canonicalName} does not implement ${HasFooInjector::class.java.canonicalName}"
      )
    }

    val fooInjector = (application as HasFooInjector).fooInjector()

    fooInjector.inject(foo)
  }
}
