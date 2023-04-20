package com.qaprosoft.carina.demo.gui.components;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.demo.gui.components.header.HeaderItem;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.demo.gui.components.compare.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.components.compare.LogInModal;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.RedirectedPage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.testng.Assert;

public class HeaderMenu extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id='topsearch-text']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//*[@id='anchor']/rect")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//*[@id='social-connect']/a[1]/i")
    private ExtendedWebElement tipsButton;

    @FindBy(xpath = "//*[@id='social-connect']/a[@class='yt-icon']")
    private ExtendedWebElement yTubeButton;

    @FindBy(xpath = "//*[@id='social-connect']/a[3]/i")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement rssButton;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement evButton;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement merchButton;

    @FindBy(xpath = "//*[@id='login-active']/i")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id='social-connect']/a[8]/i")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(),'News')]")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//li//a[@href = 'reviews.php3']")
    private ExtendedWebElement reviewsButton;

    @FindBy(xpath = "//li//a[@href = 'videos.php3']")
    private ExtendedWebElement videosButton;

    @FindBy(xpath = "//li//a[@href = 'news.php3?sTag=Featured']")
    private ExtendedWebElement featuredButton;

    @FindBy(xpath = "//li//a[@href = 'search.php3']")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(xpath = "//li//a[@href = 'deals.php3']")
    private ExtendedWebElement dealsButton;

    @FindBy(xpath = "//li//a[@href = 'https://merch.gsmarena.com/']")
    private ExtendedWebElement mergeButton;

    @FindBy(xpath = "//li//a[@href = 'network-bands.php3']")
    private ExtendedWebElement coverageButton;

    @FindBy(xpath = "//li//a[@href = 'contact.php3']")
    private ExtendedWebElement contactUsButton;

    @FindBy(id = "login-popup2")
    private LogInModal logInModal;

    @FindBy(xpath = "//header//ul[@id='menu']")
    private List<ExtendedWebElement> headerButtons;

    @FindBy(xpath = "//header//ul[@id='menu']//li")
    private List<HeaderItem> headerItemLinks;


    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getHeaderButtons() {
        return headerButtons;
    }

    public ExtendedWebElement getHeaderMenuElement(HeaderMenuElements elements) {
        return headerButtons.get(elements.getHeaderElement());
    }


    public CompareModelsPage openTipsButtonPage() {
        tipsButton.click();
        return new CompareModelsPage(driver);
    }

    public HeaderMenu openYTubeButtonPage() {
        yTubeButton.click();
        return this;
    }

    public HeaderMenu openReviewsButtonPage() {
        reviewsButton.click();
        return this;
    }

    public HeaderMenu openVideosButtonPage() {
        videosButton.click();
        return this;
    }

    public HeaderMenu openFeaturedButtonPage() {
        featuredButton.click();
        return this;
    }

    public HeaderMenu openPhoneFinderButtonPage() {
        phoneFinderButton.click();
        return this;
    }

    public HeaderMenu openDealsButtonPage() {
        dealsButton.click();
        return this;
    }

    public HeaderMenu openMergeButtonPage() {
        mergeButton.click();
        return this;
    }

    public HeaderMenu openCoverageButtonPage() {
        coverageButton.click();
        return this;
    }

    public HeaderMenu openContactUsButtonPage() {
        contactUsButton.click();
        return this;
    }


    public RedirectedPage openInstagramButtonPage() {
        instagramButton.click();
        return new RedirectedPage(driver);
    }

    public RedirectedPage openRssButtonPage() {
        rssButton.click();
        return new RedirectedPage(driver);
    }

    public RedirectedPage openEvButtonPage() {
        evButton.click();
        return new RedirectedPage(driver);
    }

    public RedirectedPage openMerchButtonPage() {
        merchButton.click();
        return new RedirectedPage(driver);
    }

    public LogInModal openLoginButtonPage() {
        loginButton.click();
        return logInModal;
    }

    public NewsPage openNewsButton() {
        newsButton.click();
        return new NewsPage(driver);
    }

    public SignUpPage openSignUpButtonPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public List<Field> getAllFields() {
        List<Field> fields = new ArrayList<>();
        Class<?> currentClass = getClass();
        while (currentClass != null) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            for (Field field : declaredFields) {
                fields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }
        return fields;
    }

    public void callMethodOnAllFields() {
        List<Field> fields = getAllFields();
        for (Field field : fields) {
            try {
                Method method = getClass().getDeclaredMethod("click");
                method.setAccessible(true);
                method.invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showTextInLinks() {
        for (HeaderItem headerItem : headerItemLinks) {
            LOGGER.info(headerItem.headerLink.getText());

            Assert.assertEquals(1, 1, "");
        }

    }

    public List<HeaderItem> getHeaderItemLinks() {
        return headerItemLinks;
    }


    public static void hoverOnAllLinks() {


    }

    public void hoverOnLink(WebDriver driver) throws InterruptedException {

// Locating the Main Menu (Parent element)
        // WebElement mainMenu = driver.findElement(By.xpath("<Xpath of the Main menu"));

//Instantiating Actions class
       /* Actions actions = new Actions(driver);

//Hovering on main menu
        actions.moveToElement(this.loginButton.getElement());

        actions.perform();
        this.sleep(10);
// Locating the element from Sub Menu
        // WebElement subMenu = driver.findElement(By.xpath("<Xpath of the sub element>"));

//To mouseover on sub menu
        actions.moveToElement(yTubeButton.getElement());
        driver.wait(100);
        actions.pause(10);
//build()- used to compile all the actions into a single step
        actions.click().build().perform();*/

    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    synchronized public void I_hover_over_menu_item() {
        //WebDriver driver = getDriver();
        By by = By.xpath(".//*[@id='login-active']/i");
        Actions actions = new Actions(driver);
        WebElement elem = driver.findElement(by);
        actions.moveToElement(elem);
        this.sleep(100);
        pause(10);
        actions.perform();
        pause(10);
        this.sleep(100);
    }


    public Logger toLogger(String text) {

        LOGGER.info(text);

        return LOGGER;
    }
}
