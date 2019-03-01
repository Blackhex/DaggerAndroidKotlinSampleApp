package com.jshvarts.daggerandroidsampleapp.lobby

import android.app.*
import android.content.*

import dagger.android.*

abstract class BaseFragment:
  Fragment() {

  override fun onAttach(context: Context?) {
    AndroidInjection.inject(this)

    super.onAttach(context)
  }
}