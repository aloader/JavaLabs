/*
Создать время из строки
Пример входа                            Пример выхода
“20:15:30”                              20:15:30 as LocalDate

Создать ZonedDateTime из строки в формате ISO 8601
Пример входа                            Пример выхода
2007-12-03T10:15:30+03:00               2007-12-03T10:15:30+03:00 as ZonedDateTime

 */
package newdateapi;
import utils.*;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@LabAnnotation(
        number = "06-10",
        text = "6.Создать время из строки.\n" +
                "7.Создать ZonedDateTime из строки в формате ISO 8601\n"+
                "8.Получить строку в формате ISO 8601 для текущей даты и времени для региона UTC\n"+
                "9.Получить строку в формате ISO 8601 для текущей даты и времени для региона Europe/Minsk.\n"+
                "10.Добавить к текущей дате для региона UTC одну декаду.")
public class task06_10 extends task {
    public task06_10() {
        super();

        String timeStr = "12:45:30";
        LocalTime lt = LocalTime.parse(timeStr);
        System.out.println("6. parsing time from \""+timeStr+"\" string, result: " + lt + " as LocalTime.");

        String timeStrZoned = "2007-12-03T10:15:30+03:00";
        ZonedDateTime zdt = ZonedDateTime.parse(timeStrZoned);
        System.out.println("7. ZonedDateTime from the string \""+timeStrZoned+"\", result: "+ zdt + " as ZonedDateTime.");

        String zoneId = "UTC";
        zdt = ZonedDateTime.now(ZoneId.of(zoneId));
        System.out.println("8. current date and time in \""+zoneId+"\" time zone: "+ zdt);

        zoneId = ZoneId.systemDefault().toString();
        zdt = ZonedDateTime.now(ZoneId.of(zoneId));
        System.out.println("9. current date and time in \""+zoneId+"\" time zone: "+ zdt);

        //Добавить к текущей дате для региона UTC одну декаду
        zoneId = "UTC";
        zdt = ZonedDateTime.now(ZoneId.of(zoneId)).plusDays(10);
        System.out.println("10. current date and time in \""+zoneId+"\" time zone, plus 10 days: "+ zdt);

    }
}
