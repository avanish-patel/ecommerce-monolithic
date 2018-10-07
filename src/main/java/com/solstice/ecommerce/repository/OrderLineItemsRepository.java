package com.solstice.ecommerce.repository;

import com.solstice.ecommerce.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Long> {
}
