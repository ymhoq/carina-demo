package com.qaprosoft.carina.demo.CasesforAQAcourse;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.swaglabs.DropDownMenu;
import com.qaprosoft.carina.demo.gui.pages.swaglabs.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.swaglabs.ProductCard;
import com.qaprosoft.carina.demo.gui.pages.swaglabs.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.stream.Collectors;


public class Tests implements IAbstractTest {

    public LoginPage loginPage;
    public ProductPage productPage;
    public WebDriver driver;


    @Test()
    public void testLogin() {
        // Open sauce home page and verify page is opened
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        loginPage.inputLogin("standard_user");
        loginPage.inputPasswd("secret_sauce");
        loginPage.clickLoginBtn();

        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.isPageOpened(1), "Login is unsuccsessfull");
    }

    //Verify right position all elements on login page
    //
    //
    //
    //Verify product item card
    //
    @Test()
    public void testProductCardIsEmpty() {
        // Open sauce home page and verify page is opened

        testLogin();

        ProductPage productPage = new ProductPage(getDriver());

        productPage.productItem();

        SoftAssert softAssert = new SoftAssert();

        ProductCard productCard = new ProductCard(getDriver());



        boolean notEmptyProductCard = true;
        if (!productCard.isPresentCardImage() && productCard.readProductName().isEmpty() && productCard.readProductDescription().isEmpty() && productCard.readPrice().isEmpty())
            notEmptyProductCard = false;
        softAssert.assertTrue(notEmptyProductCard, "ProdactCard is empty");

        softAssert.assertAll();
    }

    //
    //
    //Verify drop down filter menu
    //
    //
    @Test()
    public void testDropDownMenu() {

        testLogin();

        SoftAssert softAssert = new SoftAssert();
        DropDownMenu ddMenu = new DropDownMenu(getDriver());

        ddMenu.isPageOpened();

        softAssert.assertFalse(ddMenu.isDropMenuHasDefaultCase(), "Drop menu has defailt filter case");

        ddMenu.dropMenuClick();

        softAssert.assertTrue(ddMenu.verifyMenu(), "Filter Menu  is not verified");

        ddMenu.dropMenuClick2();
        softAssert.assertTrue(ddMenu.verifyMenu(), "Filter Menu  is not verified");

        ddMenu.dropMenuClick3();
        softAssert.assertTrue(ddMenu.verifyMenu(), "Filter Menu  is not verified");

        ddMenu.dropMenuClick4();
        softAssert.assertTrue(ddMenu.verifyMenu(), "Filter Menu  is not verified");



        softAssert.assertAll();
    }


    @Test()
    public void testProductsForSortByLabel() {

        testLogin();

        SoftAssert softAssert = new SoftAssert();

        ProductPage pPage = new ProductPage(getDriver());
        pPage.assertPageOpened();

        DropDownMenu ddMenu = new DropDownMenu(getDriver());
        ddMenu.isPageOpened();

        ddMenu.dropMenuClick1();  // A to Z

        softAssert.assertTrue(pPage.readProductsByClassName("" +
                "inventory_item_name").stream().sorted().collect(Collectors.toUnmodifiableList()).equals(pPage.readProductsByClassName("" +
                "inventory_item_name")), "A to Z is work incorrectly");

        ddMenu.dropMenuClick2(); // Z to A
        softAssert.assertTrue(pPage.reverseList(pPage.readProductsByClassName("" +
                "inventory_item_name")).stream().sorted().collect(Collectors.toUnmodifiableList()).equals(pPage.readProductsByClassName("" +
                "inventory_item_name").stream().collect(Collectors.toUnmodifiableList())), " Z to A is work incorrectly");

        softAssert.assertAll();
    }


    @Test()
    public void testProductsForSortByPrice() {

    testLogin();

        SoftAssert softAssert = new SoftAssert();

        ProductPage pPage = new ProductPage(getDriver());
        pPage.assertPageOpened();

        DropDownMenu ddMenu = new DropDownMenu(getDriver());
        ddMenu.isPageOpened();
        ddMenu.dropMenuClick3();  // low to hight

        softAssert.assertTrue(pPage.readAndSortByNumberProductsByClassName("" +
                "inventory_item_price").equals(pPage.readProductsByClassName("" +
                "inventory_item_price")), "low to hight is work incorrectly");

        ddMenu.dropMenuClick4(); // hight to low
        softAssert.assertTrue(pPage.reverseList(pPage.readAndSortByNumberProductsByClassName("" +
                "inventory_item_price")).equals(pPage.readProductsByClassName("" +
                "inventory_item_price")), " hight to low is work incorrectly");
        softAssert.assertAll();
    }
}
