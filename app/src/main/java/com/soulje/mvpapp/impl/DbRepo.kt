package com.soulje.mvpapp.impl

import com.soulje.mvpapp.model.User

interface DbRepo {
    fun checkUser(user : User) : Boolean
    fun saveUser(user : User)
    fun updatePassword()
}