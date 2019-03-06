package com.jshvarts.daggerandroidsampleapp.dagger.ui

import android.app.*
import android.os.*

import dagger.android.*

import javax.inject.*

abstract class BaseActivity:
  Activity() {

  @Inject
  lateinit var alertDialogBuilder: AlertDialog.Builder

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
  }
}
