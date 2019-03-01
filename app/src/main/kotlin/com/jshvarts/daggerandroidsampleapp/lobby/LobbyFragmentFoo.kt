package com.jshvarts.daggerandroidsampleapp.com.jshvarts.daggerandroidmvp.lobby

import android.content.*

import com.jshvarts.daggerandroidsampleapp.lobby.*
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
