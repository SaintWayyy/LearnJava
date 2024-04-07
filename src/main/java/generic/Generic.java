package generic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {

    @Test
    void PECS(){
        // Producer Extends Consumer Super (PECS)

        // 使用extends 来创建作为生产者的范型容器, 该容器只能作为生产者, 只能从该容器中读取元素
        List<? extends Integer> producer = new ArrayList<>();

        // 使用super 来创建作为消费者的范型容器, 该容器只能作为消费者, 只能向该容器里写入元素
        List<? super Integer> consumer = new ArrayList<>();

        Integer a = 1;
        a = producer.get(1);
        // producer.add(a);

        // a = consumer.get(1);
        consumer.add(a);
    }

    @Test
    void typeErase(){
        List<Integer> integerList = new ArrayList<>();
        try {
            Method method = integerList.getClass().getMethod("add", Object.class);
            method.invoke(integerList, "test");
            method.invoke(integerList, 100.f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object o : integerList) {
            System.out.println(o);
        }
    }
}
