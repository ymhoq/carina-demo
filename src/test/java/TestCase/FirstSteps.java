package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.SwitchPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.compare.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.components.compare.LogInModal;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.Set;

public class FirstSteps implements IAbstractTest {

    private final String EMAIL = "emaidsadl1@gmail.com";
    private final String USERNAME = "user11234user";
    private final String PASSWORD = "pass11234";




    @Test()
    @MethodOwner(owner = "Andrii SA")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSignUp() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        SignUpPage signUpPage = headerMenu.openSignUpButtonPage();
        signUpPage.scrollToPasswordField();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up Page Button Page is not opened ");

        signUpPage.setUserInfo(EMAIL, USERNAME, PASSWORD);

        signUpPage.clickSubmitBtn();

        Assert.assertTrue(signUpPage.isSucsessfullRegistration(), "registration is fail: ");


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
    public void testFooter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.scrollToFooterMenus();
        FooterMenu footerMenu = homePage.getFooterMenu();

        Assert.assertTrue(footerMenu.isUIObjectPresent(),
                "footer menu is not present");

        InstagramPage instagramPage = footerMenu.openInstagtamPage();
        SwitchPage.openPageByIndex(getDriver(), 1);
        Assert.assertEquals(instagramPage.getCurrentUrl(),
                "https://www.instagram.com/gsmarenateam/",
                "instagram not opened");

        SwitchPage.closeWindow(getDriver());
        SwitchPage.openPageByIndex(getDriver(), 0);


        TwitterPage twitterPage = footerMenu.openTwiterPage();
        SwitchPage.openPageByIndex(getDriver(), 1);


        Assert.assertEquals(twitterPage.getCurrentUrl(),
                "https://twitter.com/gsmarena_com",
                "twitter not opened");
        SwitchPage.closeWindow(getDriver());
        SwitchPage.openPageByIndex(getDriver(), 0);

        FaceBookPage faceBookPage = footerMenu.openFBPage();
        SwitchPage.openPageByIndex(getDriver(), 1);


        Assert.assertEquals(faceBookPage.getCurrentUrl(),
                "https://www.facebook.com/people/GSMArenacom/100066846038410/",
                "facebook not opened");

        SwitchPage.closeWindow(getDriver());
        SwitchPage.openPageByIndex(getDriver(), 0);

        YouTubePage youTubePage = (YouTubePage) footerMenu.openYTPage();
        SwitchPage.openPageByIndex(getDriver(), 1);


        Assert.assertEquals(youTubePage.getCurrentUrl(),
                "https://www.youtube.com/channel/UCbLq9tsbo8peV22VxbDAfXA?sub_confirmation=1",
                "youtube not opened");


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
