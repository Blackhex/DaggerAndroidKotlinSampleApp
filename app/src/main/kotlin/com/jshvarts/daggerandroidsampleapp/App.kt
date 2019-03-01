package com.jshvarts.daggerandroidsampleapp

import android.app.*

import com.jshvarts.daggerandroidsampleapp.di.*

import dagger.android.*

import javax.inject.*

/**
 * https://github.com/google/dagger/issues/1267
 * https://github.com/roshakorost/Dagger-Android-Cookbook
 */
class App:
  Application(),
  HasActivityInjector, HasFragmentInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  private val appComponent by lazy {
    DaggerAppComponent.builder()
      .application(this)
      .build()
  }

  private var activityComponent: ActivityComponent? = null

  fun enterActivityScope(activity: Activity) {
    activityComponent = appComponent.activityComponent()
      .activity(activity)
      .build()
  }

  fun leaveActivityScope() {
    activityComponent = null
  }

  override fun onCreate() {
    super.onCreate()

    appComponent.inject(this)
  }

  override fun activityInjector() =
    AndroidInjector<Activity> {
      // Try to inject using more tightly scoped components first.
      activityComponent?.activityInjector()?.maybeInject(it)
        ?: activityInjector.maybeInject(it)
    }

  override fun fragmentInjector() =
    AndroidInjector<Fragment> {
      activityComponent?.fragmentInjector()?.maybeInject(it)
        ?: fragmentInjector.maybeInject(it)
    }
}
