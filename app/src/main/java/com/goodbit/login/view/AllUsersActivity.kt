package com.goodbit.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.goodbit.login.R
import com.goodbit.login.databinding.ActivityAllUsersBinding
import com.goodbit.login.view.adapter.UsersAdapter
import com.goodbit.login.viewmodel.CadastroViewModel

class AllUsersActivity : AppCompatActivity() {

    private lateinit var viewModel: CadastroViewModel
    private lateinit var binding: ActivityAllUsersBinding
    private var adapter=UsersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityAllUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get(CadastroViewModel::class.java)
        observe()

        // Layout
        binding.recyclerAllUsers.layoutManager = LinearLayoutManager(applicationContext)

        //Adapter
        binding.recyclerAllUsers.adapter= adapter

        viewModel.getAllUsers()

    }
    fun observe(){
        viewModel.lista.observe(this){

            adapter.updateUsers(it)
        }
    }
}