package com.vlasov.projectshop.controller;

import com.vlasov.projectshop.dto.Purchase;
import com.vlasov.projectshop.dto.PurchaseResponse;
import com.vlasov.projectshop.service.CheckoutService;
import com.vlasov.projectshop.service.CheckoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/checkout")
public class CheckoutController {
    CheckoutService checkoutService;
    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        return checkoutService.placeOrder(purchase);
    }
}
