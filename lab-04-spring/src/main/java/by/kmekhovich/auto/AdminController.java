package by.kmekhovich.auto;

import by.kmekhovich.auto.model.Order;
import by.kmekhovich.auto.model.Passenger;
import by.kmekhovich.auto.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class OrderByIdConverter implements Converter<String, Order> {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderByIdConverter(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Order convert(String id) {
        return ordersRepository.findById(id);
    }

}

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    PassengersService passengersService;

    @GetMapping
    String admin(Model model) {
        model.addAttribute("orders", ordersService.getOrders());
        model.addAttribute("order", Order.createDefaultOrder());
        return "admin";
    }

    @GetMapping("/delete")
    String delete(@RequestParam Integer orderId) {
        ordersService.deleteById(orderId);
        return "redirect:/admin";
    }

    @GetMapping("/deletePassenger")
    String deletePassenger(@RequestParam Integer orderId, @RequestParam Integer passengerId) {
        ordersService.deletePassengerById(orderId, passengerId);
        passengersService.deleteById(passengerId);
        return "redirect:/admin";
    }

    @PostMapping("/add")
    String add(@Valid Order order, BindingResult bindingResult) {
        if (!bindingResult.hasErrors() && order.hasAvailableSeats()) {
            ordersService.addOrder(order);
        }
        return "redirect:/admin";
    }
}