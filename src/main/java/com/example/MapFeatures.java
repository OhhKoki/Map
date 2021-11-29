package com.example;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Map 集合的特征
 */
@SuppressWarnings("all")
public class MapFeatures {

    /**
     * 1. Map 的 key 和 value 可以是任意引用类型，数据会封装到 HashMap$Node 对象中（以HashMap为例）
     */
    @Test
    public void test01() {
        Map map = new HashMap();
        map.put(1, 1);
        map.put("terry", "terry");
        map.put(true, true);
        map.put(new Object(), new Object());
        System.out.println(map);
    }

    /**
     * 2. Map 的 key 不允许重复（将同一个 key 的 value 就行覆盖）
     */
    @SuppressWarnings("all")
    @Test
    public void test02() {
        Map map = new HashMap();
        map.put("no1", "terry");
        map.put("no1", "chris");
        System.out.println(map);
    }

    /**
     * 3. Map 的 value 允许重复（没啥好说的）
     */
    @SuppressWarnings("all")
    @Test
    public void test03() {
        Map map = new HashMap();
        map.put("no1", "terry");
        map.put("no2", "chris");
        System.out.println(map);
    }

    /**
     * 4. Map 的 key 与 value 允许为 null，并且同时为 null 也可以。但是 key 为 null 只能有一个，value 为 null 可以有多个，没啥说的，直接看源码：
     *
     *      static final int hash(Object key) {
     *         int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     *      }
     *
     *      当 key 为 null 时，hashcode 都相同，那么 index 必然相同。并且在添加元素时，都会判断 key 是否相同，相同的话还会进行 value 的覆盖，这就导致 “key 为 null 只能有一个”
     *
     *      if (e != null) {
     *          V oldValue = e.value;
     *          if (!onlyIfAbsent || oldValue == null)
     *              e.value = value;
     *          afterNodeAccess(e);
     *          return oldValue;
     *      }
     *
     *      对于 "value 为 null 可以有多个" 而言，如果 key 不相同，那么对于 Map 而言就是不同的节点，不需要考虑节点的 value 是否需要覆盖，所以 "value 为 null 可以有多个"
     *
     */
    @SuppressWarnings("all")
    @Test
    public void test04() {
        Map map = new HashMap();
        map.put("no1", "terry");
        map.put("no2", "chris");
        System.out.println(map);
    }

}
