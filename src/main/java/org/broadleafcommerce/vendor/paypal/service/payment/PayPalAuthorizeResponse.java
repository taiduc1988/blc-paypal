/*
 * #%L
 * BroadleafCommerce PayPal
 * %%
 * Copyright (C) 2009 - 2018 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.vendor.paypal.service.payment;

import com.paypal.api.payments.Authorization;
import com.paypal.api.payments.Payment;

public class PayPalAuthorizeResponse implements PayPalResponse {

    protected Payment authorizedPayment;
    protected Authorization authorization;

    public PayPalAuthorizeResponse(Payment authorizedPayment) {
        this.authorizedPayment = authorizedPayment;
    }

    public Payment getAuthorizedPayment() {
        return authorizedPayment;
    }

    public Authorization getAuthorization() {
        if (authorization == null) {
            this.authorization = authorizedPayment.getTransactions().get(0).getRelatedResources().get(0).getAuthorization();
        }
        return authorization;
    }
}
