import java.awt.*;

public class Wastebin {
    private double fullness;
    private Point coordinates = new Point(0, 0);

    public Wastebin(int longitude, int latitude, double fullness) {
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

    public Point getCoordinates() {
        Point temp;
        temp = coordinates;
        return temp;
    }

    public void setCoordinates(int longitude, int latitude) {
        coordinates.x = longitude;
        coordinates.y = latitude;
    }
}
