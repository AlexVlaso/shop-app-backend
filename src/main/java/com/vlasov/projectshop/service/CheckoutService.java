package com.vlasov.projectshop.service;

import com.vlasov.projectshop.dto.Purchase;
import com.vlasov.projectshop.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
