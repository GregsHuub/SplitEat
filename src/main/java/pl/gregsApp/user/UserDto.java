package pl.gregsApp.user;


import pl.gregsApp.address.Address;

public class UserDto {
    Address address;
    // to polaczyc z logowaniem

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private String city;
    private String postCode;
    private String street;
    private Integer streetNumber;
    private Integer houseNumber;


    public UserDto(){

    }

    public UserDto(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.contactNumber = user.getContactNumber();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.city = address.getCity();
        this.postCode = address.getPostCode();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
        this.houseNumber = address.getHouseNumber();
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
