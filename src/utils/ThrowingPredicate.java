package utils;

public interface ThrowingPredicate<T, E extends Exception> {
    public boolean test (T var1) throws E;
}
