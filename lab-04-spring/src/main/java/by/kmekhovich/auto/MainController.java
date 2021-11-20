package by.kmekhovich.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/")
    String startPage(Model model) {
        model.addAttribute("orders", ordersService.getOrders());
        return "index";
    }
}
