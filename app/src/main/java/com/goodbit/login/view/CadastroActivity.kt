package com.goodbit.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.goodbit.login.viewmodel.CadastroViewModel
import com.goodbit.login.R
import com.goodbit.login.data.model.UserModel
import com.goodbit.login.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var viewModel: CadastroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSalvar.setOnClickListener(this)
        binding.buttonIrLogin.setOnClickListener(this)



        viewModel= ViewModelProvider(this).get(CadastroViewModel::class.java)
        viewModel.salvou.observe(this){

            if (it){
               Toast.makeText(this,"Salvou, Amigo!",Toast.LENGTH_LONG).show()
                binding.editUsername.setText("")
                binding.editSenha.setText("")
                binding.editCpf.setText("")
                binding.editWhats.setText("")
                binding.buttonIrLogin.isVisible=true
            }
        }
    }

    override fun onClick(v: View) {
        if (v.id== R.id.button_salvar){

           val username= binding.editUsername.text.toString()
            val password=  binding.editSenha.text.toString()
            val cpf=binding.editCpf.text.toString()
            val whatsapp=binding.editWhats.toString()


            val user= UserModel(0,username,cpf,password,whatsapp)

            viewModel.insert(user)
            println("Passou do insert")



        }
        if(v.id==R.id.button_ir_login){
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}