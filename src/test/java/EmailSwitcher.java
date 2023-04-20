import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.email.EmailPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.annotations.Test;

public class EmailSwitcher implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    @XlsDataSourceParameters(path = "xls/emails.xlsx", sheet = "instausers", dsUid = "id", dsArgs = "email, password" )
    public void testEmailPage() {

        EmailPage emailPage = new EmailPage(getDriver());
        emailPage.open();






    }


}
