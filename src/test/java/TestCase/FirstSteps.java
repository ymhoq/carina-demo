package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.compare.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.components.compare.LogInModal;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.RedirectedPage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FirstSteps implements IAbstractTest {

    private final String EMAIL = "email@gmail.com";
    private final String USERNAME = "user1234user";
    private final String PASSWORD = "pass1234";


    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFirstCase() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.scrollToFooterMenu();

        FooterMenu footerMenu = homePage.getFooterMenu();
        //Assert.assertTrue( footerMenu.isUIObjectPresent(), "Footer does not present");
        //footerMenu.addLinksToFooter();
        //footerMenu.openNewsPage();
        footerMenu.openNewsPage();
        //footerMenu.openLink(0);

    }


    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSecondCase() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(1), "Header menu wasn't found!");

        RedirectedPage redirectedPage = headerMenu.openInstagramButtonPage();
        Assert.assertTrue(redirectedPage.isPageOpened(), "Instagram Button Page is not opened ");

        redirectedPage = headerMenu.openEvButtonPage();
        Assert.assertTrue(redirectedPage.isPageOpened(), "EvButton Page Button Page is not opened ");

        Assert.assertTrue(redirectedPage.isPageOpened(), "YTubeButton Page Button Page is not opened ");

        redirectedPage = headerMenu.openRssButtonPage();
        Assert.assertTrue(redirectedPage.isPageOpened(), "Rss Button Page Button Page is not opened ");

        LogInModal logInModal = headerMenu.openLoginButtonPage();
        Assert.assertTrue(logInModal.isUIObjectPresent(), "Login Button Page Button Page is not opened ");

        redirectedPage = headerMenu.openMerchButtonPage();
        Assert.assertTrue(redirectedPage.isPageOpened(), "Merch Button Page Button Page is not opened ");

        SignUpPage signUpPage = headerMenu.openSignUpButtonPage();
        Assert.assertTrue(redirectedPage.isPageOpened(), "SignUP Button Page Button Page is not opened ");


    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSignUp() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        SignUpPage signUpPage = headerMenu.openSignUpButtonPage();

        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up Page Button Page is not opened ");

        signUpPage.setUserInfo(EMAIL, USERNAME, PASSWORD);
        signUpPage.clickAgreeBtns();
        signUpPage.clickSubmitBtn();

        Assert.assertTrue(signUpPage.isPageOpened(), "wasn't opened next page");

    }


    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLogin() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();

        LogInModal logInModal = headerMenu.openLoginButtonPage();
        Assert.assertTrue(logInModal.isUIObjectPresent(), "Login Button Page Button Page is not opened ");

        logInModal.typeEmailEdit(EMAIL);
        logInModal.typePasswordEdit(PASSWORD);

        LoginPage loginPage = logInModal.clickLoginBtn();

        Assert.assertTrue(loginPage.isLoginFail(), "login is failed");

    }

    @Test(dataProvider = "LoginData")
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLogin(String LID, String email, String password) {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Login Button Page Button Page is not opened ");

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        LogInModal logInModal = headerMenu.openLoginButtonPage();
        Assert.assertTrue(logInModal.isUIObjectPresent(), "Login Button Page Button Page is not opened ");

        logInModal.typeEmailEdit(email);
        logInModal.typePasswordEdit(password);

        LoginPage loginPage = logInModal.clickLoginBtn();

        Assert.assertTrue(loginPage.isLoginFail(), "login is failed");
    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFifthCase() {
        HomePage homePage = new HomePage(getDriver());
        homePage.scrollToFooterMenu();
    }


    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        homePage.openHeaderMenu();

        Assert.assertEquals(headerMenu.openNewsButton().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.NEWS).getAttribute("href"));

        Assert.assertEquals(headerMenu.openReviewsButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.REVIEWS).getAttribute("href"));

        Assert.assertEquals(headerMenu.openVideosButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.VIDEOS).getAttribute("href"));

        Assert.assertEquals(headerMenu.openFeaturedButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.FEATURED).getAttribute("href"));

        Assert.assertEquals(headerMenu.openPhoneFinderButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.PHONE_FINDER).getAttribute("href"));

        Assert.assertEquals(headerMenu.openDealsButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.DEALS).getAttribute("href"));

        Assert.assertEquals(headerMenu.openMergeButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.MERGE).getAttribute("href"));

        Assert.assertEquals(headerMenu.openCoverageButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.COVERAGE).getAttribute("href"));

        Assert.assertEquals(headerMenu.openContactUsButtonPage().getCurrentUrl(),
                headerMenu.getHeaderMenuElement(HeaderMenuElements.CONTACT_US).getAttribute("href"));

    }


    @DataProvider(parallel = true, name = "LoginData")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"LID: user1", "email1@gmail.com", "pass1234"},
                {"LID: user2", "email2@gmail.com", "pass123412123"},
                {"LID: user3", "email3@gmail.com", "pass124343434"}};
    }

}
