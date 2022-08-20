package Containers;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class BitSumGenerics<T> {
    private static Map<Class<?>, EnumMap<?, Integer>> enumRegistry;

    private Integer bitSumValue;

//    BitSumGenerics(Class<T> enumClass) {
//        if(!BitSumGenerics.enumRegistry.containsKey(enumClass)) {
////            for(int i = 0; i<T.values())
//            Set<T> enumSet = EnumSet.allOf();
//            BitSumGenerics.enumRegistry.put( )
//        }
//    }
}
