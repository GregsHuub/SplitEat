package pl.gregsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gregsApp.address.Address;
import pl.gregsApp.address.AddressRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    //    private PasswordEncoder passwordEncoder
    private AddressRepository addressRepository;
    private PasswordEncoder passwordEncoder;



    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }
//
//    public void createUserAndAddress(UserDto userDto) {
//
//        User user = new User();
//        user.setEmail(RandomStringUtils.randomAlphabetic(10) +"@mm.pl");
//        user.setFirstName(RandomStringUtils.randomAlphabetic(12));
//        user.setLastName(RandomStringUtils.randomAlphabetic(12));
//        user.setYearOfBirth(2998);
//        user.setPassword("2342234");
//        user.setEnabled(true);
//        userRepository.save(user);
//
//
//    }

    public void createUserAndAddress(UserDto userDto) {
        Set<Address> setOfAddres = new HashSet<>();

        Address address = new Address();
        address.setCity(userDto.getCity());
        address.setStreet(userDto.getStreet());
        address.setPostCode(userDto.getPostCode());
        address.setStreetNumber(userDto.getStreetNumber());
        address.setHouseNumber(userDto.getHouseNumber());

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setContactNumber(userDto.getContactNumber());
        address.setUser(user);

        setOfAddres.add(address);
        for (Address address1 : setOfAddres) {
            addressRepository.save(address1);
//        }
            user.setAddress(setOfAddres);
            userRepository.save(user);
            addressRepository.save(address);
        }


    }
    public void enableUser(String uuid){
        User user = userRepository.findOneByUuid(uuid);
        user.setEnabled(true);
        userRepository.save(user);
    }
    public Integer getUserIdByEmail(String email){
        User user = userRepository.findOneByEmail(email);
        return user.getId();
    }


    public UserDto findUserById(Long id) {
        return new UserDto(userRepository.findOneById(id));
    }

    public UserDto findUserByName(String firstName) {
        return new UserDto(userRepository.findOneByFirstName(firstName));
    }

    public UserDto findUserByLastName(String lastName) {
        return new UserDto(userRepository.findOneByLastName(lastName));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteUserByLastName(String lastName) {
        userRepository.delete(userRepository.findOneByLastName(lastName));
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new)
                .collect(Collectors.toList());
    }

}
