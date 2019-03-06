package com.jshvarts.daggerandroidsampleapp.koin.ui

import android.app.AlertDialog
import android.os.*
import android.support.v7.app.*

import com.jshvarts.daggerandroidsampleapp.koin.di.*

import org.koin.android.ext.android.*
import org.koin.android.scope.ext.android.*

abstract class BaseActivity:
  AppCompatActivity() {

  protected val alertDialogBuilder: AlertDialog.Builder by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    bindScope(getOrCreateScope(Scope.ACTIVITY))
  }
}
