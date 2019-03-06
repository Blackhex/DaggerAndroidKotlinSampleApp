package com.jshvarts.daggerandroidsampleapp.dagger.di

import android.app.*

import com.jshvarts.daggerandroidsampleapp.dagger.ui.*

import dagger.*
import dagger.android.*

@Module(
  includes = [
    ActivityBindingModule.Injectors::class
  ]
)
abstract class ActivityBindingModule {

  @Module
  abstract class Bindings {

    @ActivityScope
    @Binds
    abstract fun activity(activity: LobbyActivity): Activity
  }

  @Module
  abstract class Injectors {

    @ActivityScope
    @ContributesAndroidInjector(
      modules = [
        Bindings::class,
        ActivityModule::class,
        LobbyActivityModule::class
      ]
    )
    abstract fun lobbyActivity(): LobbyActivity
  }
}
