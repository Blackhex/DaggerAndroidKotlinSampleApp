package com.jshvarts.daggerandroidsampleapp.lobby

import android.app.*
import android.os.*
import android.widget.*

import butterknife.*

import com.jshvarts.daggerandroidsampleapp.R
import com.jshvarts.daggerandroidsampleapp.common.data.*

import javax.inject.*

class LobbyActivity:
  BaseActivity() {

  @Inject
  lateinit var commonHelloService: CommonHelloService

  @Inject
  lateinit var alertDialogBuilder: AlertDialog.Builder

  @Inject
  lateinit var lobbyActivityHelloService: LobbyActivityHelloService

  @BindView(R.id.common_hello)
  lateinit var commonHelloTextView: TextView

  @BindView(R.id.lobby_hello)
  lateinit var lobbyHelloTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.lobby_activity)

    ButterKnife.bind(this)

    sayCommonHello()
    sayLobbyHello()
    showAlertDialog()
  }

  private fun sayCommonHello() {
    commonHelloTextView.text = commonHelloService.sayHello()
  }

  private fun sayLobbyHello() {
    lobbyHelloTextView.text = lobbyActivityHelloService.sayHello()
  }

  private fun showAlertDialog() {
    alertDialogBuilder.setTitle("Hello")
      .setMessage("Hello, World from Activity!")
      .create()
      .show()
  }
}
