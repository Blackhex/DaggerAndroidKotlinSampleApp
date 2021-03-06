package com.jshvarts.daggerandroidsampleapp

import android.app.*

import com.jshvarts.daggerandroidsampleapp.dagger.di.*
import com.jshvarts.daggerandroidsampleapp.dagger.ui.*
import com.jshvarts.daggerandroidsampleapp.koin.di.*

import dagger.android.*

import org.koin.android.ext.android.*

import javax.inject.*

/**
 * https://github.com/google/dagger/issues/1267
 * https://github.com/roshakorost/Dagger-Android-Cookbook
 * https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd
 * https://github.com/vestrel00/android-dagger-butterknife-mvp
 */
class App:
  Application(),
  HasActivityInjector,
  HasFragmentInjector,
  HasFooInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  @Inject
  lateinit var fooInjector: DispatchingAndroidInjector<BaseFragmentFoo>

  private val appComponent by lazy {
    DaggerAppComponent.builder()
      .create(this)
  }

  override fun onCreate() {
    super.onCreate()

    startKoin(
      this,
      listOf(
        appModule,
        activityModule,
        lobbyActivityModule,
        lobbyFragmentHelloService
      )
    )

    appComponent.inject(this)
  }

  override fun activityInjector() = activityInjector

  override fun fragmentInjector() = fragmentInjector

  override fun fooInjector() = fooInjector
}
