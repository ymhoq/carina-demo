package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ArticleItem;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.DateFormatter;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArticlePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='user-thread']")
    private List<ArticleItem> coments;

    @FindBy(xpath = "//div[@class ='article-info']")
    private ExtendedWebElement articleInfo;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        if(articleInfo.isElementPresent()) return true;
        else return false;
    }

    public List<LocalDateTime> getDatesList() {
        List<LocalDateTime> listDateTime = new ArrayList<>();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (ArticleItem articleItem : coments) {
            LocalDateTime localDateTime = LocalDateTime.parse(articleItem.getComentDataTime().
                    getAttribute("data-time"), dateTimeFormatter);
            listDateTime.add(localDateTime);
            LOGGER.info(localDateTime + "was added to list");
        }
        LOGGER.info("Dates was gotten from htnl atributes");
        return listDateTime;
    }

}
