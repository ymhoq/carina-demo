package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.PagesNavBar;
import com.qaprosoft.carina.demo.gui.components.compare.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ReviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReviewTest implements IAbstractTest {


    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void openAllPages() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Class<?> cls = Class.forName("ReviewPage");

        homePage.openHeaderMenu();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        ReviewPage reviewPage = headerMenu.getHeaderItemLinks()
                .get(HeaderMenuElements.REVIEWS.getHeaderElement()).getReviewPage();

        Assert.assertTrue(reviewPage.isPageOpened(100), "page not opened");

        PagesNavBar pagesNavBar;


        ReviewPage currentPage = (ReviewPage) cls.newInstance();

        int allPages = reviewPage.getLastPageNumber();

        for (int i = 0; i < allPages; i++) {

            currentPage = reviewPage;

            System.out.println(currentPage.getCurrentUrl() );

            reviewPage = reviewPage.clickNextPage(100);

            System.out.println(reviewPage.getCurrentUrl());

            //System.out.println(reviewPage.getNextPage().getCurrentUrl());

            softAssert.assertTrue(reviewPage.isPageOpened(100), "next page not opened");


            //   Assert.assertNotEquals(currentPage, reviewPage.getNextPage(), "next page not correct");


            softAssert.assertAll();

        }


    }
}
