package com.solstice.ecommerce.service;

import com.solstice.ecommerce.model.Address;
import com.solstice.ecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddressById(long id) {

        return addressRepository.findById(id);
    }

    public List<Address> getAllAddresses() {

        return addressRepository.findAll();
    }

    public void addAddress(Address address) {

        addressRepository.save(address);
    }

    public void updateAddress(Long id, Address address) {

        addressRepository.save(address);
    }

    public void deleteAddressById(long id) {

        addressRepository.deleteById(id);
    }
}
