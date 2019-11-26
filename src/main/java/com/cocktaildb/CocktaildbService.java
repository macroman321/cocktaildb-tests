package com.cocktaildb;

import com.cocktaildb.entities.Drink;
import com.cocktaildb.entities.Drinks;
import com.cocktaildb.entities.Ingredient;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

// Interface representing cocktaildb api endpoints
public interface CocktaildbService {

    @GET("search.php")
    Call<Drinks> searchCocktailsName(@Query("s") String DrinksName);

    @GET("lookup.php")
    Call<Drinks> searchCocktailsId(@Query("i") String drinkId);

    @GET("search.php")
    Call<Drinks> searchCocktailsFirstLetter(@Query("f") String firstLetter);

    @GET("search.php")
    Call<List<Ingredient>> searchIngredientsName(@Query("i") String ingredientName);

    @GET("lookup.php")
    Call<List<Ingredient>> searchIngredientsIde(@Query("iid") String ingredientId);

    @GET("random.php")
    Call<Drinks> searchRandomCocktail();

    @GET("filter.php")
    Call<Drinks> filterCocktailByIngredient(@Query("i") String ingredientName);

    @GET("filter.php")
    Call<Drinks> filterCocktailByAlcoholic(@Query("a") String alcoholic);

    @GET("filter.php")
    Call<Drinks> filterCocktailByCategory(@Query("c") String category);

    @GET("filter.php")
    Call<Drinks> filterCocktailByGlass(@Query("g") String glass);


}
