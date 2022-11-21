package hu.bme.aut.android.receptek.network

import hu.bme.aut.android.receptek.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("/api/recipes/v2")
    fun getRecipes(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("type") type: String,
        @Query("q") q: String?,
        @Query("ingr") i: Int?,
        @Query("mealtype") mt: String?,
        @Query("health") h: List<String?>?
    ): Call<Response>?
}