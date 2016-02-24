package s8.fr.esilv.td3.Stations;

/**
 * Created by juhel on 05/02/2016.
 */
public class Station {

    private String name;
    private String address;
    private int number;
    private double lat;
    private double lng;
    private String status;

    public Station(String name, String address, int lat, int lng, String status){
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }
}
