/*
Переведите текст из ANSII в UTF-8, затем ASCII, затем в кодировку по умолчанию
 */
package nioapi;
import utils.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@LabAnnotation(
        number = "22",
        text = "Переведите текст из ANSII в UTF-8, затем ASCII, затем в кодировку по умолчанию")
public class task22_ANSIIToUTF extends task {
    public task22_ANSIIToUTF() {
        super();

        String str_def = "Русский. Это строка для теста кодировок. " +
                "English. This is string to test encoding/decoding. ";
        Charset cs = Charset.defaultCharset();
        Charset cs_win1251 = Charset.forName("windows-1251");
        Charset cs_ascii = StandardCharsets.US_ASCII;


        System.out.println("Default charset: " + cs.displayName());
        System.out.println("String in default charset: \n" + str_def);

        System.out.println();
        String str_win1251 = new String(str_def.getBytes(cs_win1251), cs_win1251);
        System.out.println("Convert to \""+cs_win1251.displayName()+ "\" charset and back: \n" + str_win1251);

        System.out.println();
        String str_ascii = new String(str_def.getBytes(cs_win1251), cs_ascii);
        System.out.println("Convert to \"" + cs_ascii.displayName() + "\" charset and back: \n" + str_ascii);
        System.out.println("Can't see russian text :). In the US-ASCII only first half of chartable is supports.");

    }
}
