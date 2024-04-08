package data_structure;

import org.junit.jupiter.api.Test;

public class DataTypes {
    Boolean aBoolean;
    Character aCharacter;
    Byte aByte;
    Short aShort;
    Integer aInteger;
    Float aFloat;
    Double aDouble;

    @Test
    void boxing() {
        // Same as: Integer integerValue = Integer.valueOf(3);
        Integer integerValue = 3;

        Integer a = 2000;
        Integer b = 2000;
        System.out.println(a == b);

        a = 3;
        b = 3;
        System.out.println(a == b);
    }

    void unboxing() {
        Integer boxed = 3;

        // Same as: int unboxed = boxed.intValue();
        int unboxed = boxed;
    }
}
