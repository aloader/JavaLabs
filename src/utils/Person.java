package utils;

import java.time.LocalDateTime;

// class for lab "streams2/task02_FilerArrayOfObjects", "streams2/task03_TwoFiltersArrayOfObjects"
public class Person {
    public String firstName;
    public String lastName;
    public LocalDateTime createdAt;
    public boolean logged;

    public <createdAt> Person() {
        firstName = "";
        lastName = "";
        createdAt.now();
        logged = false;
    }

    public Person(String fName, String lName, LocalDateTime crAt, boolean log) {
        firstName = fName;
        lastName = lName;
        if (crAt !=null) createdAt = crAt;
            else createdAt = createdAt.now();
        logged = log;
    }

    /*
    public void setLogged(boolean logPerson) {
        logged = logPerson;
    };

    public boolean getLogged() {
        return logged;
    }
    */

    @Override
    public String toString() {
        return "{\n" +
                "firstName:\""+firstName + "\", " +
                "\n" +
                "lastName:\""+lastName + "\", " +
                "\n" +
                "createdAt:\""+ createdAt.toLocalDate() + " " +createdAt.toLocalTime()+"\", " +
                "\n" +
                "logged:\"" + logged + "\"" +
                "\n}";
    }
}
