package com.soulje.mvpapp.ui

import com.soulje.mvpapp.model.User

class Contract {

    enum class ViewState{
        IDLE, LOADING, SUCCESS, ERROR
    }

    interface View{
        fun setState(state: ViewState)
    }

    interface Presenter{
        fun onAttach(view: View)
        fun onDetach()
        fun onCheck(user: User)
        fun onSave(user: User)
        fun onChangePassword()
    }

}