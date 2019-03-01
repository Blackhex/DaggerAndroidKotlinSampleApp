package com.jshvarts.daggerandroidsampleapp.di

import android.app.*

import dagger.*

@Module
class ActivityModule {

  @ActivityScope
  @Provides
  fun alertDialogBuilder(activity: Activity) = AlertDialog.Builder(activity)
}
