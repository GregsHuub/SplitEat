package pl.gregsApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gregsApp.address.AddressService;
import pl.gregsApp.user.UserDto;
import pl.gregsApp.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private AddressService addressService;

    @Autowired
    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("/addForm")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());

        return "userAddForm";
    }

    @PostMapping("/saveInDataBase")
    public String saveForm(@Valid @ModelAttribute UserDto userDto) {
        userService.createUserAndAddress(userDto);
        return "redirect:http://localhost:8080/";
    }




}
