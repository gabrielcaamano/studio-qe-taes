# AIMate
Artificial Intelligence Automation Mate is a library tha helps reduce maintenance time and increase test stability. It does so by creating alternative locators for the elements used in a test and using them when an element is not found. It will also increase test performance by automatically sorting the element locators so faster ones are used first.

## How to use it
1. On your page class constructor (usually, the `BasePage` or `BaseScreen`), use the following way of initializing the elements: `PageFactory.initElements(new AIElementLocatorFactory(pDriver, pDriver), this);`, in short, don´t forget using `AIElementLocatorFactory`.
2. Change the `@FindBy`/`@AndroidFindBy`/`@IOSXCUIFindBy` annotation of your `WebElement`/`MobileElement` to `@AIFindBy` and on the next run AIMate will generate alternative locators and start using them. You can configure which Strategies to use for element generation by modifying the `aimate.strategies` property.

## Installing
Clone this project and import it as a Maven project.

## Contributing
You can contribute to the project by creating tests having locators that use the `@AIFindBy` annotation. 

### Guidelines
- Contributions should be developed by using the framework provided on this repository (Java/TestNG/Selenium+Appium).
- Each contributor will have to create a branch (based on master) and only push to that branch. Branch naming should be `tests/<username>`.
- Contributed tests should follow [PageObjects pattern](https://martinfowler.com/bliki/PageObject.html).
- Merging to main branch is not allowed unless it is done by pull request and approved by one of the repository´s maintainer.

### Test/contribution framework explanation
Contributor should only work on `src/test/java` source folder. Use the packages created in `com.globant.aimate.test` to add the new classes depending on if they are model or tests, and if they are web or mobile based.

#### Web based tests configuration
The provided framework is Selenium-Webdriver-based.

#### Mobile based tests configuration
The provided framework is Appium-based. First, if you want to execute your tests on an emulator you will have to download [Android Studio](https://developer.android.com/studio) and create an Android emulator using the AVD Manager (Start Screen > Configure > AVD Manager): [read this guide if you don´t know how to create the emulator](https://developer.android.com/studio/run/managing-avds). Download [Appium Desktop](http://appium.io/) and start local server. Once you have Appium Server and emulator running you should be able to start testing.

#### Writing tests
The contributor will find utility classes so tests can be created more easily by extending tests and pages from them. Those classes are `AIMobileTest`, `AITestPage`, and `AIMobileTestPage`.
