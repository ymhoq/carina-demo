package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.saucedemo.ItemsPage;
import com.qaprosoft.carina.demo.gui.saucedemo.SauceHome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSauseExam implements IAbstractTest {

    final static String USERNAME = "standard_user";

    final static String PASSWORD = "secret_sauce";

  @Test()
  public void testLogin() {

      SauceHome sauceHome = new SauceHome(getDriver());
      sauceHome.open();

      Assert.assertTrue( sauceHome.isPageOpened(), "Home page not opened");

      ItemsPage itemsPage = sauceHome.getItemsPage();

      Assert.assertTrue( itemsPage.isPageOpened(), "item page not opened");



  }


}
