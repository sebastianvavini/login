package com.goodbit.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.goodbit.login.R
import com.goodbit.login.data.model.UserModel
import com.goodbit.login.databinding.ActivityLoginBinding
import com.goodbit.login.viewmodel.CadastroViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get(CadastroViewModel::class.java)

        binding.buttonEntrar.setOnClickListener(this)

        viewModel.logou.observe(this){
            println("Logou = $it")
        }
    }

    override fun onClick(v: View) {
        if(v.id==R.id.button_entrar){

            val username=binding.editLogin.text.toString()
            val passwd= binding.editPassword.text.toString()

            val user= UserModel(0,username,"--------",passwd,"-------")
            viewModel.getUser(user)
        }
    }
}