/*
Преобразовать BufferedInputStream в BufferedOutputStream и обратно
 */
package nioapi;
import utils.*;

import java.io.*;

import static utils.Constants.BUFFERSIZE;

@LabAnnotation(
        number = "15",
        text = "Преобразовать BufferedInputStream в BufferedOutputStream и обратно.")
public class task15_BufferedInputStreamToBufferedOutputStream extends task {
    public task15_BufferedInputStreamToBufferedOutputStream() {
        super();

        String text = "This parameter of DWORD type decreases the priority of the corresponding\n" +
                "fmt-module in the  process  of  selecting  the  appropriate  module  for\n" +
                "handling the archive.";

        try (BufferedInputStream bis1 = new BufferedInputStream(new ByteArrayInputStream(text.getBytes()));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(baos);) {

            byte[] buffer = new byte[BUFFERSIZE];
            int len=0;
            while ((len=bis1.read(buffer))!= -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
            BufferedInputStream bis2 = new BufferedInputStream(new ByteArrayInputStream(baos.toByteArray()));
            System.out.println(" " + bis2.toString());

        } catch (IOException e) {
            System.out.println("error!");
            e.printStackTrace();
        }
    }
}
