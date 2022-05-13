import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("geolocation")
    Geolocation geolocation;
    @JsonProperty("city")
    String city;
    @JsonProperty("street")
    String street;
    @JsonProperty("number")
    int number;
    @JsonProperty("zipcode")
    String zipcode;

    public Address(Geolocation geolocation, String city, String street, int number, String zipcode) {
        this.geolocation = geolocation;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }
    public Address(){}

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }
}
