package com.goodbit.login.data.repository

import android.content.ContentValues
import android.content.Context
import com.goodbit.login.constants.Constants
import com.goodbit.login.data.model.UserModel

class CadastroRepository private constructor(context: Context){
    private val database= LoginBanco(context)

    companion object{
        private lateinit var repository: CadastroRepository

        fun getInstance(context: Context): CadastroRepository {
            if(!Companion::repository.isInitialized){
                repository = CadastroRepository(context)
            }
            return repository
        }
    }


    fun insert(user: UserModel):Boolean{

        try {
            val db = database.writableDatabase

            val tabela= Constants.TABLE.TABLE_NAME_USER

            val username=Constants.COLUMNS_USER.USER
            val password=Constants.COLUMNS_USER.PASSWORD
            val whats=Constants.COLUMNS_USER.WHATSAPP
            val cpf=Constants.COLUMNS_USER.CPF

            val values= ContentValues()

            values.put(username,user.user)
            values.put(password,user.password)
            values.put(whats,user.whatsapp)
            values.put(cpf,user.cpf)


            db.insert(tabela,null,values)

            return true
        }
        catch (e:Exception){
            return false
        }
    }

}