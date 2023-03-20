package TestCase;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.payment.DeletePaymentMethod;
import com.qaprosoft.carina.demo.api.payment.GetPaymentsMethod;
import com.qaprosoft.carina.demo.api.payment.PostPaymentMethod;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAPI implements IAbstractTest {


    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testGetPayments() {
        GetPaymentsMethod getPaymentsMethod = new GetPaymentsMethod();
        getPaymentsMethod.addParameter("id", "56");
        getPaymentsMethod.callAPI();
        getPaymentsMethod.validateResponseAgainstSchema("api/payments/_get/rs.schema");

    }


    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testDeletePayment() {

        DeletePaymentMethod deletePaymentMethod = new DeletePaymentMethod();
        deletePaymentMethod.setProperties("api/payments/payment.properties");
        deletePaymentMethod.addParameter("id", "55");
        deletePaymentMethod.callAPIExpectSuccess();

    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testPostPayment() {
        PostPaymentMethod postPaymentMethod = new PostPaymentMethod();
        postPaymentMethod.setProperties("api/payments/payment.properties");
        postPaymentMethod.callAPIExpectSuccess();
        postPaymentMethod.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testPostPaymentWP() {
        PostPaymentMethod postPaymentMethod = new PostPaymentMethod();
        postPaymentMethod.setProperties("api/payments/payment.properties");

        AtomicInteger counter = new AtomicInteger(0);

        postPaymentMethod.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        postPaymentMethod.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "Andrii SA")
    public void testCreatePaymentMissingField() {
        PostPaymentMethod postPaymentMethod = new PostPaymentMethod();
        postPaymentMethod.setProperties("api/payments/payment.properties");

        //postPaymentMethod.getProperties().remove("id");
        //postPaymentMethod.getProperties().remove("dateOfReg");
        //postPaymentMethod.getProperties().remove("amount");
        //postPaymentMethod.getProperties().remove("driverId");


        int id = Integer.parseInt(postPaymentMethod.getProperties().getProperty("id"));

        for (int i = id; i < 2 * id; i++) {

            String idProperty = String.valueOf(i);
            postPaymentMethod.getProperties().setProperty("id", idProperty);

            postPaymentMethod.callAPIExpectSuccess();
        }

    }
}