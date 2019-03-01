package com.jshvarts.daggerandroidsampleapp.lobby

import dagger.*

@Module
class LobbyFragmentModule {

  @Provides
  fun provideLobbyFragmentHelloService() = LobbyFragmentHelloService()
}
