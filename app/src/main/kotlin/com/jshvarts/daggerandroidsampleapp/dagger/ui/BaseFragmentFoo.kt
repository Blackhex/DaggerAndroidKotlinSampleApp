package com.jshvarts.daggerandroidsampleapp.dagger.ui

import android.app.*

import com.jshvarts.daggerandroidsampleapp.dagger.di.*

import javax.inject.*

abstract class BaseFragmentFoo(
  val fragment: BaseFragment
) {

  @Inject
  protected lateinit var alertDialogBuilder: AlertDialog.Builder

  init {
    FooInjection.inject(fragment.activity.application, this)
  }
}
