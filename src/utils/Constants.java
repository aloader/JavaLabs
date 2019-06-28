package utils;

public class Constants {

    // patterns for file name
    static public final String DOT = ".";
    static public final String OUTDATED = "_outdated";

    // for string id
    static public final String UNDERLINE = "_";

    // for stream2/task19_StringArrayWithColon
    static public final String COLON = ":";

    static public final String WORDSPLITTER = "[\\s\\p{Punct}]";

    static public final String ENTER = "\r\n";

    static public final int BUFFERSIZE = 1024;

    public static final int PORTTZ = 2125;

    public static final int PORTPIC = 2126;

    // waiting for connection timeout in milliseconds
    public static final int CONNECTIONTIMEOUT = 2000;

    // messages in ServerTZ
    public static final String ACKMESSAGE = "OK";
    public static final String STOPMESSAGE = "STOP";

    // error codes in ServerTZ
    public static final int NOERROR = 0;
    public static final int SOCKETTIMEOUTERROR = 1;
    public static final int IORESULTERROR = 2;
    public static final int NOACKRECEIVED = 0;

}
