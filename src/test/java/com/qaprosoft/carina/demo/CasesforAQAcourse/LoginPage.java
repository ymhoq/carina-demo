package com.qaprosoft.carina.demo.CasesforAQAcourse;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private ExtendedWebElement loginField;
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private ExtendedWebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[@id=\"password\"]")
    private ExtendedWebElement passwdField;
    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(Keys.valueOf(login)); }
    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(Keys.valueOf(passwd.)); }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click(); }

    public void open() {
        this.openURL("https://www.saucedemo.com/");
    }
}
