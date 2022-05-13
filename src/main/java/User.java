import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("address")
    Address address;
    @JsonProperty("id")
    int id;
    @JsonProperty("email")
    String email;
    @JsonProperty("username")
    String username;
    @JsonProperty("password")
    String password;
    @JsonProperty("name")
    Name name;
    @JsonProperty("phone")
    String phone;

    public User(Address address, int id, String email, String username, String password, Name name, String phone) {
        this.address = address;
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "address=" + " lat= "+address.getGeolocation().getLat() + " ,long= "+address.getGeolocation().getLongg() + " city= "+address.getCity() + " street= "+address.getStreet() + " number= "+address.getNumber() + " zipcode= "+address.getZipcode()+
                " , id= " + id +
                " , email= '" + email + '\'' +
                " , username= '" + username + '\'' +
                " , password= '" + password + '\'' +
                " , name=" + " firstname= "+ name.getFirstname() +" lastname= "+name.getLastname()+
                " , phone='" + phone + '\'' +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Geolocation getGeolocation(){
        return this.getAddress().getGeolocation();
    }

    public void showFullName(){
        System.out.println("Firstname: "+ this.getName().getFirstname() +" Lastname: "+ this.getName().getLastname());
    }

    public double calculateDistance(User user){ //function calculates distance between 2 users
        double distance =0;
        double x1,x2,y1,y2;

        x1=this.getGeolocation().getLongg();
        y1=this.getGeolocation().getLat();
        x2=user.getGeolocation().getLongg();
        y2=user.getGeolocation().getLat();

        distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        return distance;
     }
}
