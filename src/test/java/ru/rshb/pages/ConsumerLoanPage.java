package ru.rshb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConsumerLoanPage extends BasePage {

    @FindBy(xpath = "//button[text()='Аннуитетный']")
    private WebElement paymentTypeButton;

    @FindBy(css = ".ant-slider.slider__slider--hide .ant-slider-handle")
    private List<WebElement> sliders;

    @FindBy(css = ".ant-checkbox input")
    private List<WebElement> checkboxesButtons;

    @FindBy(css = ".ant-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(css = ".cookie-consent__submit-button")
    private WebElement acceptCookieButton;

    @FindBy(css = ".loan-calculator-result__value")
    private List<WebElement> preparatoryPayment;

    public ConsumerLoanPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPaymentTypeButtonClassAttribute() {
        return paymentTypeButton.getAttribute("class");
    }

    public ConsumerLoanPage scrollToCheckbox(int checkboxPosition) {
        new Actions(driver)
                .moveToElement(checkboxes.get(checkboxPosition))
                .build()
                .perform();
        return this;
    }

    public ConsumerLoanPage closeCookieNotification() {
        try {
            acceptCookieButton.click();
        } catch (NoSuchElementException exception) {
            System.out.println("There is no cookie notification");
        }
        return this;
    }

    public ConsumerLoanPage clickOnCheckbox(int checkboxPosition) {
        checkboxesButtons.get(checkboxPosition).click();
        return this;
    }

    public String getCheckboxClassAttribute(int checkboxPosition) {
        return checkboxes.get(checkboxPosition).getAttribute("class");
    }

    public ConsumerLoanPage changeSliderLocation(int sliderPosition) {
        int xOffset;
        if (sliderPosition == 0) {
            xOffset = 82;
            for (byte i = 0; i < 2; i++) {
                sliders.get(sliderPosition).sendKeys(Keys.ARROW_RIGHT);
            }
        } else
            xOffset = 150;
        new Actions(driver)
                .dragAndDropBy(sliders.get(sliderPosition), xOffset, 0)
                .build()
                .perform();
        return this;
    }

    public String getInfoAboutLoan() {
        String info = "";
        for (WebElement element : preparatoryPayment) {
            info += element.getText();
        }
        return info.replace("₽", "");
    }
}
