package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticleItem extends AbstractUIObject {

    @FindBy(xpath=".//li[@class ='upost']//time[@data-time]")
    private ExtendedWebElement comentDataTime;

    public ArticleItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getComentDataTime() {
        return comentDataTime;
    }
}
