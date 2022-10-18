package com.example.testcm2.utility

interface Storage<T> {
    fun insert(obj : T): Int
    fun size(): Int
    fun find(id : Int): T?
    fun findAll(): List<T>
    fun update(id : Int, obj : T)
    fun delete(id : Int)
}