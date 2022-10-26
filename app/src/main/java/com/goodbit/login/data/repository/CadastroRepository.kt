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
    fun getAll():List<UserModel>{

        val list= mutableListOf<UserModel>()
        try {

            val db=database.readableDatabase

            val tabela= Constants.TABLE.TABLE_NAME_USER

            val id=Constants.COLUMNS_USER.ID
            val username=Constants.COLUMNS_USER.USER
            val whats= Constants.COLUMNS_USER.WHATSAPP
            val cpf= Constants.COLUMNS_USER.CPF


            val columns= arrayOf(id,username,whats,cpf)
            val cursor=db.query(tabela,columns,null,
                null,null,null,null)
            if(cursor!=null && cursor.count>0){

                while (cursor.moveToNext()){
                    val usename_= cursor.getString(cursor.getColumnIndex(username))
                    val cpf_= cursor.getString(cursor.getColumnIndex(cpf))
                    val whats_=cursor.getString(cursor.getColumnIndex(whats))
                    val id_ =cursor.getInt(cursor.getColumnIndex(id))

                    list.add( UserModel(id_,usename_,cpf_,"********",whats_))
                }
            }
            cursor.close()
        }
        catch (e:Exception){
            return list
        }
        return list

    }

    fun getUser(user: UserModel):Boolean{

        try {
            val db = database.writableDatabase

            val tabela= Constants.TABLE.TABLE_NAME_USER

           // db.insert(tabela,null,values)

            "select * from user where user=? and password=?"

            return true
        }
        catch (e:Exception){
            return false
        }
    }

}