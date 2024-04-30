package location;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "location")
public class Location {
    @DynamoDBHashKey
    private int id;
    @DynamoDBAttribute
    private float lat;
    @DynamoDBAttribute
    private float lng;
    @DynamoDBAttribute
    private String title;
    @DynamoDBAttribute
    private String direccion;
    @DynamoDBAttribute
    private String liderazgo;
    @DynamoDBAttribute
    private String movil;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private String webpage;

    public Location() {
    }

    public Location(int id, float lat, float lng, String title, String direccion, String liderazgo,
            String movil, String email, String webpage) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.title = title;
        this.direccion = direccion;
        this.liderazgo = liderazgo;
        this.movil = movil;
        this.email = email;
        this.webpage = webpage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(String liderazgo) {
        this.liderazgo = liderazgo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ", \"lat\":" + lat + ", \"lng\":" + lng + ", \"title\":\"" + title + "\", \"direccion\":\"" + direccion
                + "\", \"liderazgo\":\"" + liderazgo + "\", \"movil\":\"" + movil + "\", \"email\":\"" + email + "\", \"webpage\":\"" + webpage + "\"}";
    }

}