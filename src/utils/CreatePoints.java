package utils;

import java.util.ArrayList;

// create arraylist for stream3/tasks14
public class CreatePoints {
    public static ArrayList<Point> createPointsArrayList() {
        ArrayList<Point> listOfPoints = new ArrayList<Point>();
        listOfPoints.add(new Point(0.1, 0.1));
        listOfPoints.add(new Point(-0.1, 0.2));
        listOfPoints.add(new Point(3.5, 4.1));
        listOfPoints.add(new Point(1.1, 0.8));
        listOfPoints.add(new Point(-3.2, -2.1));
        listOfPoints.add(new Point(4.4, -2.6));
        return listOfPoints;
    }
}

