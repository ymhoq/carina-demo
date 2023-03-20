package com.qaprosoft.carina.demo.api.payment;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;



@Endpoint(url = "${base_url}/payments", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetPaymentsMethod extends AbstractApiMethodV2 {
    public GetPaymentsMethod() {
    replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
}

}
