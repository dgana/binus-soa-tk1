package com.example.soa_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var itemList:ArrayList<Items>
    private lateinit var adapter: CustomAdapter
    val TAG = "PESAN"
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        adapter = CustomAdapter(itemList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
    private fun getData(){
        itemList = ArrayList()
        db.collection("inventory")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    itemList.add(
                        Items(
                            document.data["name"].toString(),
                            document.data["price"].toString().toInt(),
                            document.data["quantity"].toString().toInt(),
                            document.data["unit"].toString()
                        )
                    )
                    adapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }
}