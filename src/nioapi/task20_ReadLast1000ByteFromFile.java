/*
Считать последние 1000 символов из файла
 */
package nioapi;
import utils.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.Constants.BUFFERSIZE;

@LabAnnotation(
        number = "20",
        text = "Считать последние 1000 символов из файла")
public class task20_ReadLast1000ByteFromFile extends task {
    public task20_ReadLast1000ByteFromFile() {
        super();

        Path p = Paths.get("./res/payload/java8/stream/", "file_id.diz");
        System.out.println("read 1000 byte from the end of the file \""+p.toString()+"\"");
        try (RandomAccessFile raf = new RandomAccessFile(p.toString(), "rw")) {
            long pos = raf.length();
            System.out.println("file lenght: " + pos + " bytes.");
            pos = pos>1000? pos-1000: 0;
            raf.seek(pos);
            System.out.println("read from " + pos + " position.");
            byte[] buffer = new byte[BUFFERSIZE];
            int readbytes = raf.read(buffer);
            String outstr = new String(buffer);
            System.out.println("have read "+ readbytes + " bytes: \n" + outstr);
            System.out.println("<<<< end of file.");

        } catch (FileNotFoundException e) {
            System.out.println("file error!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
            e.printStackTrace();
        }

    };
}

