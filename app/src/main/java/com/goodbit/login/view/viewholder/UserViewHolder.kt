package com.goodbit.login.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.goodbit.login.data.model.UserModel
import com.goodbit.login.databinding.RowUserBinding

class UserViewHolder(private val bind: RowUserBinding) :RecyclerView.ViewHolder(bind.root) {

    fun bind(user:UserModel){
        bind.textUsername.text=user.user
    }
}