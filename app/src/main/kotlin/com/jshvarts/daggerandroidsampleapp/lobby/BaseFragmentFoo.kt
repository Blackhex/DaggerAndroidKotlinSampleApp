package com.jshvarts.daggerandroidsampleapp.lobby

import android.app.*

import com.jshvarts.daggerandroidsampleapp.dagger.*

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
