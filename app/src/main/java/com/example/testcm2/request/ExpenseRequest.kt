package com.example.testcm2.request


import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.testcm2.R


class ExpenseRequest (private val context : Context){
    //code du cours
    init {
        val request = JsonObjectRequest(
            Request.Method.GET,
            "http://51.68.95.247/expenses",
            null,
            { res ->
                Toast.makeText(context, R.string.success, Toast.LENGTH_SHORT).show()
                val jsonArray = res.getJSONArray("expenses")

            },
            { err -> Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show() }
        )
        val queue = Volley.newRequestQueue(context)
        queue.add(request)
        queue.start()

    }


}