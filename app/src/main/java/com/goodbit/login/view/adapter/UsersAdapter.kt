package com.goodbit.login.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goodbit.login.data.model.UserModel
import com.goodbit.login.databinding.RowUserBinding
import com.goodbit.login.view.viewholder.UserViewHolder

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {
        private var listaUsers: List<UserModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
      val item = RowUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(item)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listaUsers[position])
    }

    override fun getItemCount(): Int {
        return listaUsers.count()
    }

        fun updateUsers(list: List<UserModel>){
              listaUsers=list
            notifyDataSetChanged()
        }
}