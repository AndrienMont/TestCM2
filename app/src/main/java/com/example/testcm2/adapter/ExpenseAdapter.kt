package com.example.testcm2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testcm2.R
import com.example.testcm2.utility.ExpenseStorage

abstract class ExpenseAdapter(private val context : Context): RecyclerView.Adapter<ExpenseAdapter.ExpenseHolder>() {
    class ExpenseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val category: ImageView = itemView.findViewById(R.id.expense_category)
        val name: TextView = itemView.findViewById(R.id.expense_name)
        val amount: TextView = itemView.findViewById(R.id.expense_amount)
    }
    abstract fun onItemClick(view : View)
    abstract fun onLongItemClick(view : View): Boolean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        view.setOnClickListener{view -> onItemClick(view)}
        view.setOnLongClickListener{view -> onLongItemClick(view)}
        return ExpenseHolder(view)

    }

    override fun onBindViewHolder(holder: ExpenseHolder, position: Int) {
        val expense = ExpenseStorage.get(context).findAll().get(position)
        holder.itemView.tag = expense.id
        holder.category.setImageResource(CategoryAdapter.getIcon(expense.category))
        holder.name.text= expense.name
        holder.amount.text = "${expense.amount}euros"
    }

    override fun getItemCount(): Int {
        return 10
    }

}