package ru.rshb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AllLoansPage extends BasePage {

    @FindBy(xpath = "//a[@class='linkip' and text()='Потребительский кредит на благоустройство для жителей села']")
    private WebElement loanForVillagers;

    @FindBy(xpath = "//a[@class='linkip' and text()='Потребительский кредит без обеспечения']")
    private WebElement unsecuredLoan;

    public AllLoansPage() {
        PageFactory.initElements(driver, this);
    }

    public AllLoansPage scrollToLoanElement() {
        new Actions(driver)
                .moveToElement(loanForVillagers)
                .build()
                .perform();
        return this;
    }

    public void goToConsumerLoanPage() {
        unsecuredLoan.click();
    }
}
