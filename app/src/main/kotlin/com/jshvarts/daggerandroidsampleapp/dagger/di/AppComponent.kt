package com.jshvarts.daggerandroidsampleapp.dagger.di

import com.jshvarts.daggerandroidsampleapp.*

import dagger.*
import dagger.android.*

import javax.inject.*

@Singleton
@Component(
  modules = [
    AppModule::class
  ]
)
interface AppComponent:
  AndroidInjector<App> {

  @Component.Builder
  abstract class Builder:
    AndroidInjector.Builder<App>()
}
