/*
Записать в массив последние две строки из файла
 */
package nioapi;
import utils.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static utils.Constants.ENTER;

@LabAnnotation(
        number = "11",
        text = "Записать в массив последние две строки из файла")
public class task11_Last2StrFromFile extends task {
    public task11_Last2StrFromFile() {
        super();
        Path filePath = Paths.get("./res", "2.txt");
        ArrayList<String> strArr = new ArrayList<>();
        final int BUFFLENGHT = 10;
        final int MATCHES = 2;

        try (SeekableByteChannel sbc = Files.newByteChannel(filePath)) {
            ByteBuffer bb = ByteBuffer.allocate(BUFFLENGHT);
            int readBytes=0;
            long pos = sbc.size()<=BUFFLENGHT? sbc.size(): sbc.size()-BUFFLENGHT;
            StringBuilder lastStrings = new StringBuilder();
            int cntMatches = 0;
            do {
                sbc.position(pos);
                readBytes = sbc.read(bb);
                bb.rewind();
                if (readBytes!=-1) {
                    lastStrings.insert(0, new String(bb.array()));
                }
                pos -= BUFFLENGHT;
                cntMatches = lastStrings.toString().split(ENTER).length;
            } while (readBytes!=-1 && pos>0 && cntMatches<MATCHES);
            String wStr = lastStrings.toString();
            strArr.addAll(Arrays.asList(wStr.split(ENTER)));
            if (wStr.endsWith(ENTER)) strArr.add("");
            if (strArr.size()>MATCHES) strArr.remove(0);
            System.out.println("Array from last "+ MATCHES + " strings of the file \""+ filePath.toString() +
                    "\": " + strArr);
        } catch (IOException e) {
            System.out.println("file read error!");
            e.printStackTrace();
        }
    }
}
