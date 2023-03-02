package com.vlasov.projectshop.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vlasov.projectshop.dao.CustomerRepository;
import com.vlasov.projectshop.dto.Purchase;
import com.vlasov.projectshop.dto.PurchaseResponse;
import com.vlasov.projectshop.entity.Address;
import com.vlasov.projectshop.entity.Customer;
import com.vlasov.projectshop.entity.Order;
import com.vlasov.projectshop.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CheckoutServiceImpl implements  CheckoutService{
    CustomerRepository customerRepository;
    @Autowired
    CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
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

        customer.addOrder(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }
}
