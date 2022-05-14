import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {
    @JsonProperty("lat")
    float lat;
    @JsonProperty("longg")
    float longg;


    @JsonCreator
    public Geolocation(float lat,float longg) {
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

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLongg(float longg) {
        this.longg = longg;
    }
}
