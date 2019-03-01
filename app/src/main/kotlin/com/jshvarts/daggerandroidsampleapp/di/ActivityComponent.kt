package com.jshvarts.daggerandroidsampleapp.di

import android.app.*

import dagger.*
import dagger.android.*

@ActivityScope
@Subcomponent(
  modules = [
    ActivityModule::class,
    ActivitiesBindingModule::class,
    FragmentsBindingModule::class
  ]
)
interface ActivityComponent {

  @Subcomponent.Builder
  interface Builder {

    @BindsInstance
    fun activity(activity: Activity): Builder

    fun activityModule(module: ActivityModule): Builder

    fun build(): ActivityComponent
  }

  fun activityInjector(): DispatchingAndroidInjector<Activity>
  fun fragmentInjector(): DispatchingAndroidInjector<Fragment>
}
