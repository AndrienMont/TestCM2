package com.example.testcm2.utility

import com.example.testcm2.model.Expense

class ExpenseNoneStorage: Storage<Expense> {

    override fun insert(obj: Expense): Int {
        return 0
    }

    override fun size(): Int {
        return 0
    }

    override fun find(id: Int): Expense? {
        return null
    }

    override fun findAll(): List<Expense> {
        return emptyList()
    }

    override fun update(id: Int, obj: Expense) {

    }

    override fun delete(id: Int) {

    }
}