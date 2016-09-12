package pharmacy.Models;

/**
 * Created by User on 12.09.2016.
 */
public class Point {
    private int lat;
    private int lng;

    public void setLatLng(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public int getLng() {
        return lng;
    }
}
