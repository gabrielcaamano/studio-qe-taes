package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.PedidosYa.ElegirSugerencia;
import com.globant.automation.cyf2020.PedidosYa.HomePagePedidosYa;
import com.globant.automation.cyf2020.PedidosYa.SugerenciaPage;
import com.globant.automation.cyf2020.PedidosYa.UruguayPedidosYa;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PedidosYaTest {

	private WebDriver driver;

	@BeforeClass
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.pedidosya.com");
		driver.manage().window().maximize();
	}

	@Test
	public void ingresarLocalidad() {
		
		HomePagePedidosYa HomePedidosYa = new HomePagePedidosYa(driver);
		UruguayPedidosYa HomeUruguay = HomePedidosYa.goUruguay();
		ElegirSugerencia elegirSugerenciaPage = HomeUruguay.entrega("Paraguay 2141", "Hamburguesa");
		SugerenciaPage sugerenciaPage = elegirSugerenciaPage.GoSugerenciaComida();
		sugerenciaPage.AgregarPedido();
	}

}