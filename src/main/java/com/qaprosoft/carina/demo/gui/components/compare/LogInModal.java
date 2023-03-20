package com.qaprosoft.carina.demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LogInModal extends AbstractUIObject {


    @FindBy(xpath = ".//*[@id='email']")
    private ExtendedWebElement emailEdit;

    @FindBy(xpath = ".//*[@id='upass']")
    private ExtendedWebElement passwordEdit;

    @FindBy(xpath = ".//*[@id='nick-submit']")
    private ExtendedWebElement loginBtn;

    //div[@class ='normal-text res-error']


    public LogInModal(WebDriver driver) {
        super(driver);
    }
    public LogInModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }



    public LogInModal typeEmailEdit(String email) {
        this.emailEdit.type(email,20);
        return new LogInModal(driver);
    }

    public LogInModal typePasswordEdit(String pass) {
        this.passwordEdit.type(pass,20);
        return new LogInModal(driver);
    }

    public LoginPage clickLoginBtn() {
        this.loginBtn.click(20);
        return new LoginPage(driver);
    }


}
