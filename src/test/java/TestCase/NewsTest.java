package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class NewsTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testArticleComents() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened");

        homePage.openHeaderMenu();

        NewsPage newsPage = homePage.getHeaderMenu().openNewsButton();
        Assert.assertTrue(newsPage.isPageOpened(), "news page not opened");

        ArticlePage articlePage = newsPage.openArticle(0);
        Assert.assertTrue(articlePage.isPageOpen(), "article page not opened");

        Assert.assertEquals(articlePage.getDatesList(),
                articlePage.getDatesList().stream().sorted().collect(Collectors.toList()),
                "Order of coments is incorrect");


    }

}
