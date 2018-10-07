package com.solstice.ecommerce.service;

import com.solstice.ecommerce.model.Shipment;
import com.solstice.ecommerce.repository.AccountRepository;
import com.solstice.ecommerce.repository.AddressRepository;
import com.solstice.ecommerce.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;
    private AddressRepository addressRepository;
    private AccountRepository accountRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, AddressRepository addressRepository, AccountRepository accountRepository) {
        this.shipmentRepository = shipmentRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }


    public void addShipment(long accountId, long addressId, Shipment shipment) {

        shipment.setAccount(accountRepository.getOne(accountId));
        shipment.setShippingAddress(addressRepository.getOne(addressId));

        shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(long id) {

        return shipmentRepository.findById(id);
    }

    public void updateShipment(Long id, Shipment shipment) {

        shipmentRepository.save(shipment);
    }

    public void deleteShipmentById(long id) {

        shipmentRepository.deleteById(id);
    }

    public List<Shipment> getAllShipment() {

        return shipmentRepository.findAll();
    }

    public List<Shipment> getShipmentByAccountByDeliveryDat(long accountId) {

        return shipmentRepository.findAllByAccount_AccountIdOrderByDeliveryDate(accountId);
    }
}
