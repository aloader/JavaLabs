/*
19. Дано уравнение  .
Попытаться найти минимум и максимум на заданном диапазоне.
 */
package streams3;
import utils.*;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.DoubleStream.iterate;

@LabAnnotation(
        number = "19",
        text = "Дано уравнение. \n" +
                "Попытаться найти минимум и максимум на заданном диапазоне.")
public class task19_FindMinMax extends task {
    private double minF=0;
    private double maxF=0;
    public task19_FindMinMax() {
        super();

        double a = 1;           // left bound
        double b = 2;           // right bound
        long n = 100;           // number of intervals
        double h = (b-a)/n;     // step

        Function<Double, Double> f = x-> {
            return Math.pow(x, Math.exp(x)) -
                    (3*Math.sqrt(2*Math.log(x))/x*x+Math.pow(5,x));
        };

        minF = f.apply(a);
        maxF = minF;

        Optional<Double> res = Stream.iterate(a, x->x+h)
                .limit(n)
                .map(x-> {
                    double fx = f.apply(x);
                    System.out.println("x="+x+", f(x)="+fx);
                    return fx;
                })
                .min((x1,x2)->{
                    maxF = Double.max(Double.max(x1, x2), maxF);
                    return x1.compareTo(x2);});

        if (res.isPresent()) minF= res.get();
        System.out.println("min value: " + minF);
        System.out.println("max value: " + maxF);
    }
}
