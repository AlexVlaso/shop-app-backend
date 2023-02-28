package com.vlasov.projectshop.dao;

import com.vlasov.projectshop.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Integer> {
}
