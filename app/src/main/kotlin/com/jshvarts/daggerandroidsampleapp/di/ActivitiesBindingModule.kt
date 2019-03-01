package com.jshvarts.daggerandroidsampleapp.di

import com.jshvarts.daggerandroidsampleapp.lobby.*

import dagger.*
import dagger.android.*

@Module
abstract class ActivitiesBindingModule {

  @ContributesAndroidInjector(
    modules = [
      LobbyActivityModule::class
    ]
  )
  abstract fun bindLobbyActivity(): LobbyActivity
}
