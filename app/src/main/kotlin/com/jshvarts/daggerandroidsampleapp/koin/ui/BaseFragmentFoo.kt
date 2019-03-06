package com.jshvarts.daggerandroidsampleapp.koin.ui

import android.app.*

import org.koin.standalone.*

abstract class BaseFragmentFoo(
  val fragment: BaseFragment
): KoinComponent {

  protected val alertDialogBuilder: AlertDialog.Builder by inject()
}
