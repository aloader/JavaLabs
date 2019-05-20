package utils;

import java.time.LocalDate;

// class for streams2/task14_ObjectsSortWithComparator

public class ClassT14 {
    public long Id = 0;
    public String Name = "";
    public LocalDate Date;

    public ClassT14(long tId, String tName, LocalDate tDate) {
        Id = tId;
        Name = tName;
        Date = tDate;
    }

    @Override
    public String toString() {
        return "{" +
                "Id: " + Id + ", " +
                "Name: " + Name + ", " +
                "Date: " + Date + "" +
                "}\n";
    }
}
