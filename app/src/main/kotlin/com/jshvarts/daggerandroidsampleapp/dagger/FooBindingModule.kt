package com.jshvarts.daggerandroidsampleapp.dagger

import com.jshvarts.daggerandroidsampleapp.com.jshvarts.daggerandroidmvp.lobby.*
import com.jshvarts.daggerandroidsampleapp.lobby.*

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
