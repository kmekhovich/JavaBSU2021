package by.kmekhovich.auto;

import by.kmekhovich.auto.model.Order;
import by.kmekhovich.auto.model.Passenger;
import by.kmekhovich.auto.repositories.OrdersRepository;
import by.kmekhovich.auto.repositories.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository orderRepository;

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void addPassenger(Integer orderId, Passenger passenger) {
        Order order = getOrderById(orderId);
        order.getPassengers().add(passenger);
        order.setAvailableSeats(getOrderById(orderId).getAvailableSeats() - 1);
        orderRepository.save(order);
    }

    public void deleteById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    public void deletePassengerById(Integer orderId, Integer passengerId) {
        Order order = getOrderById(orderId);
        order.getPassengers().removeIf(passenger -> Objects.equals(passenger.getId(), passengerId));
        order.setAvailableSeats(order.getAvailableSeats() + 1);
        orderRepository.save(order);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}
