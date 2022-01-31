package ru.rshb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.rshb.utils.ConfProperties;

import java.util.HashMap;
import java.util.Map;

public class OnlineCalculatorPage extends BasePage {

    @FindBy(xpath = "//tr[@id='deposit_11790']")
    private WebElement demandElement;

    @FindBy(xpath = "//tr[@id='deposit_451879']/td[5]")
    private WebElement myBenefit;

    @FindBy(xpath = "//tr[@id='deposit_409523']/td[5]")
    private WebElement myPiggyBank;

    @FindBy(xpath = "//tr[@id='deposit_330854']/td[5]")
    private WebElement myAccount;

    @FindBy(xpath = "//tr[@id='deposit_451946']/td[5]")
    private WebElement ultra;

    @FindBy(xpath = "//tr[@id='deposit_451924']/td[5]")
    private WebElement premium;

    @FindBy(xpath = "//tr[@id='deposit_11790']/td[5]")
    private WebElement beforeDemand;

    public OnlineCalculatorPage() {
        PageFactory.initElements(driver, this);
    }

    public void scrollToTableElement() {
        new Actions(driver)
                .moveToElement(demandElement)
                .build()
                .perform();
    }

    public String getMyBenefitValue() {
        return myBenefit.getText();
    }

    public String getPiggyBankValue() {
        return myPiggyBank.getText();
    }

    public String getMyAccountValue() {
        return myAccount.getText();
    }

    public String getUltraValue() {
        return ultra.getText();
    }

    public String getPremiumValue() {
        return premium.getText();
    }

    public String getBeforeDemandValue() {
        return beforeDemand.getText();
    }

    public Map<String, String> getValuesFromTable() {
        return new HashMap<>() {{
            put(ConfProperties.getProperty("myBenefit"), getMyBenefitValue());
            put(ConfProperties.getProperty("myPiggyBank"), getPiggyBankValue());
            put(ConfProperties.getProperty("myAccount"), getMyAccountValue());
            put(ConfProperties.getProperty("ultra"), getUltraValue());
            put(ConfProperties.getProperty("premium"), getPremiumValue());
            put(ConfProperties.getProperty("beforeDemand"), getBeforeDemandValue());
        }};
    }
}
