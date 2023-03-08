package com.vlasov.projectshop.dao;

import com.vlasov.projectshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerEmail(@Param("email")String email);
}
