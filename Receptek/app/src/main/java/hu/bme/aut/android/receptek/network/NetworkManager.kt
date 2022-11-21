package hu.bme.aut.android.receptek.network

import hu.bme.aut.android.receptek.model.Response
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private val retrofit: Retrofit
    private val recipeapi: RecipeApi

    private const val SERVICE_URL = "https://api.edamam.com"
    private const val APP_ID = "563f57a5"
    private const val APP_KEY = "11de26fe6e9a456da1df9ce6296cdde5"

    init{
        retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        recipeapi = retrofit.create(RecipeApi::class.java)
    }

    fun getListofRecipes(searchword: String?, maxingr: Int?, mealtype: String?, health: List<String>?): Call<Response>?{
        return recipeapi.getRecipes(APP_ID, APP_KEY, "public", searchword, maxingr, mealtype, health)
    }

}