package com.solstice.ecommerce.repository;

import com.solstice.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByAccount_AccountIdOrderByOrderDate(long accountId);

    Orders findAllByAccount_AccountId(long accountId);

}
