package pl.gregsApp.user;

import pl.gregsApp.dish.Dish;
import pl.gregsApp.order.Order;

import javax.persistence.*;

@Entity
@Table(name = "user_orders")
public class User_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    private Double dishPrice;
    private String dishName;

    // DO POBIRANIA
    // ID
    // PRICE
    // NAME






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
