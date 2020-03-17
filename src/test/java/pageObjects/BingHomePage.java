package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class BingHomePage extends BasePage {

	public BingHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name = "q")
	private WebElement searchWord;
	
	@FindBy (xpath = "//div[@class='sb_add sb_adTA']//cite)[1]")
	private WebElement btnSearch;
	
	public BingSearchPage bingSearch (String bWord) {
	 type(searchWord,bWord);
		click(btnSearch);
		return getNextPage(BingSearchPage.class)
	}
	
}
