package com.jshvarts.daggerandroidsampleapp.lobby

import android.app.*
import android.content.*

import dagger.android.*
import javax.inject.*

abstract class BaseFragment:
  Fragment() {

  @Inject
  lateinit var alertDialogBuilder: AlertDialog.Builder

  override fun onAttach(context: Context?) {
    AndroidInjection.inject(this)

    super.onAttach(context)
  }
}