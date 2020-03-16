package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class GoogleSearchPage extends BasePage {

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy ( how= How.CLASS_NAME, using ="st")
	private WebElement wordGSearched;
	
	//here it prints what i searched for and the results i got, they should be the same
	public void whatIlookedFor() {
		String googleSearchResult = getText(wordGSearched);
		System.out.println(googleSearchResult);
	}
}
