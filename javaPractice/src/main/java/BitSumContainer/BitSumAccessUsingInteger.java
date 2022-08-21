package BitSumContainer;

import java.util.*;

public class BitSumAccessUsingInteger {

    private EnumMap<Access, Integer> enumRegistry;
    private Integer bitSumValue;

    public Integer getBitSumValue() {
        return bitSumValue;
    }

    public BitSumAccessUsingInteger() {
        bitSumValue = 0;
        if(enumRegistry == null) {
            enumRegistry = new EnumMap<Access, Integer>(Access.class);
        }
        if(enumRegistry.isEmpty()) {
            Access[] accessValues = Access.values();
            for(int i=0; i<accessValues.length; ++i) {
                enumRegistry.put(accessValues[i], i);
            }
        }
        System.out.println("values added");
    }

    public Integer addAccess(Access accessTo) {
        Integer accessBit = enumRegistry.get(accessTo);
        bitSumValue |= 1<<accessBit;
        return bitSumValue;
    }

    public Integer revokeAccess(Access accessTo) {
        Integer accessBit = enumRegistry.get(accessTo);
        if(hasAccessTo(accessTo)) {
            bitSumValue ^= 1<<accessBit;
        }
        return bitSumValue;
    }

    public boolean hasAccessTo(Access accessTo) {
        Integer accessBit = enumRegistry.get(accessTo);
        return (bitSumValue & 1<<accessBit) !=0;
    }

    public Set<Access> getAllAccess() {
        var accessSet = new HashSet<Access>();
        for(Access access : Access.values()) {
            if(hasAccessTo(access)) {
                accessSet.add(access);
            }
        }
        return accessSet;
    }
}
