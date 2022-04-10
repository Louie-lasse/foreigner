import java.awt.*;

public class Wastebin {
    private double fullness;
    private Coord coordinates = new Coord(0, 0);

    public Wastebin(double longitude, double latitude, double fullness) {
        setFullness(fullness);
        setCoordinates(longitude, latitude);
    }

    public double getFullness() {
        double temp;
        temp = fullness;
        return temp;
    }

    public void setFullness(double fullness) {
        if (fullness > 0 && fullness < 1) {
            this.fullness = fullness;
        }
    }

    public Coord getCoordinates() {
        Coord temp;
        temp = coordinates;
        return temp;
    }

    public void setCoordinates(double longitude, double latitude) {
        coordinates.setX(longitude);
        coordinates.setY(latitude);
    }
}
