package BitSumContainer;

import java.util.*;

public class BitSumGenericsUsingInteger<T extends Enum<T>> {

    private static EnumMap<?, Integer> enumRegistry;

    private final Class<T> enumType;
    private int bitSumValue;

    public Integer getBitSumValue() {
        return bitSumValue;
    }

    BitSumGenericsUsingInteger(Class<T> enumClass) {
        this.enumType = enumClass;
        this.bitSumValue = 0;

        if(BitSumGenericsUsingInteger.enumRegistry == null) {
            Set<T> enumSet = EnumSet.allOf(enumClass);
            var enumValuesToInt = new EnumMap<T, Integer>(enumType);
            int counter = 0;
            for(T enumVal : enumSet) {
                enumValuesToInt.put(enumVal, counter++);
            }
            enumRegistry = enumValuesToInt;
            System.out.println("values added to enum registry");
        }
    }

    public boolean hasAccessTo(T enumVal) {
        Integer enumValueBit = enumRegistry.get(enumVal);
        return (bitSumValue & 1<<enumValueBit) !=0;
    }

    public int addEnumVal(T enumVal) {
        Integer enumValueBit = enumRegistry.get(enumVal);
        bitSumValue |= 1<<enumValueBit;
        return bitSumValue;
    }

    public int revokeAccess(T enumVal) {
        Integer enumValueBit = enumRegistry.get(enumVal);
        if(hasAccessTo(enumVal)) {
            bitSumValue ^= 1<<enumValueBit;
        }
        return bitSumValue;
    }

    public Set<T> getAllEnumValues() {
        var enumValueSet = new HashSet<T>();
        for(T enumValue : EnumSet.allOf(enumType)) {
            if(hasAccessTo(enumValue)) {
                enumValueSet.add(enumValue);
            }
        }
        return enumValueSet;
    }

}
