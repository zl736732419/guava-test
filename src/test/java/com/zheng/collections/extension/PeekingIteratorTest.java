package com.zheng.collections.extension;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhenglian on 2017/1/2.
 */
public class PeekingIteratorTest {
    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(1,2,3,3,4,3);
        PeekingIterator<Integer> peekIterator = Iterators.peekingIterator(list.iterator());
        Integer num;
        while(peekIterator.hasNext()) {
            num = peekIterator.next();
            while(peekIterator.hasNext() && peekIterator.peek().equals(num)) {
                peekIterator.next();
            }
            System.out.println(num);
        }
    }
}
