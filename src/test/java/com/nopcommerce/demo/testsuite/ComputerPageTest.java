package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage ;


    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups= {"sanity" ,"smoke" , "regression" })
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){

        //1.1 Click on Computer tab
        computerPage.clickOnComputerTab();

        //1.2 Verify "Computer" text
        String expectedErrorMessage4 = "Computer";
        String actualErrorMessage4 = computerPage.getComputerText();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");

    }
    @Test(groups= {"smoke" , "regression" })
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //2.1 Click on Computer tab
        computerPage.clickOnComputerTab();
        //2.2 Click on Desktops link
        desktopsPage.clickOnDesktop();
        //2.3 Verify "Desktops" text
        String expectedErrorMessage4 = "Desktops";
        String actualErrorMessage4 = desktopsPage.getDesktopText();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");
    }
    @Test(groups= {"regression" })
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        //3.1Click on Computer tab
        computerPage.clickOnComputerTab();
        //3.3Click on Desktops link
        desktopsPage.clickOnDesktop();
        //3.4Click on product name "Build your own computer"
        buildYourOwnComputerPage.clickOnBuildYourOwnComputer();
        //3.5Select processor "processor"
        buildYourOwnComputerPage.selectProcessor("Processor");
        //3.6Select RAM "ram"
        buildYourOwnComputerPage.selectRam("Ram");
        //3.7Select HDD "hdd"
        buildYourOwnComputerPage.clickOnHdd();
        //3.8Select OS "os"
        buildYourOwnComputerPage.clickOnOs();
        //3.9Select Software "software"
        buildYourOwnComputerPage.clickOnSoftware();
        //3.10Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        //3.11Verify message "The product has been added to your shopping cart"
        String expectedErrorMessage4 = "The product has been added to your shopping cart";
        String actualErrorMessage4 = buildYourOwnComputerPage.getShoppingCartText();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");
    }

}
