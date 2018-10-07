package com.solstice.ecommerce.controller;

import com.solstice.ecommerce.model.OrderLineItems;
import com.solstice.ecommerce.service.OrderLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderLine")
public class OrderLineItemsController {

    private OrderLineService orderLineService;

    public OrderLineItemsController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;

    }

    @GetMapping
    public List<OrderLineItems> getAllOrderLine() {

        return orderLineService.getAllOrderLine();
    }

    @PostMapping("/product/{productId}/shipment/{shipmentId}")
    public void addOrderLine(@PathVariable("productId") long productId, @PathVariable("shipmentId") long shipmentId, @RequestBody OrderLineItems orderLineItems) {

        orderLineService.addOrderLine(productId, shipmentId, orderLineItems);
    }

    @GetMapping("/{id}")
    public Optional<OrderLineItems> getOrderLineItemsById(@PathVariable("id") long id) {

        return orderLineService.getOrderLineItemsById(id);
    }

    @PutMapping("/{id}")
    public String updateOrderLineItemsById(@PathVariable("id") long id, @RequestBody OrderLineItems orderLineItems) {

        orderLineService.updateOrderLineItemsById(id, orderLineItems);
        return "Order Line Item is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderLineItemById(@PathVariable("id") long id) {

        orderLineService.deleteOrderLineItemById(id);

        return "Order with " + id + " successfully deleted.";
    }
}
