/*
Использовать DataInputStream для записи примитивов в файл.
Прочитать с использованием DataOutputStream
 */
package nioapi;
import utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

@LabAnnotation(
        number = "17",
        text = "Использовать DataInputStream для записи примитивов в файл. \n" +
                "Прочитать с использованием DataOutputStream")
public class task17_SaveAndReadWithDataOutPutStreamDataInputStream extends task {
    public task17_SaveAndReadWithDataOutPutStreamDataInputStream() {
        super();

        String fileOut = "./res/nio_task17.bin";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            System.out.println("writing to \""+fileOut + "\":");
            Stream.generate(()->Math.random())
                    .limit(7)
                    .forEach(d->{
                        System.out.println(d +"->");
                        try {
                            dataOutputStream.writeDouble(d);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        } catch (IOException | UncheckedIOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileOut);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            System.out.println("\nreading from \""+fileOut+"\"");
            ArrayList<Double> doubleArr = new ArrayList<>();
            double d;
            while (dataInputStream.available()>0) {
                d = dataInputStream.readDouble();
                System.out.println("->"+d);
                doubleArr.add(d);
            }
            System.out.println("result ArrayList: "+doubleArr);
        } catch(IOException | UncheckedIOException e) {
            e.printStackTrace();
        }

    }
}
