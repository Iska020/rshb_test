package ru.rshb;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rshb.pages.BaseTest;
import ru.rshb.pages.ConsumerLoanPage;
import ru.rshb.pages.MainPage;
import ru.rshb.pages.OnlineCalculatorPage;
import ru.rshb.utils.ConfProperties;

import java.util.HashMap;
import java.util.Map;

public class LoansDepositsTest extends BaseTest {

    @Test
    public void checkLoanWithOneCheckbox() {
        new MainPage()
                .goToIndividualsPage()
                .goToAllLoansPage()
                .scrollToLoanElement()
                .goToConsumerLoanPage();
        ConsumerLoanPage consumerLoanPage = new ConsumerLoanPage();
        String paymentTypeClassAttribute = consumerLoanPage.getPaymentTypeButtonClassAttribute();
        Assert.assertTrue(paymentTypeClassAttribute
                .contains(ConfProperties.getProperty("paymentTypeClassAttribute")));
        consumerLoanPage
                .scrollToCheckbox(2)
                .closeCookieNotification()
                .changeSliderLocation(0)
                .changeSliderLocation(1);
        String firstCheckboxClassAttribute = consumerLoanPage
                .clickOnCheckbox(0)
                .getCheckboxClassAttribute(0);
        Assert.assertTrue(firstCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        String secondCheckboxClassAttribute = consumerLoanPage.getCheckboxClassAttribute(1);
        Assert.assertFalse(secondCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        String thirdCheckboxClassAttribute = consumerLoanPage
                .clickOnCheckbox(2)
                .getCheckboxClassAttribute(2);
        Assert.assertFalse(thirdCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        Assert.assertEquals(consumerLoanPage.getInfoAboutLoan(), ConfProperties.getProperty("infoAboutFirstLoan"));
    }

    @Test
    public void checkLoanWithTwoCheckbox() {
        new MainPage()
                .goToIndividualsPage()
                .goToAllLoansPage()
                .scrollToLoanElement()
                .goToConsumerLoanPage();
        ConsumerLoanPage consumerLoanPage = new ConsumerLoanPage();
        String paymentTypeClassAttribute = consumerLoanPage.getPaymentTypeButtonClassAttribute();
        Assert.assertTrue(paymentTypeClassAttribute
                .contains(ConfProperties.getProperty("paymentTypeClassAttribute")));
        consumerLoanPage
                .scrollToCheckbox(2)
                .closeCookieNotification()
                .changeSliderLocation(0)
                .changeSliderLocation(1);
        String firstCheckboxClassAttribute = consumerLoanPage
                .clickOnCheckbox(0)
                .getCheckboxClassAttribute(0);
        Assert.assertTrue(firstCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        String secondCheckboxClassAttribute = consumerLoanPage.getCheckboxClassAttribute(1);
        Assert.assertFalse(secondCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        String thirdCheckboxClassAttribute = consumerLoanPage
                .getCheckboxClassAttribute(2);
        Assert.assertTrue(thirdCheckboxClassAttribute
                .contains(ConfProperties.getProperty("checkboxIsClicked")));
        Assert.assertEquals(consumerLoanPage.getInfoAboutLoan(), ConfProperties.getProperty("infoAboutSecondLoan"));
    }

    @Test
    public void checkTableDepositsAndSavings() {
        new MainPage()
                .goToIndividualsPage()
                .clickOnDepositsAndSavings()
                .scrollToDepositsAndSavingsPage()
                .closeCookieNotification()
                .goToSavingsAccountPage()
                .goToOnlineCalculatorPage()
                .scrollToTableElement();
        Map<String, String> expectedValuesFromTable = new HashMap<>();
        expectedValuesFromTable.put(ConfProperties.getProperty("myBenefit"), "5.5%");
        expectedValuesFromTable.put(ConfProperties.getProperty("myPiggyBank"), "5%");
        expectedValuesFromTable.put(ConfProperties.getProperty("myAccount"), "4%");
        expectedValuesFromTable.put(ConfProperties.getProperty("ultra"), "0.01%");
        expectedValuesFromTable.put(ConfProperties.getProperty("premium"), "0.01%");
        expectedValuesFromTable.put(ConfProperties.getProperty("beforeDemand"), "0.01%");
        Map<String, String> actualValesFromTable = new OnlineCalculatorPage().getValuesFromTable();
        Assert.assertEquals(actualValesFromTable, expectedValuesFromTable);
    }
}
