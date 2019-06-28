/*
23. Откройте картинку как бинарный файл, переведите ее в Base64. Отправьте по сокету.
Раскодируйте из Base64 и сохраните на диск. Убедитесь, что картинка не повреждена.

24. В предыдущем задании вместо сокета отправьте данные коллеге, у которого кодировка
по умолчанию отличается от вашей (например, между Windows-Linux машинами). Для передачи
данных используйте любой способ (через сокет, через файл, через строку).

Запускать клиент и сервер на одном компьютере, в разных процессах
task23_24_Server - сервер. ждет от клиента файл, принимает его и записывает на диск. Передача происходит через
                   сокет, файл передается с использованием кодировки Base64, блоками по 1024 kb.
                   Размер файла, формат - произвольные. После окончания приема сервер завершает работу.
task23_24_Client - клиент. Передает на сервер файл.

Имя и расположения файла задаются в тексте программы переменной fname.

Тестовые файлы:
  ./res/send/java_logo.jpg      (изображение)
  ./res/send/text_cp1251.txt    (текст в кодировке win-1251)

На сервере при запуске JVM была кодировка по умолчанию UTF-8 (-Dfile.encoding=UTF-8),
на клиенте - Windows-1251 (-Dfile.encoding=windows-1251)

 */
package nioapi;

import utils.InputToOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import static utils.Constants.PORTPIC;

public class task23_24_Server {
    private OutputStream fout = null;
    private PrintWriter sout = null;
    private BufferedReader sin = null;

    public task23_24_Server() {

        String dir = "./res/receive";

        System.out.println("dir to receive files: \""+dir+"\".");
        System.out.println("default charset: " + Charset.defaultCharset());
        try (ServerSocket server = new ServerSocket(PORTPIC)) {
            System.out.println("waiting connection...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("client connected: "+socket.getLocalSocketAddress());
                try {
                    sout = new PrintWriter(socket.getOutputStream());
                    sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // 1. get file name
                    String fname = receiveMessage();
                    Path fpath = Paths.get(dir, fname);
                    fout = Files.newOutputStream(fpath, StandardOpenOption.CREATE);
                    // 2. get file size
                    long fsize = Long.valueOf(receiveMessage());
                    System.out.println("receiving file: " + fpath.getFileName() + ", size is " + fsize + " bytes");
                    // 3. receive file content
                    long breceived = 0;
                    String msg;
                    byte[] buffer=null;
                    while (breceived<fsize) {
                        buffer = Base64.getDecoder().decode(receiveMessage());
                        breceived += buffer.length;
                        fout.write(buffer);
                        sout.println("OK");
                        sout.flush();
                    }
                    System.out.println("transferred: "+breceived + " bytes.");
                    // finally: END
                    System.out.println("client says: "+receiveMessage());
                } finally {
                    if (fout != null) fout.close();
                    if (sout != null) sout.close();
                    if (sin != null) sin.close();
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String receiveMessage() throws IOException {
        String msg;
        msg = sin.readLine();
        sout.println("OK");
        sout.flush();
        return msg;
    }
}
