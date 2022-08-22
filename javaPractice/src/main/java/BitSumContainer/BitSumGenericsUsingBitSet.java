package BitSumContainer;

import java.util.*;

public class BitSumGenericsUsingBitSet<T extends Enum<T>> {

    private static EnumMap<?, Integer> enumRegistry;

    private final Class<T> enumType;
    private BitSet bitSumValue;

    BitSumGenericsUsingBitSet(Class<T> enumClass) {
        this.enumType = enumClass;

        Set<T> enumSet = EnumSet.allOf(enumClass);
        this.bitSumValue = new BitSet(enumSet.size());

        if(BitSumGenericsUsingBitSet.enumRegistry == null) {
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
        return bitSumValue.get(enumValueBit);
    }

    public void addEnumVal(T enumVal) {
        Integer enumValueBit = enumRegistry.get(enumVal);
        bitSumValue.set(enumValueBit);
    }

    public void revokeAccess(T enumVal) {
        Integer enumValueBit = enumRegistry.get(enumVal);
        if(hasAccessTo(enumVal)) {
            bitSumValue.clear(enumValueBit);
        }
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
