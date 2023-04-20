package com.qaprosoft.carina.demo.email;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends AbstractPage {

    @FindBy(xpath="//div[@class='vsIconx vs-icon-after con-input']//*[@id = 'i-email']")
    private ExtendedWebElement email;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public String getEmail() {
        return email.getText();
    }

}
