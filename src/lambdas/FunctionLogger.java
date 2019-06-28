package lambdas;

import java.util.function.Consumer;
import java.util.function.Function;

//f10.intercept(x -> x + 1, System.send::println).apply(10)          Before 10

@FunctionalInterface
public interface FunctionLogger<T, R> {
    R apply(T t);

    default Function<T, R> intercept(Function<T, R> f, Consumer<String> lf) {

        return (T t)->{
            R r;
            lf.accept("Before: " + t);
            r = f.apply(t);
            lf.accept("After: " + r);
            return r;
        };
    };
}
