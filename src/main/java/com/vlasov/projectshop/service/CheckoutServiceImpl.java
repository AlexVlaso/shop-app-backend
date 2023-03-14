package com.vlasov.projectshop.service;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.vlasov.projectshop.dao.CustomerRepository;
import com.vlasov.projectshop.dto.PaymentIfo;
import com.vlasov.projectshop.dto.Purchase;
import com.vlasov.projectshop.dto.PurchaseResponse;
import com.vlasov.projectshop.entity.Address;
import com.vlasov.projectshop.entity.Customer;
import com.vlasov.projectshop.entity.Order;
import com.vlasov.projectshop.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CheckoutServiceImpl implements  CheckoutService{
    CustomerRepository customerRepository;
    @Autowired
    CheckoutServiceImpl(CustomerRepository customerRepository, @Value("${stripe.key.secret}")String secret){
        this.customerRepository=customerRepository;
        Stripe.apiKey=secret;

    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order= purchase.getOrder();

        String orderTrackingNumber= UUID.randomUUID().toString();
        order.setOrderTrackingNumber(orderTrackingNumber);

        List<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item->order.add(item));

        Address address = purchase.getAddress();
        order.setAddress(address);

        Customer customer= purchase.getCustomer();
        Customer customerDB=customerRepository.findByEmail(customer.getEmail());

        if(customerDB!=null){
           if(customerDB.getFirstName()!=customer.getFirstName()){
               customerDB.setFirstName(customer.getFirstName());
           }
           if(customerDB.getLastName()!=customer.getLastName()){
               customerDB.setLastName(customer.getLastName());
           }
            customer=customerDB;
        }
        customer.addOrder(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentIfo paymentIfo) throws StripeException {
        List<String> paymentMethodTypes= new ArrayList<>();
        paymentMethodTypes.add("card");
        Map<String,Object> params= new HashMap<>();
        params.put("amount",paymentIfo.getAmount());
        params.put("currency",paymentIfo.getCurrency());
        params.put("payment_method_types",paymentMethodTypes);
        return PaymentIntent.create(params);
    }
}
