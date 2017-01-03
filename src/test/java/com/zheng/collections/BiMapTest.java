package com.zheng.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * BiMap可以将键值进行相互绑定，也就是说可以通过键找到值，也可以通过值找到对应的键inverse()
 * BiMap本身是Map的子类
 * 不允许添加已经存在的value
 * 通过inverse()对map进行键值互换
 * 
 * Created by zhenglian on 2017/1/1.
 */
public class BiMapTest {
    
    @Test
    public void test() {
        BiMap<String, Integer> bmap = HashBiMap.create();
        bmap.put("1", 1);
        bmap.put("2", 2);
//        bmap.put("2", 1);//BiMap不允许存在相同的value,因为value还需要反转作为key
        bmap.forcePut("3", 1); //可以强制插入，但是原来存在的value会被置为null
        bmap.forcePut("4", 2);
        System.out.println("values: " + bmap.values());
        System.out.println("1:" + bmap.get("1"));
        System.out.println("2:" + bmap.get("2"));
        System.out.println("keyset: " + bmap.inverse().keySet());
        System.out.println("null: " + bmap.inverse().get(null));//value为空的键值对在inverse时被忽略

        String obj = bmap.inverse().get(1);
        System.out.println(obj);
        obj = bmap.inverse().get(2);
        System.out.println(obj);
        
        
        
        
    }
    
    
}
