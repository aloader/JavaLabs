package lambdas;

import java.util.Objects;
import java.util.function.Function;

// f.compose(x->x*2,x->x-1).apply(10))

// T - function argument
// R - function return
// V -
@FunctionalInterface
public interface BiFuncCompose<T, R extends Number> {

    R apply(T t);

    default <V> Function<T,R> compose(Function<T, V> f1, Function<V, R> f2) {
        return (T t)-> f2.apply(f1.apply(t));
    };

}
