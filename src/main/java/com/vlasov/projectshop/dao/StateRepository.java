package com.vlasov.projectshop.dao;

import com.vlasov.projectshop.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StateRepository extends JpaRepository<State,Integer> {
    List<State> findStatesByCountryCode(@Param("code")String code);
}
