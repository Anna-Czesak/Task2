import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {

    static ArrayList<Product> products;
    static ArrayList<Cart> carts;
    static ArrayList<User> users;

    public static ArrayList<User> readUsersFromJSON() {
        ArrayList<User> users = new ArrayList<>(); //list of users

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("users.json")) { //read file
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray jsonObject = (JSONArray) obj; //list of json objects

            for (Object o : jsonObject) { //each jsonobject
                JSONObject jsonUser = (JSONObject) o;
                User user = new Gson().fromJson(jsonUser.toString(), User.class);
                users.add(user);
                //System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Cart> readCartsFromJSON() {
        ArrayList<Cart> carts = new ArrayList<>(); //list of carts

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("carts.json")) { //read file
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray jsonObject = (JSONArray) obj; //list of json objects

            for (Object o : jsonObject) { //each jsonobject
                JSONObject jsonCart = (JSONObject) o;
                Cart cart = new Gson().fromJson(jsonCart.toString(), Cart.class);
                carts.add(cart);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return carts;
    }

    public static ArrayList<Product> readProductsJSON() {

        ArrayList<Product> products = new ArrayList<>(); //list of carts

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("products.json")) { //read file
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray jsonObject = (JSONArray) obj; //list of json objects

            for (Object o : jsonObject) { //each jsonobject
                JSONObject jsonCart = (JSONObject) o;
                Product product = new Gson().fromJson(jsonCart.toString(), Product.class);
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static HashMap<String, Integer> calculateAmountOfProductsInCategories() {
        HashMap<String, Integer> categories = new HashMap<String, Integer>(); //hashmap contains categories and amount of products of these categories

        for (Product p : products) {                                   //for each product i check if category exists in hashmap, if true - incrementing value - amount of product
            if (categories.containsKey(p.getCategory())) {
                categories.replace(p.getCategory(), categories.get(p.getCategory()) + 1); //incrementing old value
            } else {                    //if false I add new category (new key in hashmap) and set amount = 1
                categories.put(p.getCategory(), 1);
            }   //if hashMap contains category - increment amount of product
        }
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static Cart getCartById(int id) {
        Cart cart = new Cart();

        for (Cart c : carts) {
            if (c.getId() == id) cart = c;
        }
        return cart;
    }

    public static void findCartWithHighestValue() {
        HashMap<Integer, Double> valueOfCarts = new HashMap<>();

        for (Cart c : carts) { //for each cart summing prices of products and save in hashmap where key is id of cart and value price of cart
            double price = 0;
            for (QuantityOfProduct item : c.getProducts()) {
                price += item.quantity * item.getPriceOfProduct();
            }
            valueOfCarts.put(c.getId(), price);
        }

        double max = 0;
        Integer idMax = 0;

        for (Map.Entry<Integer, Double> entry : valueOfCarts.entrySet()) { //finding cart which has the highest value
            if (entry.getValue() >= max) {
                max = entry.getValue();
                idMax = entry.getKey();
            }
        }

        System.out.println("\nThe highest cart value: " + max);
        System.out.println("cart's owner: ");
        getCartById(idMax).findOwnerOfCart().showFullName(); //showing cart owner's full name
    }

    public static void findUsersLivingFurthestAwayFromEachOther() {

        double maxDistance = 0;
        User a = new User();
        User b = new User();

        for (User user : users) {
            for (User u : users) {
                if (user.calculateDistance(u) > maxDistance) { //if calculated distance is bigger than current - change the maxDistance
                    maxDistance = user.calculateDistance(u);
                    a = user;
                    b = u;
                }
            }
        }

        System.out.println("\nUsers living Furthest away from each other: ");
        a.showFullName();
        b.showFullName();
        System.out.println("\nDistance: " + maxDistance);
        System.out.println(a.getGeolocation());
        System.out.println(b.getGeolocation());
    }

    public static void main(String[] args) {
        //1.
        users = readUsersFromJSON();
        carts = readCartsFromJSON();
        products = readProductsJSON();

        //2.
        HashMap<String, Integer> categories = calculateAmountOfProductsInCategories();
        System.out.println(categories);

        //3.
        findCartWithHighestValue();

        //4.
        findUsersLivingFurthestAwayFromEachOther();
    }
}

