import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Cart {
    @JsonProperty("id")
    int id;
    @JsonProperty("userID")
    int userId;
    @JsonProperty("date")
    Date date; //poczytać
    @JsonProperty("products")
    List <QuantityOfProduct> products; //key - productId, value - quantity
    @JsonProperty("__v")
    int v;

    public Cart(int id, int userId, Date date, ArrayList<Product> products, int v) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.v=v;
    }

    public Cart() {}

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", products=" + products +
                ", _v=" + v +
                '}';
    }

    public int getId() {
        return id;
    }

    public List<QuantityOfProduct> getProducts() {
        return products;
    }

    public User findOwnerOfCart(){
        User owner = new User();
        for( User user : Task2.getUsers()){
            if(user.getId()==this.userId) owner=user;
        }
        return owner;
    }

}
