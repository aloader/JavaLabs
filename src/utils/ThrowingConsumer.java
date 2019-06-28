package utils;

// Consumer can throw exception
public interface ThrowingConsumer <T, E extends Exception>{
    void accept(T t) throws E;
}
