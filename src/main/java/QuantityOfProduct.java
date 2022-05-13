import com.fasterxml.jackson.annotation.JsonProperty;

public class QuantityOfProduct {
    @JsonProperty("productId")
    int productId;
    @JsonProperty("quantity")
    int quantity;

    public QuantityOfProduct(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public QuantityOfProduct(){}

    @Override
    public String toString() {
        return "QuantityOfProduct{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public double getPriceOfProduct(){
        double price =0;
        for( Product p :  Task2.getProducts()){
            if(p.getId()==this.productId) price=p.getPrice();
        }
        return price;
    }

}
