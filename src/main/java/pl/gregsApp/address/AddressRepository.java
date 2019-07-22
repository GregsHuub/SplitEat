package pl.gregsApp.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

//    Address findOneById(Long id);
    Address findUserById(Long id);
}
