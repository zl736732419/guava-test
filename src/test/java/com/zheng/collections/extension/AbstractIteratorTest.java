package com.zheng.collections.extension;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 用户自定义iterator
 * Created by zhenglian on 2017/1/2.
 */
public class AbstractIteratorTest {
    
    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5, null, 6, null, 10);
        Iterator<Integer> iterator = skipNulls(list.iterator());
        System.out.println(Lists.newArrayList(iterator));
    }

    /**
     * 自定义迭代器用于排除null值
     * @param it
     * @return
     */
    private Iterator<Integer> skipNulls(final Iterator<Integer> it) {
        return new AbstractIterator<Integer>() {
            @Override
            protected Integer computeNext() {
                Integer num;
                while(it.hasNext()) {
                    num = it.next();
                    if(null != num) {
                        return num;
                    }
                }
                //需要标识当前迭代器已经遍历完
                return endOfData();
            }
        };
    }

}
