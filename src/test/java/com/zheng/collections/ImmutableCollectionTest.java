package com.zheng.collections;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 不可变集合
 * 建议集合如果不想改变或者想让一个集合作为一个常量的时候，将其设置为不可变集合
 * @author zhenglian
 */
public class ImmutableCollectionTest {

	/**
	 * 创建方式有三种copyOf of builder
	 */
	@Test
	public void testCreate() {
		//copyOf
		List<Integer> list = Lists.newArrayList(1,2,3,4,5);
		ImmutableSet<Integer> sets = ImmutableSet.copyOf(list);
		System.out.println(list);
		
		//of
		sets = ImmutableSet.of(2,3,4);
		System.out.println(sets);
		
		//builder
		sets = ImmutableSet.<Integer>builder().addAll(list).add(10).build();
		System.out.println(sets);
	}
	
	@Test
	public void testImmutableSortSet() {
		ImmutableSortedSet<Integer> sets = ImmutableSortedSet.of(1,5,3);
		System.out.println(sets);
	}
	
}
