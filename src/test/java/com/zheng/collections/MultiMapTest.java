package com.zheng.collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Multimap并不是Map Multimap集合允许一个key对应多个值
 * Multimap集合对于不存在的key对应的值为空集合,可以向其中添加值，如果想直接返回null则可以通过asMap()通过map方式来执行
 *      ArrayListMultimap
 *      SetMultiMap
 * @author zhenglian
 */
public class MultiMapTest {

	@Test
	public void testCreate() {
		Multimap<Integer, Integer> maps = HashMultimap.create();
		Collection<Integer> values = maps.get(2);// 如果不存在当前键值对，返回空集合,可以往集合中添加元素
		values.add(2);
		System.out.println(values);
		values = maps.asMap().get(3); // 如果不存在当前键值对直接返回null
		System.out.println(values);

		maps.put(1, 1);
		maps.put(1, 2); //一个键可以对应多个值，用Collection保存
		maps.put(2, 2);

		values = maps.get(1);
		List<Integer> list = Lists.newArrayList(values);
		System.out.println(list);

		Collection<Map.Entry<Integer, Integer>> entries = maps.entries();// 返回所有键值对，没有去重
		Integer key, value;
		for (Map.Entry<Integer, Integer> entry : entries) {
			key = entry.getKey();
			value = entry.getValue();
			System.out.println(key + ":" + value);
		}

		System.out.println("distinct key==========");
		Set<Integer> keys = maps.asMap().keySet();
		for (Integer k : keys) {
			System.out.println(k);
		}
	}
}
