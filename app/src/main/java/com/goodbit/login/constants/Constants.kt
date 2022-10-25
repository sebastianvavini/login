package com.goodbit.login.constants

class Constants private constructor(){

    object TABLE {
        const val TABLE_NAME_USER="user"
    }
    object COLUMNS_USER{
        //(user:String, password:String,whatsapp:String)
        const val ID="id"
        const val CPF="cpf"
        const val USER="user"
        const val PASSWORD="password"
        const val WHATSAPP="whatsapp"

    }

}