/*
Получить Duration между текущей датой для регионов UTC и Europe/Minsk
Получить Duration между текущей датой для регионов UTC и GMT
Получить Period между текущей датой и вашим днем рождения (с годом)
Получить дату следующего четверга
Получить дату второй субботы текущего месяца текущего года
Преобразовать ZonedDateTime дял ващего региона в LocalDateTime для региона UTC.

 */
package newdateapi;
import utils.*;

import java.time.*;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.next;

@LabAnnotation(
        number = "11-16",
        text = "11.Получить Duration между текущей датой для регионов UTC и Europe/Minsk\n" +
                "12.Получить Duration между текущей датой для регионов UTC и GMT\n" +
                "13.Получить Period между текущей датой и вашим днем рождения (с годом)\n" +
                "14.Получить дату следующего четверга\n" +
                "15.Получить дату второй субботы текущего месяца текущего года\n" +
                "16.Преобразовать ZonedDateTime для ващего региона в LocalDateTime для региона UTC.\n")
public class task11_16 extends task {
    public task11_16() {
        super();

        ZonedDateTime zdtMinsk = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        ZonedDateTime zdtUTC = ZonedDateTime.of(LocalDateTime.now(),ZoneId.of("UTC"));
        ZonedDateTime zdtGMT = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("GMT"));
        System.out.println("date and time in Europe/Minsk: " + zdtMinsk);
        System.out.println("date and time in UTC: " + zdtUTC);
        System.out.println("date and time in GMT: " + zdtGMT);

        Duration d = Duration.between(zdtMinsk, zdtUTC);
        System.out.println("11. duration between Europe/Minsk and UTC: " + d +
                " - " + d.toHours() + " hours, or " + d.toMinutes()+" minuts");

        d = Duration.between(zdtUTC, zdtGMT);
        System.out.println("12. duration between UTC and GMT: " + d +
                " - " + d.toHours() + " hours, or " + d.toMinutes()+" minuts");

        LocalDate myBirthday = LocalDate.of(1905, 04, 01);
        Period p = Period.between(myBirthday, LocalDate.now());
        System.out.println("13. period between my birthday \""+myBirthday+"\" and now: " + p);

        LocalDate currDate = LocalDate.now();
        TemporalAdjuster nextThursday = next(DayOfWeek.THURSDAY);
        System.out.println("14. date of next Thursday: " + currDate.with(nextThursday));

        TemporalAdjuster secondSaturdate =
                TemporalAdjusters.ofDateAdjuster(date -> date.with(firstInMonth(DayOfWeek.SATURDAY)).plusDays(7));
        System.out.println("15. second Saturday in current month: " + currDate.with(secondSaturdate));

        //"Преобразовать ZonedDateTime для ващего региона в LocalDateTime для региона UTC.\n")
        LocalDateTime ldtForUTC = ZonedDateTime.ofInstant(zdtMinsk.toInstant(), ZoneId.of("UTC")).toLocalDateTime();
        System.out.println("16. current ZonedDateTime: "+ zdtMinsk + ", LocalDateTime for UTC: " + ldtForUTC);
    }
}
