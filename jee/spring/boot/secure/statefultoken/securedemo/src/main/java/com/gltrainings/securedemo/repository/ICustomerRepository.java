package com.gltrainings.securedemo.repository;

import com.gltrainings.securedemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from Customer c join c.user u where u.username=:username")
    Optional<Customer> findByUsername(@Param("username") String username);

}
