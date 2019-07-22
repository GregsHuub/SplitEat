package pl.gregsApp.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gregsApp.user.User;
import pl.gregsApp.user.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public void createAddress(String city, String postCode, String street
    , Integer streetNumber, Integer houseNumber, Long userId){

        Address address = new Address();
        address.setCity(city);
        address.setPostCode(postCode);
        address.setStreet(street);
        address.setStreetNumber(streetNumber);
        address.setHouseNumber(houseNumber);

        User user = userRepository.findOneById(userId);
        address.setUser(user);
        addressRepository.save(address);
    }

    public void updateAddress(String city, String postCode,
                              String street, Integer streetNumber,
                              Integer houseNumber, Long userId){
        Address address = new Address();
        address.setCity(city);
        address.setPostCode(postCode);
        address.setStreet(street);
        address.setStreetNumber(streetNumber);
        address.setHouseNumber(houseNumber);

        User user = userRepository.findOneById(userId);
        address.setUser(user);
        addressRepository.save(address);
    }

    public List<AddressDto> showAll(){
        return addressRepository.findAll().stream()
                .map(AddressDto::new).collect(Collectors.toList());
    }
}
