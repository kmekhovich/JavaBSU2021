package by.kmekhovich.auto;

import by.kmekhovich.auto.model.Order;
import by.kmekhovich.auto.model.Passenger;
import by.kmekhovich.auto.repositories.OrdersRepository;
import by.kmekhovich.auto.repositories.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengersService {
    @Autowired
    PassengersRepository passengersRepository;

    public Passenger addPassenger(String passengerName) {
        Passenger passenger = new Passenger();
        passenger.setName(passengerName);
        passengersRepository.save(passenger);
        return passenger;
    }

    public void deleteById(Integer passengerId) {
        passengersRepository.deleteById(passengerId);
    }
}
