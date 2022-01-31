package ru.rshb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsAccountPage extends BasePage {

    @FindBy(css = ".b-btn")
    private WebElement profitabilityCalculation;


    public SavingsAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public OnlineCalculatorPage goToOnlineCalculatorPage() {
        profitabilityCalculation.click();
        return new OnlineCalculatorPage();
    }
}
