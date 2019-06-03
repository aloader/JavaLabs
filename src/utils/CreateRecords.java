package utils;

import java.util.ArrayList;

public class CreateRecords {
    public static ArrayList<Record> createRecordsArrayList() {
        ArrayList<Record> listOfRecords = new ArrayList<Record>();
        listOfRecords.add(new Record(1001, "Ivanov", true));
        listOfRecords.add(new Record(1002, "Alex", false));
        listOfRecords.add(new Record(1003, "Pavlov", true));
        listOfRecords.add(new Record(1004, "Harlampievich", false));
        listOfRecords.add(new Record(1005, "Petrov", false));
        listOfRecords.add(new Record(1006, "Ageev", false));
        listOfRecords.add(new Record(1007, "Antonov", true));
        listOfRecords.add(new Record(1008, "Alexseev", true));
        listOfRecords.add(new Record(1009, "Andreev", true));
        listOfRecords.add(new Record(1010, "Alibabaev", false));

        return listOfRecords;
    }
}
