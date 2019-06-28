/*
Преобразовать ByteArrayInputStream в ByteArrayOutputStream и обратно
 */
package nioapi;
import utils.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static utils.Constants.BUFFERSIZE;

@LabAnnotation(
        number = "14",
        text = "Преобразовать ByteArrayInputStream в ByteArrayOutputStream и обратно")
public class task14_ByteArrayInputStreamToByteArrayOutputStream extends task {
    public task14_ByteArrayInputStreamToByteArrayOutputStream() {
        super();

        String text = "This parameter of DWORD type decreases the priority of the corresponding\n" +
                "fmt-module in the  process  of  selecting  the  appropriate  module  for\n" +
                "handling the archive.";
        byte[] byteArray = text.getBytes();
        ByteArrayInputStream bais1 = new ByteArrayInputStream(byteArray);
        ByteArrayInputStream bais2 = null;

        System.out.println("ByteArrayInputStream (input): " + bais1.toString());

        try {
            bais2 = byteArrayOutputStream2InputStream(byteArrayInputStream2OutputStream(bais1));
            System.out.println("ByteArrayInputStream (output): " + bais2.toString());
        } catch (IOException e) {
            System.out.println("IO error!");
            e.printStackTrace();
        }

    }

    public ByteArrayOutputStream byteArrayInputStream2OutputStream(ByteArrayInputStream bais) throws IOException {
        if (bais==null) {
            return null;
        }
        byte[] buffer = new byte[BUFFERSIZE];
        int len=0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFFERSIZE);
        while ((len=bais.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        return baos;
    }

    public ByteArrayInputStream byteArrayOutputStream2InputStream(ByteArrayOutputStream baos) throws IOException {
        if (baos==null) {
            return null;
        }
        return new ByteArrayInputStream(baos.toByteArray());
    }
}
