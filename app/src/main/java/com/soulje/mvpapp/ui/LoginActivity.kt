package com.soulje.mvpapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.soulje.mvpapp.R
import com.soulje.mvpapp.databinding.ActivityLoginBinding
import com.soulje.mvpapp.model.User
import com.soulje.mvpapp.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityLoginBinding
    private val presenter: Contract.Presenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.onAttach(this)
        initView()
    }

    private fun initView() {
        initLoginButton()
        initSignInButton()
        initForgotPasswordButton()
    }

    private fun initLoginButton(){
        binding.loginButton.setOnClickListener {
            presenter.onCheck(getUser())
        }
    }

    private fun initSignInButton(){
        binding.signInButton.setOnClickListener {
            presenter.onSave(getUser())
        }
    }

    private fun initForgotPasswordButton(){
        binding.forgotPasswordButton.setOnClickListener {
            presenter.onChangePassword()
        }
    }


    private fun getUser(): User {
        return User(
            binding.loginInput.text.toString(),
            binding.passwordInput.text.toString()
        )
    }

    override fun setState(state: Contract.ViewState) {
        setVisibility()
        initStateChoice(state)
    }

    private fun setVisibility(){
        binding.statusIcon.visibility = View.GONE
        binding.contentLayout.visibility = View.GONE
        binding.progress.visibility = View.GONE
    }

    private fun initStateChoice(state: Contract.ViewState){
        when(state){
            Contract.ViewState.LOADING -> {
                binding.progress.visibility = View.VISIBLE
            }
            Contract.ViewState.IDLE -> {
                binding.contentLayout.visibility = View.VISIBLE
            }
            Contract.ViewState.ERROR -> {
                initErrorState()
            }
            Contract.ViewState.SUCCESS -> {
                binding.statusIcon.visibility = View.VISIBLE
            }
        }
    }

    private fun initErrorState(){
        binding.contentLayout.visibility = View.VISIBLE
        Snackbar.make(binding.root,getString(R.string.error_title), Snackbar.LENGTH_SHORT).show()
    }




}