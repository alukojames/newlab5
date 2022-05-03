package Data;

import java.time.LocalDateTime;

public class Route {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    private LocationFro from;
    private LocationTo to;
    private int distance;

    public Route(int id, String name, Coordinates coordinates, LocalDateTime creationDate, LocationFro from, LocationTo to, int distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Route() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocationFro getFrom() {
        return from;
    }

    public void setFrom(LocationFro from) {
        this.from = from;
    }

    public LocationTo getTo() {
        return to;
    }

    public void setTo(LocationTo to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String toString(){
        String detail = ("ID: " + id + '\n');
        detail+=        ("Name: " + name + '\n');
        detail+=        ("Coordinates: " + coordinates.getX() + " " + coordinates.getY() + '\n');
        detail+=        ("Departure: " + creationDate.toString() + '\n');
        detail+=        ("distance: " + distance +'\n');

        return detail;
    }

    public double compareTo(Object o) {
        Route product = (Route) o;
        return (getDistance() - product.getDistance());
    }
}
