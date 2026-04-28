package api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Product
import okhttp3.OkHttpClient
import okhttp3.Request
import utilis.Logger

class ProductApi {

    private val client = OkHttpClient()
    private val gson = Gson()

    fun getAllProducts(): List<Product> {
        Logger.log("Fetching products from API...")

        val request = Request.Builder()
            .url("https://fakestoreapi.com/products")
            .build()

        val response = client.newCall(request).execute()
        val json = response.body?.string() ?: "[]"

        val type = object : TypeToken<List<Product>>() {}.type
        return gson.fromJson(json, type)
    }
    fun getProductById(id: Int): Product {
        Logger.log("Fetching product with ID: $id")

        val request = Request.Builder()
            .url("https://fakestoreapi.com/products/$id")
            .build()

        val response = client.newCall(request).execute()
        val json = response.body?.string() ?: "{}"

        return gson.fromJson(json, Product::class.java)
    }
    fun getStatusCode(): Int {
        val request = Request.Builder()
            .url("https://fakestoreapi.com/products")
            .build()

        val response = client.newCall(request).execute()
        return response.code
    }
}