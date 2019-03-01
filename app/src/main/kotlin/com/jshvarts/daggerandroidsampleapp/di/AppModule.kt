package com.jshvarts.daggerandroidsampleapp.di

import android.app.*

import com.jshvarts.daggerandroidsampleapp.common.data.*

import dagger.*

import javax.inject.*

@Module
class AppModule {

  @Singleton
  @Provides
  fun provideContext(application: Application) = application.applicationContext

  @Singleton
  @Provides
  fun providesCommonHelloService() = CommonHelloService()
}
