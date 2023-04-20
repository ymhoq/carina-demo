package TestCase;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.SwitchPage;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.RedirectedPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ModelTest implements IAbstractTest {


    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void showHeaderLinks() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.openHeaderMenu();

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.showTextInLinks();

    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void hoverHeaderLinks() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.openHeaderMenu();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        //headerMenu.hoverOnLink(getDriver());
        //headerMenu.I_hover_over_menu_item();

        //Set system properties for geckodriver This is required since Selenium 3.0

        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        getDriver().manage().window().maximize();

        //Adding wait
        getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(getDriver());
        //Retrieve WebElemnt 'slider' to perform mouse hover
        WebElement slider = getDriver().findElement(By.xpath("/html/body/header/div/ul/li[2]/a"));
        //Move mouse to x offset 50 i.e. in horizontal direction
        headerMenu.getHeaderItemLinks().stream().forEach(x -> {

            actions.moveToElement(x.headerLink.getElement());
            actions.perform();
            System.out.println("Button " +
                    x.headerLink.getElement().getAttribute("textContent") +
                    "  "
                    + x.headerLink.getElement().getAttribute("href"));
        });

        //actions.moveToElement(slider,50,0).perform();
        //slider.click();
        System.out.println("Moved slider in horizontal directions");

        // Close the main window
        getDriver().close();
    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void showHeaderLinksLambda() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.openHeaderMenu();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        headerMenu.getHeaderItemLinks().stream().forEach(x -> {
            headerMenu.toLogger("Button " +
                    x.headerLink.getElement().getAttribute("textContent") +
                    "  "
                    + x.headerLink.getElement().getAttribute("href"));
        });

    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void showHeaderLinksLambdaToDataProviderOut() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.openHeaderMenu();

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        AtomicInteger i = new AtomicInteger();
        headerMenu.getHeaderItemLinks().stream().forEach(x -> {
            System.out.println("{ \"ButtonId: " + i.getAndIncrement() + "\"  , \"" +
                    x.headerLink.getElement().getAttribute("textContent") +
                    "\"  , \""
                    + x.headerLink.getElement().getAttribute("href") + "\"},");
        });

    }


    @Test(dataProvider = "headerUrls")
    @MethodOwner(owner = "Andrii SA")
    public void testHeaderLinks(String button, String buttonId, String contextInfo, String Url) {


        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.openHeaderMenu();

        HeaderMenu headerMenu = homePage.getHeaderMenu();

        RedirectedPage redirectedPage = (RedirectedPage) headerMenu.getHeaderItemLinks().get(Integer.parseInt(buttonId)).openInNewTab();

        SwitchPage.openPageByIndex(getDriver(), 1);

        Assert.assertEquals(redirectedPage.getCurrentUrl(10),
                Url,
                button + " " + buttonId + " not opened");

    }

    @DataProvider(parallel = false, name = "headerUrls")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"ButtonId:" , "0", "Home", "https://www.gsmarena.com/"},
                {"ButtonId:" , "1", "News", "https://www.gsmarena.com/news.php3"},
                {"ButtonId:" , "2", "Reviews", "https://www.gsmarena.com/reviews.php3"},
                {"ButtonId:" , "3", "Videos", "https://www.gsmarena.com/videos.php3"},
                {"ButtonId:" , "4", "Featured", "https://www.gsmarena.com/news.php3?sTag=Featured"},
                {"ButtonId:" , "5", "Phone Finder", "https://www.gsmarena.com/search.php3"},
                {"ButtonId:" , "6", "Deals", "https://www.gsmarena.com/deals.php3"},
                {"ButtonId:" , "7", "MerchNew", "https://merch.gsmarena.com/"},
                {"ButtonId:" , "8", "Coverage", "https://www.gsmarena.com/network-bands.php3"},
                {"ButtonId:" , "9", "Contact", "https://www.gsmarena.com/contact.php3"}};
    }

}
