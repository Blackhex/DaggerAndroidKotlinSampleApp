package com.jshvarts.daggerandroidsampleapp.lobby

import android.os.*
import android.support.v7.app.*

import com.jshvarts.daggerandroidsampleapp.*

import dagger.android.*

abstract class BaseActivity:
  AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    (application as App)
      .enterActivityScope(this)

    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
  }

  override fun onDestroy() {
    (application as App)
      .leaveActivityScope()

    super.onDestroy()
  }
}
