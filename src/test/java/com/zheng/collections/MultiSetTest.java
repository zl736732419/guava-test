package com.zheng.collections;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 可以存放重复的元素，并且可以统计相同元素出现的次数
 * multiset两者之间进行比较时是忽略顺序的
 */
public class MultiSetTest {
    
    @Test
    public void testCount() {
        List<Integer> list = Lists.newArrayList(1, 1,3,5,3,2,3,5);
        Multiset<Integer> msets = HashMultiset.create(list);
        Set<Integer> elements = msets.elementSet();//获取唯一的元素列表
        System.out.println(elements);
        System.out.println("总共: " + msets.size());

        for(Integer element : elements) {
            System.out.println(element + ":" + msets.count(element));
        }
    }
    
    @Test
    public void testEntrySet() {
        List<Integer> list = Lists.newArrayList(1, 1,3,5,3,2,3,5);
        Multiset<Integer> msets = HashMultiset.create(list);
        
        Integer element, count;
        for(Multiset.Entry<Integer> entry : msets.entrySet()) {
            element = entry.getElement();
            count = entry.getCount();
            System.out.println(element + ":" + count);
        }
        
    }


    /**
     * 顺序不同也不影响，相等不一定要顺序相同
     */
    @Test
    public void testEqual() {
        Multiset<Integer> msets1 = HashMultiset.create();
        msets1.add(1);
        msets1.add(3);
        msets1.add(2);
        Multiset<Integer> msets2 = HashMultiset.create();
        msets2.add(1);
        msets2.add(2);
        msets2.add(3);
        
        System.out.println(msets1.equals(msets2));
        
    }

    /**
     * 如果
     */
    @Test
    public void testSetCount() {
    	 Multiset<Integer> msets1 = HashMultiset.create();
    	 msets1.setCount(1, 5);
    }

    /**
     * 截取指定的范围
     */
    @Test
    public void testSortMultiSet() {
        SortedMultiset<Integer> msets = TreeMultiset.create();
        msets.add(1);
        msets.add(1);
        msets.add(1);
        msets.add(3);
        msets.add(3);
        msets.add(2);
        msets.add(2);
        
        Multiset<Integer> sets = msets.subMultiset(0, BoundType.CLOSED, 2, BoundType.CLOSED);
        System.out.println(sets);
    }

}
