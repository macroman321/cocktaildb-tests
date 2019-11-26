package com.cocktaildb;

import com.cocktaildb.entities.Drink;
import com.cocktaildb.entities.Drinks;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Log4j2
public class CocktaildbTests {

    private CocktaidbApiHelper cocktaidbApiHelper;

    @BeforeClass
    public void initEnv(ITestContext iTestContext){

        cocktaidbApiHelper = new CocktaidbApiHelper(iTestContext);

    }

    @Test(
            description = ("Search cocktail by name"),
            groups = {"search", "smoke"}
    )
    public void searchDrinkByNameTest() throws IOException {
        String drinkName = "margarita";
        Drinks drinks = cocktaidbApiHelper.searchCocktailsName(drinkName);
        Assert.assertNotNull(drinks,"No drinks named " + drinkName);
    }

    @Test(description = "Search cocktail by id test")
    public void searchDrinkById() throws IOException {
        String id = cocktaidbApiHelper.getRandomDrinkId();
        Drinks drinks = cocktaidbApiHelper.searchCocktailsId(id);
        Assert.assertNotNull(drinks, "Cocktail with id: " + id + " does not exist");

    }

    //Lets imagine that there is a requirement that all cocktails must have german instructions
    @Test(
            description = ("Check cocktail instructions for german instructions"),
            groups = {"localization", "regression"}
    )
    public void checkGermanInstructionsTest() throws IOException {
        Drinks drinks = cocktaidbApiHelper.searchCocktailsName("");
        SoftAssert softAssert = new SoftAssert();
        for(Drink drink: drinks.getDrinks()){
            softAssert.assertNotNull(drink.getStrInstructionsDE(),drink.getStrDrink() + " does not have german instructions");
        }
        softAssert.assertAll();
    }

    //Same thing as above but with data provider
    @Test(
            description = ("Check cocktail instructions for german instructions but with data provider"),
            groups = {"localization", "regression"},
            dataProvider = "cocktailList",
            dataProviderClass = com.cocktaildb.dataproviders.CocktailDataProvider.class
    )
    public void checkGermanInstructionsTestDP(Drink drink) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(drink.getStrInstructionsDE(),drink.getStrDrink() + " does not have german instructions");
        softAssert.assertAll();
    }

}
