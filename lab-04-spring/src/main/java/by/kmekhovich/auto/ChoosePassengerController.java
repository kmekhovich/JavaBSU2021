package by.kmekhovich.auto;

import by.kmekhovich.auto.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/choosePassenger")
public class ChoosePassengerController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    PassengersService passengersService;

    @GetMapping
    String choosePassenger(Model model, @RequestParam Integer orderId) {
        model.addAttribute("orderId", orderId);
        model.addAttribute("order", ordersService.getOrderById(orderId));
        model.addAttribute("passenger", Passenger.createDefaultPassenger());
        return "choosePassenger";
    }
}
