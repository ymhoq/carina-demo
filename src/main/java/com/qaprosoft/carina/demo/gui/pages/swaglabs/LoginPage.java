package com.qaprosoft.carina.demo.gui.pages.swaglabs;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.type(login); }
    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.type(passwd); }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click(); }

    public ProductPage clickLoginBtnReturnPage() {
        loginBtn.click();
        LOGGER.info("Login button is clicked");
        return new ProductPage(getDriver());
    }


}
