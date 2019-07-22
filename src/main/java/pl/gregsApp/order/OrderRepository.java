package pl.gregsApp.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();
    Order findOneById(Long id);
    @Query ("SELECT t from Order t where t.orderContent like ?1")
    Set<Order> findAllByOrderContentStartsWith(String containtToFind);
    Order findAllByStatusOfOrder(String status);


}








