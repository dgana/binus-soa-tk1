package com.example.soa_kotlin

class Items(name: String?, price:Int?, qty:Int?, unit:String?) {
    private var name:String
    private var unit:String
    private var price:Int
    private var qty:Int
    init {
        this.name = name!!
        this.price = price!!
        this.qty = qty!!
        this.unit = unit!!
    }
    fun getName(): String? {
        return name
    }
    fun setName(name: String?) {
        this.name = name!!
    }
    fun getUnit(): String? {
        return unit
    }
    fun setUnit(unit: String?) {
        this.unit = unit!!
    }
    fun getPrice(): Int? {
        return price
    }
    fun setPrice(price: Int?) {
        this.price = price!!
    }
    fun getQty(): Int? {
        return qty
    }
    fun setQty(price: Int?) {
        this.qty = price!!
    }
}