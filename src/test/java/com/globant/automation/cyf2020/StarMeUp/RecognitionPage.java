package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.tests.LoginStarMeUpTest.GLOBANTVALUES;

public class RecognitionPage extends StarMeUp {

	public RecognitionPage(WebDriver driver, boolean popUpRecognition) {
		super(driver);
		popUpRecognitionDisplayed = popUpRecognition;
	}

	@FindBy(xpath = "//div[@class='tab-panel__item tab-panel__item--active']")
	private WebElement recivedBtn;

	@FindBy(xpath = "//div[@class='tab-panel__item']")
	private WebElement sentBtn;

	private boolean popUpRecognitionDisplayed;

	public boolean checkRecognitionSent(String whoRecibed, GLOBANTVALUES value) {

		boolean founded;
		String whoRecibedElementText;
		String valueElementText;
		WebElement whoRecibedElement;
		WebElement valueElement;
		String valueStr;
		valueStr = value.getValue().toUpperCase();

		if ( isElementPresent(By.xpath("//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]" ))) {
			getElement(By.xpath("//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")).click();
		}
		sentBtn.click();
		whoRecibedElement = getElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"));
		valueElement = getElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]"));

		whoRecibedElementText = getText(whoRecibedElement);
		valueElementText = getText(valueElement);
		valueElementText = valueElementText.toUpperCase();
		founded = ((whoRecibedElementText.contains(whoRecibed)) && (valueStr.contentEquals(valueElementText)));
		return founded;
	}

	public boolean checkRecognitionRecived(String whoSent, GLOBANTVALUES value) {

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
		String valueStr;
		valueStr = value.getValue().toUpperCase();

		founded = (whoSentElementText.contains(whoSent) && valueElementText.contentEquals(valueStr));

		return founded;
	}

}
