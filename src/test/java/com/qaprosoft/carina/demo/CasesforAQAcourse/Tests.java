package com.qaprosoft.carina.demo.CasesforAQAcourse;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import com.qaprosoft.carina.demo.regression.dataprovider.ConfProperties;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import swagLabs.ProductPage;

import java.util.concurrent.TimeUnit;

public class Tests implements IAbstractTest {

    public static LoginPage loginPage;
    public static ProductPage productPage;
    public static WebDriver driver;
    
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage.inputLogin("dsddsd");
    }

    //Verify right position all elements on login page
    //
    //
    //
    //Verify product item card
    //
    @Test()
    public void testModelSpecs() {
        // Open sauce home page and verify page is opened
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

           //nputLogin("standard_user");
       loginPage.inputPasswd("secret_sauce");
       // loginPage.clickLoginBtn();
        //Closing advertising if it's displayed
        //loginPage.getWeValuePrivacyAd().closeAdIfPresent();

        // Select phone brand
       // loginPage = new LoginPage(getDriver());
        //BrandModelsPage productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        //zproductInfoPage = productsPage.selectModel("Galaxy A52 5G");
        // Verify phone specifications
       // SoftAssert softAssert = new SoftAssert();
       //softAssert.assertEquals(productInfoPagereadDisplay(), "6.5\"", "Invalid display info!");
       // softAssert.assertEquals(productInfoPage.readCamera(), "64MP", "Invalid camera info!");
       // softAssert.assertEquals(productInfoPage.readRam(), "6/8GB RAM", "Invalid ram info!");
       // softAssert.assertEquals(productInfoPage.readBattery(), "4500mAh", "Invalid battery info!");
       // softAssert.assertAll();
    }

    //
    //
    //Verify drop down filter menu
    //
    //
    //
    //Verify drop down filter menu
    //
    //
    //
    //Verify all products sorted by alphabetical
    //
    //
    //


}
