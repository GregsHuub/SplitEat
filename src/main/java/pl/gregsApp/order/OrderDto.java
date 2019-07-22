package pl.gregsApp.order;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class OrderDto {

    private Double sumValue;
    private String statusOfOrder;
    private String orderContentFromDish;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public OrderDto() {
    }

    public OrderDto(Order order){
        this.sumValue = order.getSumValue();
        this.statusOfOrder = order.getStatusOfOrder();
        this.orderContentFromDish = order.getDishes().stream().map(dish -> dish.getNameOfDish() + " " + dish.getPrice()).collect(Collectors.joining("<br>"));
        this.createdOn = order.getCreatedOn();
        this.updatedOn = order.getUpdatedOn();
    }
    @PrePersist
    public void preCreatePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdated() {
        updatedOn = LocalDateTime.now();
    }

    public Double getSumValue() {
        return sumValue;
    }

    public void setSumValue(Double sumValue) {
        this.sumValue = sumValue;
    }

    public String getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(String statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }


    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getOrderContentFromDish() {
        return orderContentFromDish;
    }

    public void setOrderContentFromDish(String orderContentFromDish) {
        this.orderContentFromDish = orderContentFromDish;
    }
}
