package pl.gregsApp.dish;

public class DishDto {

    private String nameOfDish;
    private String description;
    private Double price;

    private String category;
    private Double calories;

    public DishDto() {
    }

    public DishDto(Dish dish) {
        this.nameOfDish = dish.getNameOfDish();
        this.description = dish.getDescription();
        this.price = dish.getPrice();
        this.calories = dish.getCalories();
        this.category = dish.getCategory().toString();
    }


    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }
}
