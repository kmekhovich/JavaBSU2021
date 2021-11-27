package by.kmekhovich.auto.repositories;

import by.kmekhovich.auto.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Integer> {
    Order findById(String id);
}
