package com.jshvarts.daggerandroidsampleapp.koin.ui

import android.os.*
import android.support.v4.app.*
import android.support.v7.app.*
import android.view.*

import com.jshvarts.daggerandroidsampleapp.koin.di.*

import org.koin.android.ext.android.*
import org.koin.android.scope.ext.android.*

abstract class BaseFragment:
  Fragment() {

  protected val alertDialogBuilder: AlertDialog.Builder by inject()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    bindScope(getOrCreateScope(Scope.ACTIVITY))
    bindScope(getOrCreateScope(Scope.FRAGMENT))
  }
}
