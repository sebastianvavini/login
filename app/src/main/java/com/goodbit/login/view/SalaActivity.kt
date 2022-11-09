package com.goodbit.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.goodbit.login.R
import com.goodbit.login.databinding.ActivitySalaBinding
import com.goodbit.login.viewmodel.CadastroViewModel
import com.goodbit.login.viewmodel.SalaViewModel

class SalaActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySalaBinding
    private lateinit var viewModel: SalaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySalaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this).get(SalaViewModel::class.java)

        var intensao= intent
        var str= intent.getStringExtra("user_key")

        binding.textViewWellCome.text="Bem Vindo, $str"
    }
}