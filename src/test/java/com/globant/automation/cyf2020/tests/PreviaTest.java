package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.infrastructure.miprevia.MiPreviaSearchPage;
import com.globant.automation.cyf2020.infrastructure.miprevia.PreviaHomePage;
import com.globant.automation.cyf2020.infrastructure.miprevia.SecondDrinkListed;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PreviaTest {


    private WebDriver driver;


    @BeforeSuite
    public void openMiPrevia() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cyf-2020.firebaseapp.com/");

    }

    @Test
    public void previaTest() {
        PreviaHomePage mainPage = new PreviaHomePage(driver);
        String firstDrinksName = mainPage.getRandomDrink();
        String firstDrinksName2 = firstDrinksName.replaceAll("\\s", "%20");
        String tresTragos = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + firstDrinksName2;
        //Using Response i'll get the apis info?
        Response response = RestAssured.given().urlEncodingEnabled(false).get(tresTragos);
        //Here i convert the response to string
        String responseToString = response.getBody().asString();

        // I have to convert the response to  JSON

        JSONObject responseToJson = new JSONObject(responseToString);

        // Here I use the JSON to get what I want
        String drinksInfo = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
        JSONObject drinksInfoInJson = new JSONObject(drinksInfo);
        String drinksNameJson = drinksInfoInJson.get("strDrink").toString();

        //This isn't really necessary but it prints out the drinks name
        System.out.println("The Drinks name is: " + drinksNameJson);

        Assert.assertEquals(drinksNameJson.toLowerCase(), firstDrinksName.toLowerCase(), "These are different drinks");

        //               And done!!!!!!


    }

    @Test
    public void previaTest2() {
        PreviaHomePage mainPage = new PreviaHomePage(driver);
        MiPreviaSearchPage goToSearch = mainPage.goToWhatDrink();
        String ingredientSearched = goToSearch.insertIngredientAndSearch("coffee");
        SecondDrinkListed getSecondDrink = goToSearch.goToDrinkTwo();
        String getIngredients = getSecondDrink.getAllIngredients();
        String ingredientsList[] = getIngredients.split("\n");
        System.out.print("You will need:" + ingredientsList);

        String ingredients = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingredientSearched;
        //Using Response i'll get the apis info?
        Response response = RestAssured.given().get(ingredients);
        //Here i convert the response to string
        String responseToString1 = response.getBody().asString();

        // I have to convert the response to  JSON

        JSONObject responseToJson = new JSONObject(responseToString1);

        // First I need to get the second drink from the response i get from the api, this api doesn't return
        // each drink with ingredients but the names of drinks that contain the ingredient i searched for
      //  String ingredientInfo = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
        //JSONObject drinksThatHaveTheIngredientJson = new JSONObject(ingredientInfo);
       JSONArray drinksWithTheIngreJson = responseToJson.getJSONArray("drinks");
        JSONObject getThe2ndDrink = drinksWithTheIngreJson.getJSONObject(1);
        String the2ndDrink = getThe2ndDrink.getString("strDrink");
       // String getDrink2 = drinksThatHaveTheIngredientJson.getJSONObject("drinks").getJSONObject(String.valueOf(1)).getString("strDrink");

        //now through another api i get the ingredients using the name i received from the other one

        String drinksName = the2ndDrink.replaceAll("\\s", "%20");
        String theDrinkIGot = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + drinksName;
        //Using Response i'll get the apis info?
        Response response2 = RestAssured.given().urlEncodingEnabled(false).get(theDrinkIGot);
        //Here i convert the response to string
        String responseToString2 = response2.getBody().asString();

        // I have to convert the response to  JSON

        JSONObject responseToJson2 = new JSONObject(responseToString2);

        // Here I use the JSON to get what I want
        String drinksInfo = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
        JSONObject drinksInfoInJson = new JSONObject(drinksInfo);
        int i= 1;

        while(i < ingredientsList.length) {
            String getDrinksName = drinksInfoInJson.get("strIngredient"+ i).toString();
            Assert.assertTrue(ingredientsList[i-1].contains(getDrinksName), "The ingredients are not the same");
            i++;

                 }




    }


    @AfterSuite
    public  void close(){
        driver.quit();
    }
}