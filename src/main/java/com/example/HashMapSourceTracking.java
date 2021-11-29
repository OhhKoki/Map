package com.example;

import org.junit.Test;
import java.util.HashMap;

/**
 * HashMap 源码浅析，结论如下：
 *
 *      1. HashMap 底层维护了一个 Node 类型的对象数组 table，默认为 null;
 *
 *      2. 当创建 HashMap 集合时，将加载因子（loadfactor）初始化为 0.75;
 *
 *      3.当添加 key-value 时：
 * 	        1）通过 key 计算得到一个 hashcode。再根据得到的 hashcode 计算得到该 key 在 table 的 index;
 * 	        2）判断 table[index] 处是否有元素：
 *     	        1. 如果没有元素：直接将元素添加到 table[index] 处;
 * 		        2. 如果存在元素：
 *         	        1）判断该元素的 key 与准备加入的元素的 key 是否相同
 *             	        1. 相同：直接替换 value
 *                      2. 不同：
 *                 	        1）遍历该节点（链表），往后的节点的 key 与准备加入的元素的 key 相同则替换 value，都不相同则将元素添加在链表的尾部;
 * 					        2）在每次添加完元素之后，都会判断添加了当前元素的话，table 的 size 是否达到阈值。如果达到阈值，需要接着判断是进行 table 的扩容还是链表的树化；
 *                 	        3）当前 table[index] 处的链表的 size 大于 8，且 table.length 大于等于 64，这时候就会对 table[index] 处的链表进行树化;
 */
@SuppressWarnings("all")
public class HashMapSourceTracking {

    @Test
    public void test01() {
        HashMap map = new HashMap();
        map.put("张三","张三");
        map.put("李四","李四");
        map.put("令牌","令牌");
        map.put("令牌","口令");
        System.out.println(map);
    }

}
