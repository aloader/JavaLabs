/*
Дан массив объектов (поля: id – Long, name - String, logged - Boolean).
Разделить по алфавиту. Если буква содержит менее 5 записей, объединить их
(например А-Г). Вернуть HashMap, где ключ: буква или диапазон,
значение: список пользователей, у которых имя лежит в заданном диапазоне
(или на заданную букву)
*/
package streams3;
import utils.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.CreateRecords.createRecordsArrayList;

@LabAnnotation(
        number = "25",
        text = "Дан массив объектов (поля: id – Long, name - String, logged - Boolean). \n" +
                "Разделить по алфавиту. Если буква содержит менее 5 записей, объединить их \n" +
                "(например А-Г). Вернуть HashMap, где ключ: буква или диапазон, \n" +
                "значение: список пользователей, у которых имя лежит в заданном диапазоне \n" +
                "(или на заданную букву)")
public class task25_ArrayOfObjectABCSort extends task {
    public task25_ArrayOfObjectABCSort() {
        super();

        ArrayList<Record> listOfRecords = new ArrayList<Record>();
        listOfRecords = createRecordsArrayList();
        System.out.println(listOfRecords);

        LinkedHashMap<String, List<Record>> recByABC = listOfRecords.stream()
                .sorted((r1,r2)->r1.getFirstLetter().compareTo(r2.getFirstLetter()))
                .collect(Collectors.groupingBy(Record::getFirstLetter, LinkedHashMap::new,
                        Collectors.toList()));
        //System.send.println("\n\nresult, logged==true: \n" + recByABC);

        ArrayList<Record> tmpList = new ArrayList<>();
        LinkedHashMap<String, List<Record>> recGeneral = (LinkedHashMap<String, List<Record>>) recByABC.entrySet().stream()
                .flatMap(s-> {
                    if (tmpList.size() == 0 & s.getValue().size() > 5) return Stream.of(s);

                    if (s.getValue().size() + tmpList.size() <= 5) {
                        tmpList.addAll(s.getValue());
                        return Stream.empty();
                    } else {
                        LinkedHashMap<String, List<Record>> tmpHash = new LinkedHashMap<String, List<Record>>();
                        tmpList.addAll(s.getValue());
                        tmpHash.put(tmpList.size() == 0 ? s.getKey() : tmpList.get(0).getFirstLetter() + "-" + s.getKey(),
                                new ArrayList<Record>(tmpList));
                        tmpList.clear();
                        return tmpHash.entrySet().stream();
                    }
                })
                .collect(Collectors.collectingAndThen(Collectors.toMap(s->s.getKey(), s->s.getValue(),(x1,x2)->x1,LinkedHashMap::new),
                        x->{
                            if (tmpList.size()!=0) {
                                x.put(tmpList.get(0).getFirstLetter()+"-"+tmpList.get(tmpList.size()-1).getFirstLetter(),
                                        new ArrayList<Record>(tmpList));
                                tmpList.clear();
                            }
                            return x;
                        }));

        System.out.println("\n\nresult, ABC-sorted: \n" + recGeneral);
    }
}
