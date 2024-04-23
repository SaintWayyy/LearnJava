package oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InnerClasses {
    class InnerClass {

    }

    static class StaticInnerClass {

    }

    @Test
    public void methodWithInnerClass() {
        class MethodInnerClass {

        }
        System.out.println(MethodInnerClass.class);
    }

    @Test
    void anonymousInnerClasses() {
        List<Integer> arrayList = new ArrayList<>(){
            {
                add(1);
            }
        };

        System.out.println(arrayList.getClass());
    }
}
