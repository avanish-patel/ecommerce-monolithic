package com.solstice.ecommerce.controller;

import com.solstice.ecommerce.model.Shipment;
import com.solstice.ecommerce.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    @GetMapping()
    public List<Shipment> getAllShipment() {

        return shipmentService.getAllShipment();
    }

    @PostMapping("/account/{accountId}/address/{addressId}")
    public String addShipment(@PathVariable("accountId") long accountId, @PathVariable("addressId") long addressId, @RequestBody Shipment shipment) {

        shipmentService.addShipment(accountId, addressId, shipment);

        return "Shipment is added.";
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getShipmentById(@PathVariable("id") long id) {

        return shipmentService.getShipmentById(id);
    }

    @PutMapping("/{id}")
    public String updateShipment(@PathVariable("id") long id, @RequestBody Shipment shipment) {

        shipmentService.updateShipment(id, shipment);
        return "Shipment is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteShipmentById(@PathVariable("id") long id) {

        shipmentService.deleteShipmentById(id);

        return "Shipment with Shipment Number " + id + " successfully deleted.";
    }

    @GetMapping("/accountId/{accountId}/date")
    public List<Shipment> getShipmentByAccountByDeliveryDate(@PathVariable("accountId") long accountId) {

        return shipmentService.getShipmentByAccountByDeliveryDat(accountId);
    }
}
