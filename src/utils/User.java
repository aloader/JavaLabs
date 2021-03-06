package utils;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    public Long id;
    public String name;
    public LocalDate date;

    public User(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "{\n"+
                "id:"+id+", \n" +
                "name:"+name+", \n"+
                "date:"+date+"\n" +
                "}";
    }
}
