import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {
    @JsonProperty("lat")
    float lat;
    @JsonProperty("long")
    float longg;

    public Geolocation(float lat, float longg) {
        this.lat = lat;
        this.longg = longg;
    }
    public Geolocation(){}

    @Override
    public String toString() {
        return "Geolocation{" +
                "lat=" + lat +
                ", long=" + longg +
                '}';
    }

    public float getLat() {
        return lat;
    }

    public float getLongg() {
        return longg;
    }

}
