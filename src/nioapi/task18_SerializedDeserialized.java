/*
Использовать ObjectInputStream для сериализации.
Десериализовать серилизованный объект.
 */
package nioapi;
import com.sun.corba.se.pept.encoding.OutputObject;
import utils.*;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

@LabAnnotation(
        number = "18",
        text = "Использовать ObjectInputStream для сериализации. Десериализовать серилизованный объект.")
public class task18_SerializedDeserialized extends task {
    public task18_SerializedDeserialized() {
        super();

        ArrayList<User> userArr = new ArrayList<>();
        userArr.add(new User(1001L, "Ivanov", LocalDate.now()));
        userArr.add(new User(1002L, "Petrov", LocalDate.now().minusDays(1)));
        userArr.add(new User(1003L, "Sidorov", LocalDate.now().minusDays(5)));

        String fileName = "./res/nio_task18.bin";
        System.out.println("ArrayList<User> of objects:" + userArr +
                "\nserialize to the file \"" +fileName+ "\".");
        try (FileOutputStream fileOutputStream=new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(userArr);
        } catch (IOException e) {
            System.out.println("file write error!");
            e.printStackTrace();
        }
        System.out.println("delete object ArrayList<>");
        userArr.clear();
        userArr = null;
        try (FileInputStream fileInputStream=new FileInputStream(fileName);
                ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)) {
            userArr = (ArrayList<User>) objectInputStream.readObject();
            System.out.println("\ndeserialized object ArrayList<User>: " + userArr);
        } catch (IOException e) {
            System.out.println("file read error!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
            e.printStackTrace();
        }
    }
}
