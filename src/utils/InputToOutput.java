package utils;

import java.io.*;

import static utils.Constants.BUFFERSIZE;

public class InputToOutput {

    static public long iStream2oStream(InputStream bais, OutputStream baos) throws IOException {
        if ((bais==null) || (baos==null)) {
            return 0;
        }
        byte[] buffer = new byte[BUFFERSIZE];
        int len=0;
        long bcnt=0;
        while ((len=bais.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
            baos.flush();
            bcnt += len;
        }
        return bcnt;
    }

}
