package pl.gregsApp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // nei wiem czy to potrzebne
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

    User findOneByUuid(String uuid);

    User findOneById(Long id);

    User findOneByFirstName(String firstname);
    User findOneByLastName(String lastName);

    List<User> findAll();


}
