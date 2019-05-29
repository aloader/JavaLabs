/*
Отсортировать коллекцию строк по алфавиту и убрать дубликаты
 */
package streams2;
import utils.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@LabAnnotation(
        number = "15",
        text = "Отсортировать коллекцию строк по алфавиту и убрать дубликаты.")
public class task15_StringCollectionABCSort extends task {
    public task15_StringCollectionABCSort() {

        Collection<String> colString = Arrays.asList(
            "1  - lower priority.\n",
            "[HKEY_CURRENT_USER\\Software\\Far Manager\\Plugins\\MultiArc\\TryIfNoOther]\n",
            "\"fmt-module-name\":REG_DWORD\n",
            "This parameter of DWORD type decreases the priority of the corresponding\n",
            "fmt-module in the  process  of  selecting  the  appropriate  module  for\n",
            "handling the archive.\n",
            "\"fmt-module-name\":REG_DWORD\n",
            "        Usually it should be applied to custom.fmt, wcx.fmt and upx.fmt.\n",
            "        Possible values:\n",
            "0  - normal priority (default);\n",
            "1  - lower priority.\n"
        );
        System.out.println("\nString collection:\n" + colString);

        System.out.println("\n\nABC-sorted, no duplicates: \n");
        System.out.println(colString.stream()
                .distinct()
                .sorted( (s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList()));
    }
}
