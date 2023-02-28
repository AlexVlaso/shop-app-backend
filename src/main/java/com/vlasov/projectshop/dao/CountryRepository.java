package com.vlasov.projectshop.dao;

import com.vlasov.projectshop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
