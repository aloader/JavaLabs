package annotations;

import annotations.ClassNote;

@Version(number="0.1", author = "Ivanov")
@ClassNote(text = "this is class note...", number = 438)
public class MyClassExample1 {
    int intField1;
    int intField2;

    public MyClassExample1 () {
    }

    @VersionMethod(action = "do something in class MyClassExample1")
    public void Method1 (int var1) {

    }
}
