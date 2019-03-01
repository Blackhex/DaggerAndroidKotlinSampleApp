package com.jshvarts.daggerandroidsampleapp.lobby

import com.jshvarts.daggerandroidsampleapp.dagger.*

import dagger.*

@Module
class LobbyFragmentModule {

  @ActivityScope
  @Provides
  fun provideLobbyFragmentHelloService() = LobbyFragmentHelloService()
}
