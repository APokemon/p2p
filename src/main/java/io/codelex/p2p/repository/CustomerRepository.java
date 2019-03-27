package io.codelex.p2p.repository;

import io.codelex.p2p.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select count(customer)>0 from Customer customer where"
            + " customer.email =:email")
    boolean isThereAEmail(@Param("email") String email);
    
     Optional<Customer> findByEmail(String email);
     
}
