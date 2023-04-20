package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.PagesNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ReviewPage extends AbstractPage {

    private final String comparePageUrl = "https://www.gsmarena.com/reviews.php3";

    private ReviewPage nextPage;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    private int currentPage = 1;

    private int lastPageNumber;

    @FindBy(xpath = "//div[@class='nav-pages']//a[last()]")
    private ExtendedWebElement lastPageButton;

    @FindBy(xpath = "//div[@class='review-nav col ']//a[@class='pages-next']")
    private ExtendedWebElement nextPageButton;

    @FindBy(xpath = "//div[@class='review-nav col ']//a[@class='pages-next']")
    private PagesNavBar pagesNavBar;

    public ReviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(nextPageButton);
        setPageAbsoluteURL(comparePageUrl);
        setLastPage();
    }

    private int getCounOfPages() {
        int countOfPages = 0;
        String textContent = lastPageButton.getElement().getAttribute("textContent");
        try {
            countOfPages = Integer.parseInt(textContent);

        } catch (NumberFormatException e) {
            LOGGER.info("cant parse count of last page");
        }
        return countOfPages;
    }

    private void setLastPage() {
        lastPageNumber = getCounOfPages();
    }

    public ReviewPage clickNextPage(long timeout) {
        nextPageButton.click( timeout);
        return new ReviewPage(driver);
    }

    public Integer getLastPageNumber() {
        return lastPageNumber;
    }

    public ReviewPage getNextPage() {
        return nextPage;
    }

    @Override
    public boolean isPageOpened() {
        if (lastPageButton.isElementPresent()) return true;
        else return false;
    }

}
