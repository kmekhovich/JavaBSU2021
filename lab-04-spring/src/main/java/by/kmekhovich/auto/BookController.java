package by.kmekhovich.auto;

import by.kmekhovich.auto.model.Order;
import by.kmekhovich.auto.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    PassengersService passengersService;

    @PostMapping
    String book(@RequestParam Integer orderId, @RequestParam String passengerName) {
        if (!passengerName.isEmpty()) {
            Order order = ordersService.getOrderById(orderId);
            if (order.hasAvailableSeats()) {
                Passenger passenger = passengersService.addPassenger(passengerName);
                ordersService.addPassenger(orderId, passenger);
            }
        }
        return "redirect:/";
    }
}
