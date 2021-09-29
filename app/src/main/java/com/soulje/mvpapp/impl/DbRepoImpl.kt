package com.soulje.mvpapp.impl

import com.soulje.mvpapp.model.User


class DbRepoImpl : DbRepo {
    override fun checkUser(user: User): Boolean {
        return true
    }

    override fun saveUser(user: User) {
        //save user into database
    }

    override fun updatePassword() {
        //update password into database
    }
}