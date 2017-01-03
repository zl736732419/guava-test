package com.zheng.collections;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by zhenglian on 2017/1/1.
 */
public class RangeSetTest {
    @Test
    public void test() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 5));
        rangeSet.add(Range.closedOpen(6, 10));
        rangeSet.add(Range.closedOpen(10, 20));
        rangeSet.add(Range.closedOpen(0, 0));
        rangeSet.remove(Range.open(5, 15));
        
        Set<Range<Integer>> result = rangeSet.asRanges();
        Integer start, end;
        for(Range<Integer> range : result) {
            start = range.lowerEndpoint(); //获取范围两端的值
            end = range.upperEndpoint();
            System.out.println(start + "-" + end);
            System.out.println(range.toString());
            System.out.println("span=====");//返回可以包含指定range的最小区间
            System.out.println(range.span(Range.open(1,3)));
        }
        
    }
    
    
    @Test
    public void testRangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closedOpen(1,5), "hello");
        rangeMap.put(Range.closedOpen(6, 10), "world");
        
        RangeMap<Integer, String> sub = rangeMap.subRangeMap(Range.closedOpen(1,8));
        Map<Range<Integer>, String> ranges = sub.asMapOfRanges();
        Range<Integer> range;
        String value;
        for(Map.Entry<Range<Integer>, String> entry : ranges.entrySet()) {
            range = entry.getKey();
            value = entry.getValue();
            System.out.println(range.toString() + "->" + value);
        }
    }
}
