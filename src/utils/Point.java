package utils;

public class Point {
    public double X;
    public double Y;

    public Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    // get distance between two points
    public double getDistanceWith(Point p) {
        return Math.sqrt((p.X - this.X)*(p.X - this.X) + (p.X - this.Y)*(p.X - this.Y));
    };

    @Override
    public String toString() {
        return "{X="+this.X+", Y="+this.Y+"}";
    }
}
