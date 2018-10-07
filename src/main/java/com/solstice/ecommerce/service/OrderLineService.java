package com.solstice.ecommerce.service;

import com.solstice.ecommerce.model.OrderLineItems;
import com.solstice.ecommerce.repository.OrderLineItemsRepository;
import com.solstice.ecommerce.repository.ProductRepository;
import com.solstice.ecommerce.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    private OrderLineItemsRepository orderLineItemsRepository;
    private ProductRepository productRepository;
    private ShipmentRepository shipmentRepository;

    public OrderLineService(OrderLineItemsRepository orderLineItemsRepository, ProductRepository productRepository, ShipmentRepository shipmentRepository) {
        this.orderLineItemsRepository = orderLineItemsRepository;
        this.productRepository = productRepository;
        this.shipmentRepository = shipmentRepository;
    }

    public List<OrderLineItems> getAllOrderLine() {

        return orderLineItemsRepository.findAll();
    }

    public void addOrderLine(Long productId, Long shipmentId, OrderLineItems orderLineItems) {

        orderLineItems.setProduct(productRepository.getOne(productId));
        orderLineItems.setShipment(shipmentRepository.getOne(shipmentId));

        orderLineItemsRepository.save(orderLineItems);
    }

    public Optional<OrderLineItems> getOrderLineItemsById(long id) {

        return orderLineItemsRepository.findById(id);
    }


    public void updateOrderLineItemsById(Long id, OrderLineItems orderLineItems) {

        orderLineItemsRepository.save(orderLineItems);
    }

    public void deleteOrderLineItemById(long id) {

        orderLineItemsRepository.deleteById(id);
    }
}
