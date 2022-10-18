package com.example.testcm2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.testcm2.R
import com.example.testcm2.adapter.ExpenseAdapter
import com.example.testcm2.dialog.ExpenseDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.expense_list).adapter = ExpenseAdapter()

        findViewById<FloatingActionButton>(R.id.expense_add).setOnClickListener(){
            ExpenseDialogFragment(null).show(supportFragmentManager,null)
        }
        list = findViewById(R.id.expense_list)
        list.adapter = object : ExpenseAdapter(applicationContext){
            override fun onItemClick(view: View) {
                val intent = Intent(applicationContext, ExpenseActivity::class.java).apply{
                    putExtra(EXTRA_EXPENSE,view.tag as Int)
                }
                startActivity(intent)
            }
        }
        }
    }
