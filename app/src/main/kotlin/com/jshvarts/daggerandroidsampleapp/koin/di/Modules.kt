package com.jshvarts.daggerandroidsampleapp.koin.di

import android.app.*

import com.jshvarts.daggerandroidsampleapp.dependencies.*

import org.koin.dsl.module.*

object Scope {
  const val APP = "app"
  const val ACTIVITY = "activity"
  const val FRAGMENT = "fragment"
}

val appModule = module {

  single { CommonHelloService() }
}

val activityModule = module {

  scope(Scope.ACTIVITY) { AlertDialog.Builder(get()) }
}

val lobbyActivityModule = module {

  scope(Scope.ACTIVITY) { LobbyActivityHelloService() }
}

val lobbyFragmentHelloService = module {

  scope(Scope.FRAGMENT) { LobbyFragmentHelloService() }
}
