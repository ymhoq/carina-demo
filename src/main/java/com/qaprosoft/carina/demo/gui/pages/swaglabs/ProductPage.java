package com.qaprosoft.carina.demo.gui.pages.swaglabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends AbstractPage {
    DropDownMenu dropDownMenu;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    private ExtendedWebElement productItem;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div['%s']")
    private ExtendedWebElement productValueItem;


    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement addToCardBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public void userLogout() {
        logoutBtn.click(); }

    public void addToCardBtn() {
        addToCardBtn.click(); }
    public void productItem() {
        productItem.click(); }

    public DropDownMenu getDropDownMenu() {
        return dropDownMenu;
    }

    public void setDropDownMenu(DropDownMenu dropDownMenu) {
        this.dropDownMenu = dropDownMenu;
    }

    public List<String> readProductsByClassName(String className) {

        List<WebElement> elementsList = new ArrayList<>();
        List <String> textByClassName = new ArrayList<>();

        elementsList = driver.findElements(By.className(className));

        for(WebElement item : elementsList) {
            textByClassName.add(item.getText());
        }
        return textByClassName;
    }

    public List<String> readAndSortByNumberProductsByClassName(String className) {

        List<WebElement> elementsList = new ArrayList<>();
        List <String> textByClassName = new ArrayList<>();

        elementsList = driver.findElements(By.className(className));

        for(WebElement item : elementsList) {
            textByClassName.add(item.getText());
        }
        textByClassName.sort(NaturalOrderComparators.createNaturalOrderRegexComparator());
        return textByClassName;
    }

   public List<String> reverseList(List<String> stringList) {

       List<String> reverseList = new ArrayList<>();
       for (int i = stringList.size()-1; i>=0; i--) {
           reverseList.add( stringList.get(i));
       }
        return reverseList;
   }




}
