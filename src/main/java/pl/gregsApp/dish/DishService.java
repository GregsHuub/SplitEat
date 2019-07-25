package pl.gregsApp.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gregsApp.category.Category;
import pl.gregsApp.category.CategoryRepository;
import pl.gregsApp.pdfMaker.PdfCreate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DishService {

    private DishRepository dishRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public DishService(DishRepository dishRepository, CategoryRepository categoryRepository) {
        this.dishRepository = dishRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createDish(String nameOfDish, String description,
                           Double price, Double calories, Category categoryId) {

        Category category = categoryRepository.findOneById(categoryId.getId());
        Dish dish = new Dish();
        dish.setNameOfDish(nameOfDish);
        dish.setDescription(description);
        dish.setCalories(calories);
        dish.setPrice(price);
        dish.setCategory(category);
        dishRepository.save(dish);

    }

    public void createDishDto(DishDto dishDto, Category categoryId) {
        Category category = categoryRepository.findOneById(categoryId.getId());
        Dish dish = new Dish();
        dish.setNameOfDish(dishDto.getNameOfDish());
        dish.setPrice(dishDto.getPrice());
        dish.setDescription(dishDto.getDescription());
        dish.setCalories(dishDto.getCalories());
        dish.setCategory(category);

        dishRepository.save(dish);

    }

    public void updateDish(Long id, DishDto dishDto) {

        Dish dish = dishRepository.findOneById(id);
        dish.setNameOfDish(dishDto.getNameOfDish());
        dish.setPrice(dishDto.getPrice());
        dish.setDescription(dishDto.getDescription());
        dish.setCalories(dishDto.getCalories());
        dishRepository.save(dish);
    }

    public List<DishDto> showAll() {
        return dishRepository.findAll().stream().map(DishDto::new)
                .collect(Collectors.toList());
    }

    public void deleteDishById(Long id) {
        dishRepository.deleteById(id);
    }

}
