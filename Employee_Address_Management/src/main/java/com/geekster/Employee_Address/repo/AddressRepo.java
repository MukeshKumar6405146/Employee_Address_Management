package com.geekster.Employee_Address.repo;

import com.geekster.Employee_Address.model.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
//    @Modifying
//    @Transactional
//    @Query(value = "Select * from address", nativeQuery = true)
//    List<Address> getAll();
}

