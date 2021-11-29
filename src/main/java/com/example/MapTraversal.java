package com.example;

import org.junit.Test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 遍历 Map 集合的三种方式
 */
@SuppressWarnings("all")
public class MapTraversal {

    @Test
    public void test01() {
        Map map = new HashMap();
        map.put("no1", "terry");
        map.put("no2", "chris");
        map.put("no3", "danys");

        // 方式一：获取到所有的 key，然后进行遍历
        System.out.println("========== 方式一：获取到所有的 key，然后进行遍历 ==========");
        Set keySet = map.keySet();
        for (Object keyName : keySet) {
            System.out.println(map.get(keyName));
        }

        // 方式二：获取到所有的 value，然后进行遍历
        System.out.println("========== 方式二：获取到所有的 value，然后进行遍历 ==========");
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

        // 方式三：通过 EntrySet 来获取 key-value
        // 阿里开发规范要求使用 entrySet 的方式遍历 Map，因为 entrySet 只需要访问一次，而 keySet 需要访问两次
        System.out.println("========== 方式三：通过 EntrySet 来获取 key-value，然后进行遍历 ==========");
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            // 将 Object 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            // HashMap$Node implements Map.Entry --> getKey()、getValue()
            System.out.println(m.getValue());
        }
    }

}