package lambdas;

import java.util.function.Consumer;

@FunctionalInterface
public interface MySupplier<T> {
    T get();
    default void apply(Consumer<Long> c) {
    }
}
