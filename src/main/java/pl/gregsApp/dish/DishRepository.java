package pl.gregsApp.dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {


Dish findOneById(Long id);
@Query("SELECT t from Dish t where t.description like ?1")
Set<Dish> findAllByDescriptionContaining(String containgToFind);


}
