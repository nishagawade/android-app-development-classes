package com.example.myreceipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//GET allows us to do http requests

//couroutines are a powerful and lightweight concurrency framework in kotlin , specifically designed for
//handling asynchronous and non-blocking operations, like getting categories from the web

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val receipeService = retrofit.create(ApiService::class.java)

interface  ApiService{

    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse

}