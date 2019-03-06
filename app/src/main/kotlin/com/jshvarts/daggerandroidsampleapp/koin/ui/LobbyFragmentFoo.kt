package com.jshvarts.daggerandroidsampleapp.koin.ui

import android.content.*

import javax.inject.*

class LobbyFragmentFoo(fragment: LobbyFragment):
  BaseFragmentFoo(fragment) {

  @Inject
  protected lateinit var theContext: Context

  init {
    /*alertDialogBuilder.setTitle("Hello")
      .setMessage("Hello, World from Foo created by ${theContext.hashCode()}")
      .create()
      .show()*/
  }
}
