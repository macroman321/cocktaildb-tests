package com.cocktaildb.dataproviders;

import com.cocktaildb.CocktaidbApiHelper;
import com.cocktaildb.entities.Drink;
import com.cocktaildb.entities.Drinks;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CocktailDataProvider {

    private CocktaidbApiHelper cocktaidbApiHelper;

    @DataProvider(name = "cocktailList")
    public static Iterator<Object[]> cocktailList(ITestContext iTestContext) throws IOException {

        List<Object[]> testParameterSet = new LinkedList<>();
        CocktaidbApiHelper cocktaidbApiHelper = new CocktaidbApiHelper(iTestContext);

        Drinks drinks = cocktaidbApiHelper.searchCocktailsName("");

        for (Drink drink : drinks.getDrinks()){
            if(drink!=null){
                testParameterSet.add(new Object[]{drink});
            }
        }

        return testParameterSet.iterator();
    }

}
