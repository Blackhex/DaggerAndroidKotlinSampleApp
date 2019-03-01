package com.jshvarts.daggerandroidsampleapp.di

import com.jshvarts.daggerandroidsampleapp.lobby.*

import dagger.*
import dagger.android.*

@Module
abstract class FragmentsBindingModule {

  @ContributesAndroidInjector(
    modules = [
      LobbyFragmentModule::class
    ]
  )
  abstract fun bindLobbyFragment(): LobbyFragment
}
