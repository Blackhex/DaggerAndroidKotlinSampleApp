package com.jshvarts.daggerandroidsampleapp.dagger

import com.jshvarts.daggerandroidsampleapp.lobby.*

import dagger.*
import dagger.android.*

@Module(
  includes = [
    FragmentBindingModule.Injectors::class
  ]
)
class FragmentBindingModule {

  @Module
  class Providers {

    @ActivityScope
    @Provides
    fun provideLobbyActivity(fragment: LobbyFragment) = fragment.activity
  }

  @Module
  abstract class Injectors {

    @ActivityScope
    @ContributesAndroidInjector(
      modules = [
        Providers::class,
        ActivityModule::class,
        LobbyActivityModule::class,
        LobbyFragmentModule::class
      ]
    )
    abstract fun lobbyFragment(): LobbyFragment
  }
}
