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
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Base64;

import static utils.Constants.BUFFERSIZE;
import static utils.Constants.PORTPIC;

public class task23_24_Client {

    private PrintWriter sout;
    private BufferedReader sin;
    private Socket socket;

    public task23_24_Client() {

//        String fname = "./res/send/java_logo.jpg";
        String fname = "./res/text_cp1251.txt";
        Path fpath = Paths.get(fname);
        System.out.println("transfer to the server file \""+fname +"\" in Base64 encoding.");
        System.out.println("default charset: " +Charset.defaultCharset());
        try (Socket socket = new Socket("localhost", PORTPIC)) {
            byte[] buffer = new byte[BUFFERSIZE];
            try (InputStream fis = Files.newInputStream(fpath, StandardOpenOption.READ);
                 PrintWriter sout = new PrintWriter(socket.getOutputStream());
                 BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("connected to server: " + socket.getLocalSocketAddress());
                // 1. send filename
                sendMessage(fpath.getFileName().toString(), sout, sin);
                // 2. send filesize
                Long fsize = Files.size(fpath);
                sendMessage(Long.toString(fsize), sout, sin);
                System.out.println("sending file " + fpath.getFileName() + ", size "+fsize+" bytes.");
                // 3. send file
                int len=0;
                String msg;
                while ((len=fis.read(buffer))!=-1) {
                    msg = Base64.getEncoder().encodeToString(Arrays.copyOf(buffer,len));
                    sendMessage(msg, sout, sin);
                }
                // finally
                System.out.println("end of sending.");
                sendMessage("END", sout, sin);
            }
        } catch (UnknownHostException e) {
            System.out.println("can't resolve localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean sendMessage(String msg, PrintWriter out, BufferedReader in) throws IOException {
        String answer;

        out.println(msg);
        out.flush();
        answer = in.readLine();
        if (answer.equalsIgnoreCase("OK")) return true;
            else return false;
    }
}
