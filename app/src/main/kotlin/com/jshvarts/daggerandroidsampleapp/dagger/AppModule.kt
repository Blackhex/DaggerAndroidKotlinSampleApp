package com.jshvarts.daggerandroidsampleapp.dagger

import android.app.*

import com.jshvarts.daggerandroidsampleapp.*
import com.jshvarts.daggerandroidsampleapp.common.data.*

import dagger.*
import dagger.android.*

import javax.inject.*

@Module(
  includes = [
    AndroidInjectionModule::class,
    AppModule.BindingModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    FooBindingModule::class
  ]
)
class AppModule {

  @Module
  abstract class BindingModule {

    @Singleton
    @Binds
    abstract fun application(app: App): Application
  }

  @Singleton
  @Provides
  fun providesCommonHelloService() = CommonHelloService()
}
