package com.soulje.mvpapp.presenter

import com.soulje.mvpapp.impl.DbRepo
import com.soulje.mvpapp.impl.DbRepoImpl
import com.soulje.mvpapp.model.User
import com.soulje.mvpapp.ui.Contract

class LoginPresenter : Contract.Presenter {

    private var view : Contract.View? = null
    private val dbRepo: DbRepo = DbRepoImpl()

    override fun onAttach(view: Contract.View) {
        this.view = view
        view.setState(Contract.ViewState.IDLE)
    }

    override fun onDetach() {
        view = null
    }

    override fun onCheck(user: User) {
        view?.setState(Contract.ViewState.LOADING)
        checkUser(user)
    }

    private fun checkUser(user: User){
        if(dbRepo.checkUser(user)){
            view?.setState(Contract.ViewState.SUCCESS)
        }else{
            view?.setState(Contract.ViewState.ERROR)
        }
    }

    override fun onSave(user: User) {
        view?.setState(Contract.ViewState.LOADING)
        dbRepo.saveUser(user)
        view?.setState(Contract.ViewState.SUCCESS)
    }

    override fun onChangePassword() {
        view?.setState(Contract.ViewState.LOADING)
        dbRepo.updatePassword()
        view?.setState(Contract.ViewState.SUCCESS)
    }

}