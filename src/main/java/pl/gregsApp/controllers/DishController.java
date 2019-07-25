package pl.gregsApp.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gregsApp.category.Category;
import pl.gregsApp.category.CategoryRepository;
import pl.gregsApp.category.CategoryService;
import pl.gregsApp.dish.DishDto;
import pl.gregsApp.dish.DishRepository;
import pl.gregsApp.dish.DishService;
import pl.gregsApp.order.OrderRepository;
import pl.gregsApp.pdfMaker.PdfCreate;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/dish")
public class DishController {

    private DishService dishService;
    private final DishRepository dishRepository;
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private OrderRepository orderRepository;


    @ModelAttribute("category")
    public Collection<Category> categories(){
       return categoryRepository.findAll();
    }

    public DishController(DishService dishService, DishRepository dishRepository, CategoryService categoryService, CategoryRepository categoryRepository) {
        this.dishService = dishService;
        this.dishRepository = dishRepository;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/addForm")
    public String addDishForm(Model model, Category category){
        model.addAttribute("dishDto", new DishDto());
        model.addAttribute("categoryName", category.getName());


        return "dishAddForm";
    }
    @PostMapping("/saveForm")
    public String saveForm(@ModelAttribute DishDto dishDto, @ModelAttribute Category category){
        dishService.createDishDto(dishDto,category);
        return "redirect:addForm";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("dishes", dishRepository.findAll());
        return "dishListWithButtons";
    }

    @PostMapping("/delete/{id}")
    public String deleteFromDish(@PathVariable("id") Long id){
        dishService.deleteDishById(id);
        return "redirect:/api/dish/list";
    }

    @GetMapping("/dishList")
    public String showDishList(Model model){
        Model dishesFound = model.addAttribute("dishes", dishRepository.findAll());
        PdfCreate pdfCreate = new PdfCreate();
        try {
            pdfCreate.pdfPrinterItext(dishesFound.toString(), "List");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        return "dishListForUsers";
    }

}
