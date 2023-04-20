package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PagesNavBar extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='nav-pages']//a")
    List<ExtendedWebElement> pageButtons;

    @FindBy(xpath = "//div[@class='nav-pages']//strong")
    ExtendedWebElement curentButton;

    Integer firstPage;

    Integer lastPage;

    Integer size;

    Integer current;

    public PagesNavBar(WebDriver driver) {
        super(driver);
    }

    public PagesNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setAll();
    }

    public List<ExtendedWebElement> getPageButtons() {
        return pageButtons;
    }


    private void setSize() {
        this.size = pageButtons.size();
    }

    private void setCurrent() {
        this.current = Integer.parseInt(curentButton.getElement().getAttribute("textContent"));
    }

    private void setLastPage() {
        this.lastPage = Integer.parseInt(pageButtons.get(size - 1).
                getElement().getAttribute("textContent"));
    }

    private void setFirstPage() {
        this.firstPage = Integer.parseInt(pageButtons.get(0).
                getElement().getAttribute("textContent"));
    }

    private void setAll() {
        if (!this.isUIObjectPresent()) {
            return;
        }
        if (pageButtons.isEmpty()) {
            return;
        }
        if (pageButtons.size() < 1) {
            return;
        }
        setSize();
        setFirstPage();
        setCurrent();
        setLastPage();
    }
}
