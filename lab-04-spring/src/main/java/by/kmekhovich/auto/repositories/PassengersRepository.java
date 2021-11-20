package by.kmekhovich.auto.repositories;

import by.kmekhovich.auto.model.Order;
import by.kmekhovich.auto.model.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends CrudRepository<Passenger, Integer> {}
