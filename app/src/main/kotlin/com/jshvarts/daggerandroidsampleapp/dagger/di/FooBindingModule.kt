package com.jshvarts.daggerandroidsampleapp.dagger.di

import com.jshvarts.daggerandroidsampleapp.dagger.ui.*

import dagger.*
import dagger.android.*

@Module(
  includes = [
    FooBindingModule.Injectors::class
  ]
)
class FooBindingModule {

  @Module
  class Providers {

    @ActivityScope
    @Provides
    fun provideActivity(foo: LobbyFragmentFoo) = foo.fragment.activity
  }

  @Module
  abstract class Injectors {

    @ActivityScope
    @ContributesAndroidInjector(
      modules = [
        Providers::class,
        LobbyFooModule::class,
        ActivityModule::class
      ]
    )
    abstract fun lobbyFragmentFoo(): LobbyFragmentFoo
  }
}
