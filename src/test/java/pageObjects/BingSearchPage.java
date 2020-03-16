package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class BingSearchPage extends BasePage {

	public BingSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy ( how= How.CLASS_NAME, using ="b_attribution")
	private WebElement wordBSearched;
	
	//here it prints what i searched for and the results i got, they should be the same
	public String bingSearchResult() {
		return wordBSearched.getText();
	
	}
	
}

