package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    RegisterPage  registerPage;
    HomePage homePage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();

}
@Test(groups= {"sanity" ,"smoke" , "regression" })
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

    //1.1 Click on Register Link
        homePage.clickOnRegisterLink();

    //1.2 Verify "Register" text
    String expectedMessage = "Register";
    String actualMessage = registerPage.getRegisterText();
    Assert.assertEquals(expectedMessage, actualMessage, "Message is not Display");
}
@Test(groups= {"smoke" , "regression" })
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //2.1 Click on Register Link
        homePage.clickOnRegisterLink();

        //2.2Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //2.3Verify the error message "First name is required."
    String expectedMessage = "First name is required";
    String actualMessage = registerPage.getFirstNameRequiredText();
    Assert.assertEquals(expectedMessage, actualMessage, "Message is not Display");

        //2.4Verify the error message "Last name is required."
    String expectedMessage1 = "Last name is required";
    String actualMessage1 = registerPage.getLastNameRequiredText();
    Assert.assertEquals(expectedMessage1, actualMessage1, "Message is not Display");

        //2.5Verify the error message "Email is required."
    String expectedMessage2 = "Email is required";
    String actualMessage2 = registerPage.getEmailIdText();
    Assert.assertEquals(expectedMessage2, actualMessage2, "Message is not Display");


        //2.6Verify the error message "Password is required."
    String expectedMessage3 = "Password is required.";
    String actualMessage3 = registerPage.getPassWordText();
    Assert.assertEquals(expectedMessage3, actualMessage3, "Message is not Display");

        //2.7Verify the error message "Password is required."
    String expectedMessage4 = "Password is required.";
    String actualMessage4 = registerPage.getConfirmPassWordText();
    Assert.assertEquals(expectedMessage4, actualMessage4, "Message is not Display");
    }
    @Test(groups= {"regression" })
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //3.1Click on Register Link
        homePage.clickOnRegisterLink();
        //3.2 Select gender "Female"
        registerPage.clickOnFemaleRadioButton();

        //3.3 Enter firstname
        registerPage.sendTextToFirstNameField("Amruta");
        //3.4 Enter lastname
        registerPage.sendTextToFirstNameField1("Goswami");
        //3.5Select day
        registerPage.selectDayFromDateOfBirth("16");
        //3.6Select month
        registerPage.selectMonthFromDateOfBirth("march");
        //3.7Select year
        registerPage.selectYearFromDateOfBirth("1983");
        //3.8Enter email  password Click on "REGISTER" button
        //registerPage. EmailField("Max33@gmail.com");
        //3.9Enter password
       // registerPage.PasswordField("Maximum123");
        //3.10Enter Confirm Password
        // registerPage.PasswordField("Maximum123")
        //3.11Click on "REGISTER" button
        registerPage.registerToApplication("Amruta33@gmail.com","Amruta123","Amruta123");
        //3.12Verify message "Your registration completed"
        String expectedErrorMessage4 = "Your registration completed";
        String actualErrorMessage4 = registerPage.getRegistrationCompletedText();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");
    }
    }

