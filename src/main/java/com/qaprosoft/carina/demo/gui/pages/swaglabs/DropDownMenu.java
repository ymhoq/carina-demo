package com.qaprosoft.carina.demo.gui.pages.swaglabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class DropDownMenu extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String defaultFilterMenu = "Name (A to Z)";

    private String secondFilter = "Name (Z to A)";
    private String thirdFilter = "Price (low to high)";
    private String fourseFilter = "Price (high to low)";


    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div['%s']")
    private ExtendedWebElement productElement;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div//")
    private List<ExtendedWebElement> productElementList;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    private ExtendedWebElement filterMenuChoosenCase;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    private ExtendedWebElement filterMenuBtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement firstFilterBtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement secondFilterBtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement thirdFilterBtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement fourthFilterBtn;

    public DropDownMenu(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }


    public boolean isDropMenuHasDefaultCase() {
        assertElementPresent(filterMenuChoosenCase);
        return filterMenuChoosenCase.getText().contentEquals(defaultFilterMenu);
    }
    public void dropMenuClick() {
        filterMenuBtn.click(); }

    public void dropMenuClick1() {
        firstFilterBtn.click(); }

    public void dropMenuClick2() {
        secondFilterBtn.click(); }

    public void dropMenuClick3() {
        thirdFilterBtn.click(); }

    public void dropMenuClick4() {
        fourthFilterBtn.click(); }

    public boolean verifyMenu() {
        boolean verifyMenu = false;
        assertElementPresent(firstFilterBtn);
        if(firstFilterBtn.getText().contentEquals(defaultFilterMenu)) { verifyMenu = true;
        assertElementPresent(secondFilterBtn);
        if(secondFilterBtn.getText().contentEquals(secondFilter)) {verifyMenu = true;
        assertElementPresent(thirdFilterBtn);
        if(thirdFilterBtn.getText().contentEquals(thirdFilter)) {verifyMenu = true;
        assertElementPresent(fourthFilterBtn);
        if(fourthFilterBtn.getText().contentEquals(fourseFilter)) {
            verifyMenu = true;
        }}}}
                return verifyMenu;
    }
}
