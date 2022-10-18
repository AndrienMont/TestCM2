package com.example.testcm2.utility

import android.content.Context
import com.example.testcm2.model.Expense
import com.example.testcm2.utility.file.JSONFileStorage
import org.json.JSONObject

class ExpenseJSONFileStorage (context : Context): JSONFileStorage<Expense>(context, "expense") {

    override fun create(id: Int, obj: Expense): Expense {
        return Expense(id,obj.name,obj.category,obj.amount,obj.date,obj.author)
    }

    override fun objToJSON(id: Int, obj: Expense): JSONObject {
        var res = JSONObject()
        res.put(Expense.ID, id)
        res.put(Expense.CATEGORY, obj.category)
        res.put(Expense.NAME, obj.name)
        res.put(Expense.AUTHOR, obj.author)
        res.put(Expense.DATE, obj.date)
        return res
    }

    override fun jsonToObj(json: JSONObject): Expense {
        return Expense(
            json.getInt(Expense.ID),
            json.getString(Expense.NAME),
            json.getInt(Expense.CATEGORY),
            json.getString(Expense.AMOUNT),
            json.getString(Expense.DATE),
            json.getInt(Expense.AUTHOR)
        )
    }
}