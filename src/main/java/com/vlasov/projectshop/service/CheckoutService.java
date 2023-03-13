package com.vlasov.projectshop.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.vlasov.projectshop.dto.PaymentIfo;
import com.vlasov.projectshop.dto.Purchase;
import com.vlasov.projectshop.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
    PaymentIntent createPaymentIntent(PaymentIfo paymentIfo) throws StripeException;
}
