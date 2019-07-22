package pl.gregsApp.address;

public class AddressDto {

    private Long id;
    private String city;
    private String postCode;
    private String street;
    private Integer streetNumber;
    private Integer houseNumber;
    private Integer user;

    public AddressDto(Address address){
        this.city = address.getCity();
        this.postCode = address.getPostCode();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
        this.houseNumber = address.getHouseNumber();
        this.user = address.getUser().getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", houseNumber=" + houseNumber +
                ", user='" + user + '\'' +
                '}';
    }
}
