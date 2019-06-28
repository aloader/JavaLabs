/*
Используя сокет реализовать сервер, который принимает на вход TimeZone,
а возвращает текущее время в заданной TimeZone.
Реализовать клиента, который будет отправлять свою либо случайную TimeZone на сервер.

Запускать клиент и сервер на одном компьютере, в разных процессах
task21_ServerTZ - отвечает на запрос клиента о текущем времени для определенной в запросе таймзоны. По
                  команде STOP завершает работу.
task21_ClientTZ - клиент. Спрашивает у сервера несколько таймзон, в том числе несуществующую, выводит
                  полученные ответы и затем отправляет команду для остановки сервера.

 */
package nioapi;
import utils.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

import static utils.Constants.*;

@LabAnnotation(
        number = "21",
        text = "")
public class task21_ClientTZ {
    private String lastResponse;
    private String lastQuery;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Socket socket = null;

    public task21_ClientTZ() {
        lastResponse = "";

        socket = new Socket();
        try {
//            socket.setSoTimeout(CONNECTIONTIMEOUT);
            socket.connect(new InetSocketAddress("localhost", PORTTZ));
            System.out.println("connected to the server " + socket.getRemoteSocketAddress());
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                sendTZquery("GMT");
                if (getResponse(in)) {
                    System.out.println("server response: " + lastResponse);
                }
                sendTZquery("Africa/Nairobi");
                if (getResponse(in)) {
                    System.out.println("server response: " + lastResponse);
                }
                sendTZquery("abracadabra");
                if (getResponse(in)) {
                    System.out.println("server response: " + lastResponse);
                }
                sendTZquery("Europe/London");
                if (getResponse(in)) {
                    System.out.println("server response: " + lastResponse);
                }
                sendTZquery("STOP");
                if (getResponse(in)) {
                    System.out.println("server response: " + lastResponse);
                }
                break;
            }
            System.out.println("Clent TZ stopped.");
        } catch (SocketException e) {
            System.out.println("error connection to the server.");
        } catch (IOException e) {
            System.out.println("Error opening socket!");
            e.printStackTrace();
        } finally {
            if (socket!=null) {
                try {
                socket.close();
                } catch (IOException e) {
                    System.out.println("connection closing error.");
                }
            }
        }
    }


    private void sendTZquery(String tz) {
        String response;
        if (tz.isEmpty()) {
            lastQuery = "";
        } else {
            lastQuery = tz;
            out.println(tz);
            out.flush();
        }
        try {
            response = in.readLine();
        } catch (SocketException e) {

        } catch (IOException e) {

        }
    }

    private boolean getResponse(BufferedReader in) {
        boolean res = false;
        try {
            lastResponse = in.readLine();
            res = true;
        } catch (SocketException e) {
            lastResponse = "";
        } catch (IOException e) {
            lastResponse = "";
        }
        out.println(ACKMESSAGE);
        out.flush();
        return res;
    }
}
