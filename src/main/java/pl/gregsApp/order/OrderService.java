package pl.gregsApp.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gregsApp.category.CategoryRepository;
import pl.gregsApp.dish.Dish;
import pl.gregsApp.dish.DishRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    public static Set<Dish> dishes = new HashSet<>();


    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private DishRepository dishRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public OrderService(OrderRepository orderRepository, CategoryRepository categoryRepository, DishRepository dishRepository, PasswordEncoder passwordEncoder) {
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.dishRepository = dishRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createOrder() {

        Order order = new Order();
        double result = 0.0;
        for (Dish dish : OrderService.dishes) {
            result += dish.getPrice();
        }
        Set<Dish> dupa = new HashSet<>();

        for (Dish dish : dishes) {
            dupa.add(dish);
        }
        order.setSumValue(result);
        order.setDishes(dupa);
        order.setStatusOfOrder("W trakcie realizacji, damy znać :)");
        order.setOrderContent(dishes.stream().map(d -> d.getNameOfDish()).collect(Collectors.joining(" ,")));
        order.setDishes(OrderService.dishes);
        dishes = new HashSet<>();
        orderRepository.save(order);

    }

    public void createExtensionOrder(Long id) {

        Dish dish = dishRepository.findOneById(id);
        dishes.add(dish);

    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);

    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<OrderDto> findAllDto() {

        List<Order> all = orderRepository.findAll();

        List<OrderDto> orderDtos = new ArrayList<>();

        for (Order order : all) {
            orderDtos.add(new OrderDto(order));
        }


        return orderDtos;
    }


}
