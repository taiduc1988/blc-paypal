package org.broadleafcommerce.payment.service.gateway;

import com.broadleafcommerce.paymentgateway.domain.PaymentRequest;
import com.broadleafcommerce.paymentgateway.domain.PaymentResponse;
import com.broadleafcommerce.paymentgateway.service.PaymentGatewayTransactionService;
import com.broadleafcommerce.paymentgateway.service.exception.PaymentException;

import lombok.RequiredArgsConstructor;

/**
 * @author Elbert Bautista (elbertbautista)
 */
@RequiredArgsConstructor
public class DefaultPayPalCheckoutRollbackService implements PayPalCheckoutRollbackService {

    private final PaymentGatewayTransactionService transactionService;

    @Override
    public PaymentResponse rollbackAuthorize(PaymentRequest transactionToBeRolledBack)
            throws PaymentException {
        return transactionService.refund(transactionToBeRolledBack);
    }

    @Override
    public PaymentResponse rollbackCapture(PaymentRequest transactionToBeRolledBack)
            throws PaymentException {
        return transactionService.refund(transactionToBeRolledBack);
    }

    @Override
    public PaymentResponse rollbackAuthorizeAndCapture(PaymentRequest transactionToBeRolledBack)
            throws PaymentException {
        return transactionService.refund(transactionToBeRolledBack);
    }

    @Override
    public PaymentResponse rollbackRefund(PaymentRequest transactionToBeRolledBack)
            throws PaymentException {
        throw new PaymentException("The Rollback Refund method is not supported for this module");
    }

    @Override
    public String getGatewayType() {
        return PayPalCheckoutPaymentGatewayType.PAYPAL_CHECKOUT.name();
    }

}