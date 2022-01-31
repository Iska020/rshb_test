package ru.rshb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.rshb.utils.ConfProperties;

public class MainPage extends BasePage {

    @FindBy(css = "a.header__section-link.header__section-link_active")
    private WebElement individualsElement;

    public MainPage() {
        driver.get(ConfProperties.getProperty("mainPageURL"));
        PageFactory.initElements(driver, this);
    }

    public IndividualsPage goToIndividualsPage() {
        individualsElement.click();
        return new IndividualsPage();
    }
}
