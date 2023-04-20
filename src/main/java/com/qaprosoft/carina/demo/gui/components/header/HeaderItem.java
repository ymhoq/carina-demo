package com.qaprosoft.carina.demo.gui.components.header;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.RedirectedPage;
import com.qaprosoft.carina.demo.gui.pages.ReviewPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderItem extends AbstractUIObject {

    @FindBy( xpath = ".//a")
    public ExtendedWebElement headerLink;

    public HeaderItem(WebDriver driver) {
        super(driver);
    }

    public HeaderItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readTitle() {
        return headerLink.getElement().getText();
    }

    public void click() {
        headerLink.click();
    }

    public ReviewPage getReviewPage() {
        click();
        return new ReviewPage(driver);
    }


    public AbstractPage openInNewTab() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(headerLink.getElement())
                .build()
                .perform();
        return new RedirectedPage(driver);
    }
}
