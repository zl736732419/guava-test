package com.zheng.collections.extension;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;

/**
 * 根据某一个值按照某种特定的算法添加元素到list中组成一个新的list集合
 * 传入null 立马结束
 * 实现方法中返回null表示结束
 * Created by zhenglian on 2017/1/2.
 */
public class AbstractSequentialTest {

    @Test
    public void test() {
        Iterator<Integer> powersOfTwo = new AbstractSequentialIterator<Integer>(null) { // note the initial value!
            protected Integer computeNext(Integer previous) {
                return (previous == 1 << 30) ? null : previous * 2;
            }
        };
        
        System.out.println(Lists.newArrayList(powersOfTwo));
    }
}
