package com.jshvarts.daggerandroidsampleapp.dagger.di

import com.jshvarts.daggerandroidsampleapp.dependencies.*

import dagger.*

@Module
class LobbyFragmentModule {

  @ActivityScope
  @Provides
  fun provideLobbyFragmentHelloService() = LobbyFragmentHelloService()
}
