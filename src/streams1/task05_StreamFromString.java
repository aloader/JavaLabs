/*
 Создание стрима из строки
 Пример входа               Пример выхода
 “A string”                 [“A”,” ”,”s”,”t”,”r”,”i”,”n”,”g”]
*/
package streams1;

import utils.LabAnnotation;
import utils.task;

@LabAnnotation(
        number = "05",
        text = "Создание стрима из строки.")
public class task05_StreamFromString extends task {
    public task05_StreamFromString() {

        String str= "A string";
        System.out.println("string: \""+str +"\"");
        str.chars()
                .forEach((x)->{
                    System.out.print("\"" + (char)x + "\",");
                });
        System.out.println();
    }

}
