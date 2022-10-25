package com.goodbit.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.goodbit.login.data.CadastroRepository
import com.goodbit.login.data.model.UserModel

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private var repository= CadastroRepository.getInstance(application)
    private var salvou_ = MutableLiveData<Boolean>()
    var salvou: LiveData<Boolean> = salvou_

    fun insert(userModel: UserModel){
        salvou_.value = repository.insert(userModel)
    }
}