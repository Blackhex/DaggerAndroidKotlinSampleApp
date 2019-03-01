package com.jshvarts.daggerandroidsampleapp.lobby

import com.jshvarts.daggerandroidsampleapp.dagger.*

import dagger.*

@Module
class LobbyActivityModule {

  @ActivityScope
  @Provides
  fun provideLobbyActivityHelloService() = LobbyActivityHelloService()
}
