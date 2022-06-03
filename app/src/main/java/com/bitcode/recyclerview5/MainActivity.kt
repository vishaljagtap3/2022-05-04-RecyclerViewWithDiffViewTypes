package com.bitcode.recyclerview5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.recyclerview5.adapters.ProductsAdapter
import com.bitcode.recyclerview5.models.Advertisement
import com.bitcode.recyclerview5.models.Product

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerProducts : RecyclerView
    private lateinit var products : ArrayList<Product>
    private lateinit var advertisements : ArrayList<Advertisement>
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        productsAdapter = ProductsAdapter(products, advertisements)
        recyclerProducts.adapter = productsAdapter
        recyclerProducts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        products = ArrayList<Product>()
        for(i in 0..20) {
            products.add(Product(i, "Product $i", 100 * i + 5, R.mipmap.ic_launcher))
        }

        advertisements = ArrayList<Advertisement>()
        for(i in 0..4) {
            advertisements.add(
                Advertisement(i, "Advertisement of BitCode $i", R.mipmap.ic_launcher)
            )
        }
    }

    private fun initViews() {
        recyclerProducts = findViewById(R.id.recyclerProducts)
    }
}