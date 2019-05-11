
import java.lang.annotation.*;
import annotations.*;

@Version(number = "0.1", author = "Petrov")
public class AnnotationDemo {

    public static void main(String[] args) {
        MyClassExample1 mc1 = new MyClassExample1();
        MyClassExample2 mc2 = new MyClassExample2();

        try {
            Class<?> aclass = Class.forName("annotations.MyClassExample2");
            if (aclass.isAnnotationPresent(Version1.class)) {
                // annotation presents
                System.out.println("class "+aclass.getName()+" annotated!");
                Annotation[] annList = aclass.getAnnotations();
                for (Annotation ann: annList ) {
                    System.out.println("  annotation: " + ann.annotationType());
                    if (ann.toString().contains("Version1")) {
                        System.out.println("    number: "+ aclass.getAnnotation(Version1.class).number());
                        System.out.println("    date: "+ aclass.getAnnotation(Version1.class).date());
                        Class prevClass = aclass.getAnnotation(Version1.class).previous();
                        if ((prevClass != null)&prevClass.isAnnotationPresent(Version.class)) {
                            Annotation prevAnn = prevClass.getAnnotation(Version.class);
                            if (prevAnn instanceof Version) {
                                System.out.println("    previous class annotation: " + prevAnn.annotationType());
                                System.out.println("      number: " + ((Version) prevAnn).number());
                                System.out.println("      author: " + ((Version) prevAnn).author());
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }
}
