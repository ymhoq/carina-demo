package com.qaprosoft.carina.demo.CasesforAQAcourse;

import com.qaprosoft.carina.core.foundation.api.ssl.NullHostnameVerifier;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")
    private ExtendedWebElement image;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"")
    private ExtendedWebElement ADDTOCARTbtn;

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public Boolean readImage() {
        assertElementPresent(image);
        return image.getElement().isDisplayed();
    }

    public String readProductName() {
        assertElementPresent(productName);
        return productName.getText();
    }

    public String readProductDescription() {
        assertElementPresent(productDescription);
        return productDescription.getText();
    }

    public String readPrice() {
        assertElementPresent(price);
        return price.getText();
    }


}
