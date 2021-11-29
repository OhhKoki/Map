package com.example;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Map 集合中常用的方法
 */
@SuppressWarnings("all")
public class MapMethod {

    /**
     * 1. 添加 "键值对"
     */
    @Test
    public void test01() {
        Map map = new HashMap();
        map.put("no1","terry");
        System.out.println(map);
    }

    /**
     * 2. 根据 key 删除 "键值对"
     */
    @SuppressWarnings("all")
    @Test
    public void test02() {
        Map map = new HashMap();
        map.put("no1","terry");
        map.put("no2","chris");
        map.remove("no1");
        System.out.println(map);
    }

    /**
     * 3. 根据 key 修改 "键值对" 的 value
     */
    @SuppressWarnings("all")
    @Test
    public void test03() {
        Map map = new HashMap();
        map.put("no1","terry");
        // 覆盖即修改
        map.put("no1","chris");
        System.out.println(map);
    }

    /**
     * 4. 根据 key 查询  "键值对" 的 value
     */
    @SuppressWarnings("all")
    @Test
    public void test04() {
        Map map = new HashMap();
        map.put("no1","terry");
        map.put("no2","chris");
        // 1. 先判断某个 key 是否存在
        if (map.containsKey("no1")) {
            // 2. 根据 key 查询  "键值对" 的 value
            System.out.println(map.get("no1"));
        }

    }

    /**
     * 5. 其他方法
     */
    @SuppressWarnings("all")
    @Test
    public void test05() {
        Map map = new HashMap();
        map.put("no1","terry");
        map.put("no2","chris");
        // 1. 判断 map 中 “键值对” 个数是否为 0
        System.out.println(map.isEmpty());
        // 2. 查询 map 中 “键值对” 个数
        System.out.println(map.size());
        // 3. 清空 map 中 “键值对”
        map.clear();
        System.out.println(map.isEmpty());
    }

}
