package ru.rshb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualsPage extends BasePage {

    @FindBy(xpath = "//a[@class='b-page-head-menu-item-nobanner link' and text()='Кредиты']")
    private WebElement allLoansElement;

    @FindBy(xpath = "//a[@class='b-page-head-menu-item' and text()='Вклады и сбережения']")
    private WebElement depositsAndSavingsElement;

    @FindBy(xpath = "//a[@class='b-sections-menu-item-text-title' and text()='Накопительный счет']")
    private WebElement savingsAccountElement;

    @FindBy(css = ".btn-standart")
    private WebElement acceptCookieButton;

    public IndividualsPage() {
        PageFactory.initElements(driver, this);
    }

    public AllLoansPage goToAllLoansPage() {
        allLoansElement.click();
        return new AllLoansPage();
    }

    public IndividualsPage clickOnDepositsAndSavings() {
        depositsAndSavingsElement.click();
        return this;
    }

    public IndividualsPage scrollToDepositsAndSavingsPage() {
        new Actions(driver)
                .moveToElement(savingsAccountElement)
                .build()
                .perform();
        return this;
    }

    public IndividualsPage closeCookieNotification() {
        acceptCookieButton.click();
        return this;
    }

    public SavingsAccountPage goToSavingsAccountPage() {
        savingsAccountElement.click();
        return new SavingsAccountPage();
    }
}
