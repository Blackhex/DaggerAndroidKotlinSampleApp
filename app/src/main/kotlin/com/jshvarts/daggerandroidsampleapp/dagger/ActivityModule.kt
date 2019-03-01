package com.jshvarts.daggerandroidsampleapp.dagger

import android.app.*
import android.content.*

import dagger.*

@Module(
  includes = [
    ActivityModule.Bindings::class
  ]
)
class ActivityModule {

  @Module
  abstract class Bindings {

    @ActivityScope
    @Binds
    abstract fun activity(activity: Activity): Context
  }

  @ActivityScope
  @Provides
  fun alertDialogBuilder(context: Context) = AlertDialog.Builder(context)
}
