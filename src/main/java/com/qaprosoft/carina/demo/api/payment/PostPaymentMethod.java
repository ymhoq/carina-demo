package com.qaprosoft.carina.demo.api.payment;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/payments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/payments/_post/rq.json")
@ResponseTemplatePath(path = "api/payments/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPaymentMethod extends AbstractApiMethodV2 {
    public PostPaymentMethod() {
        super("api/payments/_post/rq.json", "api/payments/_post/rs.json", "api/payments/payment.properties");
        replaceUrlPlaceholder( "base_url", Configuration.getEnvArg("api_url"));
    }
}
