/*
26. Дан список списков строк. Вернуть строку по шаблону:
<div>
<ul>
   <li>{data}</li>
</ul>
<ul>
   <li>{data}</li>
</ul>
</div>

 Может быть и так:
 strings.stream().collect(Collectors.joining(": ", "<b> ", " </b>"))

 */
package streams3;
import utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@LabAnnotation(
        number = "26",
        text = "Дан список списков строк. Вернуть строку по шаблону: \n" +
                "<div>\n" +
                "<ul>\n" +
                "   <li>{data}</li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "   <li>{data}</li>\n" +
                "</ul>\n" +
                "</div>")
public class task26_GetStringByPattern extends task {
    public task26_GetStringByPattern() {
        super();

        ArrayList<List<String>> lstLst = new ArrayList<List<String>>();
        lstLst.add(Arrays.asList(new String[]{"dt1", "dt2"}));
        lstLst.add(Arrays.asList(new String[]{"dt3"}));
        lstLst.add(Arrays.asList(new String[]{"dt4", "dt5", "dt6"}));

        System.out.println("\nin array of lists: " + lstLst);

        StringBuilder xmlStr = new StringBuilder();
        xmlStr.append(
                lstLst.stream()
                .flatMap(list->list.stream())
                        .map(str->"\n<ul>\n"+"   <li>{"+str+"}</li>\n" + "</ul>")
                .collect(Collectors.joining("", "\n<div>", "\n</div>")));

        System.out.println("\nresult: " + xmlStr.toString());
    }
}
