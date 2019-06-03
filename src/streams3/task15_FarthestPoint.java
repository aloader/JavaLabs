/*
Дан массив точек (поля: x – float, y - float). Дана точка X с ненулевыми координатами.
Найти наиболее удаленную точку из массива к X.
 */
package streams3;
import utils.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import static utils.CreatePoints.createPointsArrayList;

@LabAnnotation(
        number = "15",
        text = "Дан массив точек (поля: x – float, y - float). Дана точка X с ненулевыми координатами. \n" +
                "Найти наиболее удаленную точку из массива к X.\n")
public class task15_FarthestPoint extends task {
    private ArrayList<Point> listOfPoints = new ArrayList<Point>();

    public task15_FarthestPoint() {
        super();
        listOfPoints = createPointsArrayList();
        System.out.println("\nList of points: \n" + listOfPoints);

        Point testPoint = new Point(0.5, 0.6);
        System.out.println("test point: " + testPoint);
        Optional<Point> nearestPoint = listOfPoints.stream()
                .max(Comparator.comparingDouble(p -> p.getDistanceWith(testPoint)));
        System.out.println("farthest point: " + nearestPoint.get() +
                ", distance: " + nearestPoint.get().getDistanceWith(testPoint));
    }

}

