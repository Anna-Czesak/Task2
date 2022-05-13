import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("id")
    int id;
    @JsonProperty("title")
    String title;
    @JsonProperty("price")
    double price;
    @JsonProperty("description")
    String description;
    @JsonProperty("category")
    String category;
    @JsonProperty("image")
    String image;
    @JsonProperty("rating")
    Rating rating;

    public Product(int id, String title, double price, String description, String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" +" rate "+ rating.getRate() + " count " + rating.getCount()+
                '}';
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

}
