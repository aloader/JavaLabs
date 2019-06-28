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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import static utils.Constants.*;

public class task21_ServerTZ {
    private Set<String> timeZonesIdSet;
    private int errorCode;
    private ServerSocket server;
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String lastQuery;
    private boolean shutdown = false;

    public task21_ServerTZ() {

        timeZonesIdSet = ZoneId.getAvailableZoneIds();
        errorCode = 0;
        lastQuery = "";

        try (ServerSocket server = new ServerSocket(PORTTZ)) {
            System.out.println("server TZ is running.");
            while (!shutdown) {
                System.out.println("waiting for connection...");
                socket = server.accept();
                System.out.println("client " + socket.getRemoteSocketAddress() + " connected.");

                try {
//                    socket.setSoTimeout(CONNECTIONTIMEOUT);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String msg;
                    ZoneId zoneId = null;
                    while (!shutdown) {
                        //msg = in.readLine();
                        msg = readMessage();
                        System.out.println("recived: " + msg);
                        if (isStopCommand(msg)) {
                            shutdown = true;
                            break;
                        }
                        if (checkTZname(msg)) {
                            // code
                            sendMessage("current time in TZ \"" + msg + "\": " + ZonedDateTime.now(ZoneId.of(msg)));
                        } else {
                            sendMessage("TZ \""+msg+"\" not found. Known TZs: " + timeZonesIdSet.toString());
                        }
                    }
                } catch (SocketException e) {
                    System.out.println("socket timeout error. connection terminated.");
                } catch (IOException e) {
                    System.out.println("port input/output error! connection terminated.");
                    e.printStackTrace();
                } finally {
                    System.out.println("close resources.");
                    if (in != null) in.close();
                    if (out != null) out.close();
                }
            }
        } catch (IOException e) {
            System.out.println("error socket creation!");
            e.printStackTrace();
        }
        System.out.println("server TZ shutdown.");
    }

    // return true if we recieved stop command
    private boolean isStopCommand(String query) {
        return query.indexOf(STOPMESSAGE)>=0;
    }

    private String readMessage() {
        String msg;
        try {
            msg = in.readLine();
            errorCode = NOERROR;
        } catch (SocketException e) {
            msg = "";
            errorCode = SOCKETTIMEOUTERROR;
        } catch (IOException e) {
            msg = "";
            errorCode = IORESULTERROR;
        }
//        if (!sendMessage(ACKMESSAGE)) {
//            errorCode = NOACKRECEIVED;
//        }
        out.println(ACKMESSAGE);
        out.flush();
        return msg;
    }

    private boolean checkTZname(String tzname) {
        if (timeZonesIdSet!=null && !tzname.isEmpty())
            return timeZonesIdSet.contains(tzname);
        else
            return false;
    }

    private boolean sendMessage(String msg) {
        String response=null;
        if (!msg.isEmpty()) {
            out.println(msg);
            out.flush();
            try {
                response = in.readLine();
            } catch (SocketException e) {

            } catch (IOException e) {

            }
            return true;
        } else
            return false;
    }
}
