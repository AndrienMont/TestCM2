package com.example.testcm2.utility.file

import android.content.Context
import com.example.testcm2.utility.Storage
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

abstract class FileStorage<T> (private val context : Context, name : String, extension : String): Storage<T> {

    protected abstract fun create(id:Int, obj:T):T
    protected abstract fun dataToString(data:HashMap<Int,T>) :String
    protected abstract fun stringToData(value:String):HashMap<Int,T>

    private val filename = "storage.$name.$extension"
    private var data = HashMap<Int, T>()
    private var nextId = 1

    private fun max(keys: Set<Int>): Int {
        var res = 1
        keys.forEach{key ->
            if (res < key) res = key
        }
        return res
    }

    private fun read(){
        try {
            val input = context.openFileInput(filename)
            //println(context.filesDir) Affiche le répertoire où le fichier sera sauvegardé
            if(input != null){
                val builder = StringBuilder()
                var bufferedReader = BufferedReader(InputStreamReader(input))
                var tmp = bufferedReader.readLine()
                while(tmp != null){
                    builder.append(tmp)
                    tmp = bufferedReader.readLine()
                }
                input.close()
                data = stringToData(builder.toString())
                nextId = if (data.keys.size == 0) 1 else max(data.keys) +1
            }
        } catch (e : FileNotFoundException){
            write()
        }
    }



    private fun write(){
        val output = context.openFileOutput(filename, Context.MODE_PRIVATE)
        val writer = OutputStreamWriter(output)
        writer.write(dataToString(data))
        writer.close()
    }

    override fun insert(obj: T): Int {
        //TODO("Not yet implemented")
        data.put(nextId, obj)
        nextId++
        write()
        return nextId -1
    }

    override fun size(): Int {
        //TODO("Not yet implemented")
        return data.size
    }

    override fun find(id: Int): T? {
       //TODO("Not yet implemented")
        return data[id]
    }

    override fun findAll(): List<T> {
        //TODO("Not yet implemented")
        val list: List<T> = emptyList()
        for((k,v) in data){
            list + v
        }
        return list

    }

    override fun update(id: Int, obj: T) {
        //TODO("Not yet implemented")
        data.put(id,obj)
        write()
    }

    override fun delete(id: Int) {
        //TODO("Not yet implemented")
        data.remove(id)
        write()
    }
}