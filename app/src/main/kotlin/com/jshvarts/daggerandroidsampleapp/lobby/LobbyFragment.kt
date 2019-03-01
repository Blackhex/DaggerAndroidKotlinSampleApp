package com.jshvarts.daggerandroidsampleapp.lobby

import android.content.*
import android.os.*
import android.view.*
import android.widget.*

import butterknife.*

import com.jshvarts.daggerandroidsampleapp.R
import com.jshvarts.daggerandroidsampleapp.com.jshvarts.daggerandroidmvp.lobby.*
import com.jshvarts.daggerandroidsampleapp.common.data.*

import javax.inject.*

class LobbyFragment:
  BaseFragment() {

  @Inject
  lateinit var theContext: Context

  @Inject
  lateinit var commonHelloService: CommonHelloService

  @Inject
  lateinit var lobbyActivityHelloService: LobbyActivityHelloService

  @Inject
  lateinit var lobbyFragmentHelloService: LobbyFragmentHelloService

  @BindView(R.id.common_hello)
  lateinit var commonHelloTextView: TextView

  @BindView(R.id.lobby_activity_hello)
  lateinit var lobbyActivityHelloTextView: TextView

  @BindView(R.id.lobby_fragment_hello)
  lateinit var lobbyFragmentHelloTextView: TextView

  lateinit var unbinder: Unbinder

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.lobby_fragment, container, false)
    unbinder = ButterKnife.bind(this, view)

    LobbyFragmentFoo(this)

    return view
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    sayCommonHello()
    sayActivityHello()
    sayFragmentHello()
    //showAlertDialog()
  }

  override fun onDestroyView() {
    super.onDestroyView()

    unbinder.unbind()
  }

  private fun sayCommonHello() {
    commonHelloTextView.text = commonHelloService.sayHello()
  }

  private fun sayActivityHello() {
    lobbyActivityHelloTextView.text = lobbyActivityHelloService.sayHello()
  }

  private fun sayFragmentHello() {
    lobbyFragmentHelloTextView.text = lobbyFragmentHelloService.sayHello()
  }

  private fun showAlertDialog() {
    alertDialogBuilder.setTitle("Hello")
      .setMessage("Hello, World from Fragment created by ${theContext.hashCode()}")
      .create()
      .show()
  }
}