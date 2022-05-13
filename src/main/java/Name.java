import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {
    @JsonProperty("firstname")
    String firstname;
    @JsonProperty("lastname")
    String lastname;

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Name() {}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
