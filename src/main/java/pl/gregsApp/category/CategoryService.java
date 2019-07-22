package pl.gregsApp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(String name, String type) {

        Category category = new Category();
        category.setName(name);
        category.setType(type);

        categoryRepository.save(category);

    }
    public void updateCategory(Long id,String name, String type){
        Category category = categoryRepository.findOneById(id);
        category.setName(name);
        category.setType(type);
    }
    public List<CategoryDto> showAll(){
        return categoryRepository.findAll().stream().map(CategoryDto::new)
                .collect(Collectors.toList());
    }
    public void findByName(String name){
        categoryRepository.findOneByName(name);
    }
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }


}
