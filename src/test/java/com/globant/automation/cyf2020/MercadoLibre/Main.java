package com.globant.automation.cyf2020.MercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		MLHome Mlhome = new MLHome(driver);
		MLOfertaSemanal1 ofertaSemanalPage = Mlhome.GoOfertasSemanales();
		String resultadoOfertaSemanal = ofertaSemanalPage.datosGetTextOfertaSemanal();
		MLProducto productoPage = ofertaSemanalPage.GoProducto();
		String resultadoProductoPage = productoPage.getDatosTextProductoPage();
		
		System.out.println("");
		
		if (resultadoOfertaSemanal == resultadoProductoPage ) {
			
			System.out.println("Los resultados de la página del primer producto de Oferta Semanal y de la pagina del Producto coinciden en nombre, moneda, precio y descuento");
			
		} else {
			
			System.out.println("Los resuñtados de la página del primer producto de Oferta Semanal y de la página del Producto no coinciden en nombre, moneda, precio o descuento");		}
		
	}
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);

	}

}
