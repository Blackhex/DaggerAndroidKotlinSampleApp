package com.jshvarts.daggerandroidsampleapp.dagger.ui

import android.content.*
import android.os.*
import android.view.*
import android.widget.*

import butterknife.*

import com.jshvarts.daggerandroidsampleapp.R
import com.jshvarts.daggerandroidsampleapp.dependencies.*

import javax.inject.*

class LobbyActivity:
  BaseActivity() {

  @Inject
  lateinit var theContext: Context

  @Inject
  lateinit var commonHelloService: CommonHelloService

  @Inject
  lateinit var lobbyActivityHelloService: LobbyActivityHelloService

  @BindView(R.id.common_hello)
  lateinit var commonHelloTextView: TextView

  @BindView(R.id.lobby_activity_hello)
  lateinit var lobbyActivityHelloTextView: TextView

  fun onNewActivityButtonClick(view: View) {
    startActivity(Intent(this, LobbyActivity::class.java))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.dagger_lobby_activity)

    ButterKnife.bind(this)

    sayCommonHello()
    sayActivityHello()
    showDynamicLobbyFragment()
    //showAlertDialog()
  }

  private fun sayCommonHello() {
    commonHelloTextView.text = commonHelloService.sayHello()
  }

  private fun sayActivityHello() {
    lobbyActivityHelloTextView.text = lobbyActivityHelloService.sayHello()
  }

  private fun showDynamicLobbyFragment() {
    fragmentManager.beginTransaction()
      .add(R.id.lobby_fragment_container, LobbyFragment())
      .commit()
  }

  private fun showAlertDialog() {
    alertDialogBuilder.setTitle("Hello")
      .setMessage("Hello, World from Activity created by ${theContext.hashCode()}")
      .create()
      .show()
  }
}
