package com.goodbit.login.data.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.goodbit.login.constants.Constants

class LoginBanco (context: Context) :
    SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME= "loginDB"
        private const val VERSION=1


    }

    override fun onCreate(db: SQLiteDatabase) {

        val tabela= Constants.TABLE.TABLE_NAME_USER
        val id= Constants.COLUMNS_USER.ID

        val username=Constants.COLUMNS_USER.USER
        val cpf= Constants.COLUMNS_USER.CPF
        val whats=Constants.COLUMNS_USER.WHATSAPP
        val password=Constants.COLUMNS_USER.PASSWORD


        db.execSQL("create table $tabela ("+
                "$id integer primary key autoincrement,"+
                "$username text,"+ "$cpf text,"+ "$password text,"+"$whats text"+
                ")")

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}