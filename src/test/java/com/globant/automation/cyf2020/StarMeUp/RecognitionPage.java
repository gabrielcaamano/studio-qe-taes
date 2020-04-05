package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class RecognitionPage extends BasePage {

	public RecognitionPage(WebDriver driver, boolean popUpRecognition) {
		super(driver);
		popUpRecognitionDisplayed = popUpRecognition;
	}

	@FindBy(xpath = "//div[@class='tab-panel__item tab-panel__item--active']")
	WebElement recivedBtn;

	@FindBy(xpath = "//div[@class='tab-panel__item']")
	WebElement sentBtn;

	private boolean popUpRecognitionDisplayed;
	
	public boolean checkRecognitionSent(String whoRecibed, String value) {

		boolean founded;
		String whoRecibedElementText;
		String valueElementText;
		WebElement whoRecibedElement;
		WebElement valueElement;
		String valueToUpperCase;
		valueToUpperCase = value.toUpperCase();
		
		if ( popUpRecognitionDisplayed ) {
			WebElement popUpRecognitionElement = getElement(By.xpath(
					"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"));
			popUpRecognitionElement.click();
		}
		sentBtn.click();
		whoRecibedElement = getElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"));
		valueElement = getElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]"));

		whoRecibedElementText = getText(whoRecibedElement);
		valueElementText = getText(valueElement);
		valueElementText = valueElementText.toUpperCase();
		founded = ((whoRecibedElementText.contains(whoRecibed)) && (valueToUpperCase.contentEquals(valueElementText)));
		return founded;
	}

	public boolean checkRecognitionRecived(String whoSent, String value) {

		boolean founded;
		WebElement whoSentElement;
		WebElement valueElement;
		String whoSentElementText;
		String valueElementText;
		
		recivedBtn.click();
		whoSentElement = getElement(By.cssSelector(
				"div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__main-content.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-6.suite-column-tablet-size-12 div.main-panel div.recognition div.ui-components.suite-segment div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(1) div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));
		valueElement = getElement(By.cssSelector(
				"div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__main-content.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-6.suite-column-tablet-size-12 div.main-panel div.recognition div.ui-components.suite-segment div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(1) div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(1) > div.feed-item__badge-description"));
		whoSentElementText = getText(whoSentElement);
		valueElementText = getText(valueElement);
		String valueToUpperCase;
		valueToUpperCase = value.toUpperCase();
		
		founded = (whoSentElementText.contains(whoSent) && valueElementText.contentEquals(valueToUpperCase));
		
		return founded;
	}
}
