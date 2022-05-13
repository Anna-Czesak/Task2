import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    @JsonProperty("rate")
    double rate;
    @JsonProperty("count")
    int count;

    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public Rating() {}

    public double getRate() {
        return rate;
    }

    public int getCount() {
        return count;
    }

}
