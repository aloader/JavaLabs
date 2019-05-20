package utils;

import java.time.LocalDate;

import static utils.Constants.*;

// class for streams2/task08_AddOutdated

public class FileAttrs {
    public String name;
    public LocalDate date;

    public FileAttrs(String nm, LocalDate dt) {
        name = nm;
        date = dt;
    }

    // get file name
    public String getFileName() {
        int dot = name.indexOf(DOT);
        return (dot == -1) ? name : name.substring(0, dot);

    };

    // get file extension
    public String getFileExtension() {
        int dot = name.lastIndexOf(DOT);
        return (dot == -1) ? "" : name.substring(dot+1);
    };

    @Override
    public String toString() {
        return "{\nname:\"" + name + "\",\ndate:" + "\""+date+"\"\n}";
    }
}
