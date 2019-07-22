package pl.gregsApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gregsApp.dish.DishRepository;
import pl.gregsApp.order.OrderDto;
import pl.gregsApp.order.OrderService;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;
    private DishRepository dishRepository;


    public OrderController(OrderService orderService, DishRepository dishRepository) {
        this.orderService = orderService;
        this.dishRepository = dishRepository;
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("order", new OrderDto());
        return "addMeal";
    }

    @GetMapping("/formFriends")
    public String addFormFriends(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("order", new OrderDto());
        return "addMealfriend";
    }

    @GetMapping("/orderReady")
    public String readyOrder(Model model) {
        orderService.createOrder();
        model.addAttribute("orders", orderService.findAllDto());
        return "order";
    }
//    @GetMapping("/listOfOrders")
//    public String listOfOrders(Model model){
//        model.addAttribute("orders", orderService.findAll());
//        return "manageOrder";
//    }
    @PostMapping("/delete/{id}")
    public String deleteOrderPosition(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        return "redirect:/api/order/orderReady";
    }

    @PostMapping("/add/{id}")
    public String addToOrder(@PathVariable("id") Long id) {
        orderService.createExtensionOrder(id);
        return "redirect:/api/order/form";

    }

    @PostMapping("/addFriend/{id}")
    public String addToOrderFriend(@PathVariable("id") Long id) {
        orderService.createExtensionOrder(id);
        return "redirect:/api/order/formFriends";


    }


}
