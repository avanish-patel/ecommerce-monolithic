package com.solstice.ecommerce.service;

import com.solstice.ecommerce.model.Orders;
import com.solstice.ecommerce.repository.AccountRepository;
import com.solstice.ecommerce.repository.AddressRepository;
import com.solstice.ecommerce.repository.OrderLineItemsRepository;
import com.solstice.ecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;
    private OrderLineItemsRepository orderLineItemsRepository;

    public OrdersService(OrdersRepository ordersRepository, AccountRepository accountRepository, AddressRepository addressRepository, OrderLineItemsRepository orderLineItemsRepository) {
        this.ordersRepository = ordersRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.orderLineItemsRepository = orderLineItemsRepository;
    }

    public List<Orders> getAllOrders() {

        return ordersRepository.findAll();
    }

    public void addOrders(long accountId, long addressId, long orderLineId, Orders orders) {

        orders.setAccount(accountRepository.getOne(accountId));
        orders.setShippingAddress(addressRepository.getOne(addressId));
        orders.setOrderLineItems(orderLineItemsRepository.getOne(orderLineId));
        ordersRepository.save(orders);
    }

    public Optional<Orders> getOrderById(long id) {

        return ordersRepository.findById(id);
    }

    public void updateOrderById(Long id, Orders orders) {

        ordersRepository.save(orders);
    }

    public void deleteOrderById(long id) {

        ordersRepository.deleteById(id);
    }

    public Orders getOrderForAccount(long accountId) {

        return ordersRepository.findAllByAccount_AccountId(accountId);
    }

    public List<Orders> getAllOrdersByAccountByDate(long accountId) {

        return ordersRepository.findAllByAccount_AccountIdOrderByOrderDate(accountId);
    }
}
