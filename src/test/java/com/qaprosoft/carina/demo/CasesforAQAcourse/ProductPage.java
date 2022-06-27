package com.qaprosoft.carina.demo.CasesforAQAcourse;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]")
    private WebElement productItem;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCardBtn;

    public void userLogout() {
        logoutBtn.click(); }

    public void addToCardBtn() {
        addToCardBtn.click(); }
    public void productItem() {
        productItem.click(); }

}
