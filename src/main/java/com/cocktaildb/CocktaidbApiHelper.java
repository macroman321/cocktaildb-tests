package com.cocktaildb;

import com.cocktaildb.entities.Drink;
import com.cocktaildb.entities.Drinks;
import com.cocktaildb.entities.Ingredient;
import com.cocktaildb.entities.configuration.EnvConfigurationSection;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import org.testng.ITestContext;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;


@Log4j2
@Data
public class CocktaidbApiHelper {
    private CocktaildbService cocktaildbService;
    private ITestContext context;

    public CocktaidbApiHelper(ITestContext context){
        this.context = context;
        this.cocktaildbService = setupCocktaildbService("1");
    }


    public Drinks searchCocktailsName(String drinkName) throws IOException {
        return cocktaildbService.searchCocktailsName(drinkName).execute().body();
    }

    public List<Ingredient> searchIngredientsName(String ingredientName) throws IOException {
        return cocktaildbService.searchIngredientsName(ingredientName).execute().body();
    }

    public Drinks searchCocktailsId(String ingredientName) throws IOException {
        return cocktaildbService.searchCocktailsId(ingredientName).execute().body();
    }

    public Drinks searchCocktailsFirstLetter(String firstLetter) throws IOException {
        return cocktaildbService.searchCocktailsFirstLetter(firstLetter).execute().body();
    }

    public List<Ingredient> searchIngredientsIde(String ingredientId) throws IOException {
        return cocktaildbService.searchIngredientsIde(ingredientId).execute().body();
    }

    public Drinks searchRandomCocktail() throws IOException {
        return cocktaildbService.searchRandomCocktail().execute().body();
    }

    public Drinks filterCocktailByIngredient(String ingredientName) throws IOException {
        return cocktaildbService.filterCocktailByIngredient(ingredientName).execute().body();
    }

    public Drinks searchCocktailByAlcoholic(String ingredientName) throws IOException {
        return cocktaildbService.filterCocktailByAlcoholic(ingredientName).execute().body();
    }

    public Drinks searchCocktailByCategory(String ingredientName) throws IOException {
        return cocktaildbService.filterCocktailByCategory(ingredientName).execute().body();
    }

    public Drinks searchCocktailByGlass(String ingredientName) throws IOException {
        return cocktaildbService.filterCocktailByGlass(ingredientName).execute().body();
    }

    public String getRandomDrinkId() throws IOException {
        return cocktaildbService.searchRandomCocktail().execute().body().getDrinks().get(0).getIdDrink();
    }

    public String getRandomDrinkName() throws IOException {
        return cocktaildbService.searchRandomCocktail().execute().body().getDrinks().get(0).getStrDrink();
    }

    public String getRandomDrinkCategory() throws IOException {
        return cocktaildbService.searchRandomCocktail().execute().body().getDrinks().get(0).getStrCategory();
    }

    public String getRandomDrinkGlass() throws IOException {
        return cocktaildbService.searchRandomCocktail().execute().body().getDrinks().get(0).getStrGlass();
    }

    private CocktaildbService setupCocktaildbService(String apiVersion) {
        OkHttpClient cocktaildbClient = new OkHttpClient.Builder().build();
        EnvConfigurationSection envConfiguration = (EnvConfigurationSection) context.getAttribute("env");
        log.info("Sending RQ to: " + envConfiguration.baseHostPostfix + "api/json/v" + apiVersion +"/1/");
        Retrofit cocktaildbRetrofit = new Retrofit.Builder()
                .baseUrl(envConfiguration.baseHostPostfix + "api/json/v" + apiVersion +"/1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(cocktaildbClient)
                .build();

        return cocktaildbRetrofit.create(CocktaildbService.class);
    }
}
