package location;

public class Request {
    // si estoy buscando un producto en concreto.
    private int id;
    //  Necesita saber el tipo de metodo [GET, POST, PUT, DELETE...].
    private String httpMethod;
    // Si quiero actualizar uno nuevo;
    private Location location;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHttpMethod() {
        return httpMethod;
    }
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
}
