/*
2.2. Потоки ввода/вывода в Java

задания 21, 23-24 выполнены в виде двух частей - клиента и сервера. Каждая часть запускается в другом процессе

 */

import nioapi.*;
import utils.FileContentException;

public class NIODemo {
    public static void main(String[] args) {

        new task01_GetFilesLists();
        new task03_05_CheckFileDir();
        new task06_ReadFileToByteArray();
        new task07_ReadFileToStringArray();
        try {
            new task08_ExceptionInFileProceeding();
        } catch (FileContentException e) {
            e.printStackTrace();
        }
        new task09_AppendStrToTheEnd();
        new task10_First3StrFromFile();
        new task11_Last2StrFromFile();
        new task12_LongestWordInTheFile();
        new task13_MostUsedWordInTheFile();
        new task14_ByteArrayInputStreamToByteArrayOutputStream();
        new task15_BufferedInputStreamToBufferedOutputStream();
        new task16_UsePrintStreamToOutput();
        new task17_SaveAndReadWithDataOutPutStreamDataInputStream();
        new task18_SerializedDeserialized();
        new task19_ZipUnzipFile();
        new task20_ReadLast1000ByteFromFile();

//        new task21_ServerTZ();
//        new task21_ClientTZ();

        new task22_ANSIIToUTF();


        new task23_24_Server();
//        new task23_24_Client();
    }
}
