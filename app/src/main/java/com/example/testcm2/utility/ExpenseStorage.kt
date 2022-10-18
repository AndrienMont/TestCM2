package com.example.testcm2.utility

import android.content.Context
import android.content.SharedPreferences
import com.example.testcm2.model.Expense

object ExpenseStorage {
    private const val STORAGE = "storage"
    const val NONE = 0
    const val DATA_BASE = 1
    const val FILE_JSON = 2
    private const val DEFAULT = NONE

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("com.example.testcm2.preferences",Context.MODE_PRIVATE)
    }

    fun getStorage(context: Context): Int {
        return getPreferences(context).getInt(STORAGE, DEFAULT)
    }

    fun setStorage(context: Context, prefStorage: Int) {
        getPreferences(context).edit().putInt(STORAGE, prefStorage).apply()
    }

    fun get(context: Context): Storage<Expense> {
        lateinit var storage: Storage<Expense>
        when (getStorage(context)) {
            0 -> storage = ExpenseNoneStorage()
            1 -> storage = ExpenseDataBaseStorage(context)
            2 -> storage = ExpenseJSONFileStorage(context)
        }
        return storage
    }
}