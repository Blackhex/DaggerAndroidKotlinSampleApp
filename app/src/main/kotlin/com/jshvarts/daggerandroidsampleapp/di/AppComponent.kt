package com.jshvarts.daggerandroidsampleapp.di

import android.app.*
import android.content.*

import com.jshvarts.daggerandroidsampleapp.*
import com.jshvarts.daggerandroidsampleapp.common.data.*

import dagger.*
import dagger.android.*

import javax.inject.*

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AppModule::class
  ]
)
interface AppComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun appModule(module: AppModule): Builder

    fun build(): AppComponent
  }

  fun activityComponent(): ActivityComponent.Builder

  fun context(): Context
  fun commonHelloService(): CommonHelloService

  fun inject(application: App)
}
