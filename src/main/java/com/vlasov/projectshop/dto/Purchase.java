package com.vlasov.projectshop.dto;

import com.vlasov.projectshop.entity.Address;
import com.vlasov.projectshop.entity.Customer;
import com.vlasov.projectshop.entity.Order;
import com.vlasov.projectshop.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class Purchase {
    private Address address;
    private Customer customer;
    private Order order;
    private List<OrderItem> orderItems;

}
