package com.example;

import org.junit.Test;
import java.util.Hashtable;

/**
 * Hashtable 源码浅析，结论如下：
 *
 *      1. Hashtable 的使用方式与 HashMap 有点类似，都是键值对形式;
 *
 *      2. Hashtable 的底层是一个对象数组：
 *          1）底层是一个 Entry 类型的对象数组：table = new Entry<?,?>[initialCapacity];
 *          2）数组的默认大小为 11：this(11, 0.75f);
 *          3）加载因子默认大小为 0.75：this(11, 0.75f);
 *          4）扩容阈值默认大小为 8：threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
 *
 *      3. Hashtable 是线程安全的，方法上都有 synchronized 修饰;
 *
 *      4. Hashtable 键和值不允许为空，为空则抛出 NullPointerException;
 *
 *      5. Hashtable 添加元素流程：
 *          1）根据 key 得到 hashcode;
 *          2）根据 hashcode % table.length 得到 index;
 *          3）遍历 table[index] 处的链表，判断是否已经存在 key 相同的元素：
 *              1. 如果已经存在：新值替换旧值，返回旧值;
 *              2. 如果没有存在：
 *                  1. 判断 table.size 是否等于扩容阈值：
 *                      1）等于：就行扩容，然后计算处新的 index 进行添加有元素;
 *                      2）小于：创建一个新的节点，然后挂载在 table[index] 处的链表的头部;
 *
 */
@SuppressWarnings("all")
public class HashtableSourceTracking {

    @Test
    public void test01() {
        Hashtable table = new Hashtable();
        table.put("张三","张三");
        table.put("李四","李四");
        table.put("令牌","令牌");
        table.put("令牌","口令");
        System.out.println(table);
    }

}
