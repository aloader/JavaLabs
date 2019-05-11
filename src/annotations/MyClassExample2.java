package annotations;

import annotations.MyClassExample1;

@Version1(number = "1.1",date = "2019-05-01",previous = MyClassExample1.class)
public class MyClassExample2 extends MyClassExample1 {
    public MyClassExample2 () { }

    @Override
    public void Method1(int var1) {
        super.Method1(var1);
    }

    public void Method1 (String str) {

    }
}
