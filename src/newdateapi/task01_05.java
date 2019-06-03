/*
Вернуть текущую дату с временем
 */
package newdateapi;
import utils.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@LabAnnotation(
        number = "01-05",
        text = "1.Вернуть текущую дату с временем.\n" +
                "2.Вернуть текущее время\n" +
                "3.Вернуть текущую дату\n" +
                "4.Вернуть текущую дату с временем, изменить месяц на февраль, год на 2012.\n"+
                "5.Создать дату 23 Марта 1974 года. Посчитать сколько дней назад это было")
public class task01_05 extends task {
    public task01_05() {
        super();

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("1. current date+time: " + dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("2. current time: " + dt.format(DateTimeFormatter.ISO_TIME));
        System.out.println("3. current date: " + dt.format(DateTimeFormatter.ISO_DATE));
        System.out.println("3-1. current date, my format (YYYY:MM:DD): " + dt.format(DateTimeFormatter.ofPattern("yyyy:MM:dd")));

        dt = LocalDateTime.of(LocalDate.of(2012,02,dt.getDayOfMonth()), dt.toLocalTime());
        System.out.println("4. change year to 2012, month to 02: "+dt);

        LocalDate d = LocalDate.of(1974, 3, 23);
        LocalDate dn = LocalDate.now();
        System.out.println("5. days between now (" + dn + ") and 23.03.1974: " + DAYS.between(d, dn));

    }
}
