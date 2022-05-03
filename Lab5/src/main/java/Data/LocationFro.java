package Data;

public class LocationFro {
    private float x;
    private int y;
    private int z;

    public LocationFro(float x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public LocationFro() {

    }

    public float getX() {
        return x;
    }
    public void setX(Float x){
        this.x=x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z){
        this.z = z;
    }

    public String toString(){
        String from = ("            X: "+ x + '\n');
        from+=        ("            Y: "+ y + '\n');
        from+=        ("            Z: "+ z + '\n');
        return from;
    }
}
