package com.jshvarts.daggerandroidsampleapp.dagger.di

import com.jshvarts.daggerandroidsampleapp.dependencies.*

import dagger.*

@Module
class LobbyActivityModule {

  @ActivityScope
  @Provides
  fun provideLobbyActivityHelloService() = LobbyActivityHelloService()
}
