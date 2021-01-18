# AIMate
Artificial Intelligence Automation Mate. This library helps reduce maintenance time and increase test stability by creating alternative locators for the elements used in a test and using them when an element is not found. It will also increase test performance by automatically sorting the element locators so faster ones are used first.

## How to use it
Change the `@FindBy`/`@AndroidFindBy`/`@IOSXCUIFindBy` annotation of your `WebElement`/`MobileElement` to `@AIFindBy` and on the next run AIMate will generate alternative locators and start using them. You can configure which Strategies to use for element generation by modifying the `aimate.strategies` property.

## Installing
Use Maven to download the library.


## Contributing
You can contribute to the project by creating tests that use the `@AIMate` annotation.
