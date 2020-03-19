package com.globant.automation.cyf2020.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.pedidosYa.*;

public class PedidosYaTest {

    private WebDriver driverPedidos;

    @BeforeSuite
    public void openPedidosYa() {
        WebDriverManager.chromedriver().setup();
        driverPedidos = new ChromeDriver();
        driverPedidos.get("https://www.pedidosya.com/");
        driverPedidos.manage().window().maximize();
    }

    @Test
    public void testPedidos(){
        WorldwidePy one= new WorldwidePy(driverPedidos);
        PedidosYaUy two= one.clickUy();
        Sugerencias three= two.addInfo("Hector Suppici sedes 954","Pizza");
        String place= two.getAddress();
        AgregarAcarrito four= three.suggestion();
        String price = four.info();
        Validar five = four.goToVal();
        String place2= five.addressRight();
        String price2=five.priceRight();
        Assert.assertTrue(place2.contains(place), "Not the same place");
        Assert.assertTrue(price2.contains(price), "Different price");
        PopUpReg six = five.continues();
        String register= six.register();
        Assert.assertEquals(register, "Ingresar a mi cuenta", "Different");









    }




}
