package com.jshvarts.daggerandroidsampleapp.lobby

import android.app.*
import android.os.*
import android.view.*
import android.widget.*

import butterknife.*

import com.jshvarts.daggerandroidsampleapp.R

import javax.inject.*

class LobbyFragment:
  BaseFragment() {

  @Inject
  lateinit var alertDialogBuilder: AlertDialog.Builder

  @Inject
  lateinit var lobbyFragmentHelloService: LobbyFragmentHelloService

  @BindView(R.id.lobby_fragment_hello)
  lateinit var lobbyFragmentHelloTextView: TextView

  lateinit var unbinder: Unbinder

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.lobby_fragment, container, false)
    unbinder = ButterKnife.bind(this, view)
    return view
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    sayFragmentHello()
    showAlertDialog()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    unbinder.unbind()
  }

  private fun sayFragmentHello() {
    lobbyFragmentHelloTextView.text = lobbyFragmentHelloService.sayHello()
  }

  private fun showAlertDialog() {
    alertDialogBuilder.setTitle("Hello")
      .setMessage("Hello, World from Fragment!")
      .create()
      .show()
  }
}