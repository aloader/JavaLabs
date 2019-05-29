import streams1.*;

import java.io.IOException;

public class StreamsDemo1 {
    public static void main(String[] args) {

        new task01_StreamFromArrayList();
        new task02_StreamFromEnum();
        new task03_StreamFromArray();

        try {
            new task04_StreamFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new task05_StreamFromString();
        new task06_ParallelStream();

        new task07_SquaringX();
        new task08_Fibonachchi();

    }
}
