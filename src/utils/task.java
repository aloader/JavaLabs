package utils;

import utils.*;

@LabAnnotation(number = "00", text = "")
abstract public class task {
    public task() {
        outTitle();
    }

    // print title of the task
    private void outTitle() {
        Class<?> aclass = this.getClass();
        if (aclass.isAnnotationPresent(LabAnnotation.class)) {
            // annotation presents
            System.out.println("\n" +
                    "*** task " + aclass.getAnnotation(LabAnnotation.class).number() + "***");
            System.out.println(aclass.getAnnotation(LabAnnotation.class).text());
        }
    }
}
