package com.qaprosoft.carina.demo.gui.components.footer;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterItem extends AbstractUIObject {

    @FindBy ( xpath = "./a")
    public ExtendedWebElement footerLink;

    public FooterItem(WebDriver driver) {
        super(driver);
    }

    public FooterItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getAtribute(String attribute) {
        return footerLink.getAttribute(attribute);
    }

    public boolean isPresent() {
        return footerLink.isPresent();
    }

    public void click() {
        footerLink.click();
    }

}
