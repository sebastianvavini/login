package com.goodbit.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.goodbit.login.data.CadastroRepository
import com.goodbit.login.data.model.UserModel

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private var repository= CadastroRepository.getInstance(application)

    fun insert(userModel: UserModel){
        repository.insert(userModel)
    }
}