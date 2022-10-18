package com.example.testcm2.utility.file

import android.content.Context
import org.json.JSONObject

abstract class JSONFileStorage<T> (context : Context, name:String):FileStorage<T>(context,name, extension = "json"){


    protected abstract fun objToJSON(id:Int,obj:T): JSONObject
    protected abstract fun jsonToObj(json : JSONObject):T

    override fun dataToString(data: HashMap<Int, T>): String {
        val json = JSONObject()
        TODO("Not yet implemented")
        return json.toString()
    }

    override fun stringToData(value: String): HashMap<Int, T> {
        val data = HashMap<Int,T>()
        TODO("Not yet implemented")
        return data
    }
}