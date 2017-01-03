package com.zheng.collections.extension;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhenglian on 2017/1/2.
 */
public class LogginListTest {
    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList();
        LoggingList<Integer> loggingList = new LoggingList<>(list);
        loggingList.add(1);
        System.out.println(loggingList);
    }
}
