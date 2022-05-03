package Data;

public class LocationTo {
    private Long x;
    private long y;
    private Float z;
    private String name;

    public LocationTo(Long x, long y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public LocationTo() {

    }

    public Long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Float getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setZ(Float z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        String to = ("         fromX: "+ x + '\n');
        to+=        ("         fromY: "+ y + '\n');
        to+=        ("         fromZ: "+ z + '\n');
        return to;
    }
}
