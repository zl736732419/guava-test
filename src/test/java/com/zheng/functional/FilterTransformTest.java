package com.zheng.functional;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * 函数式编程主要用于筛选(filter)与转换(transform)指定的集合
 *
 * @author zhenglian
 * @data 2017年1月3日 下午8:18:25
 */
public class FilterTransformTest {

	@Test
	public void test() {
		List<Integer> list = Lists.newArrayList(1,2,3,4,5);
		
		FluentIterable<String> iterator = FluentIterable.from(list).filter(new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input >= 3; //查找>=3的数
			}
		}).transform(new Function<Integer, String>() {
			@Override
			public String apply(Integer input) {
				return input+"";//将过滤后的结果转化为str
			}
		});
		
		List<String> strs = Lists.newArrayList(iterator);
		System.out.println(strs);
	}
	
	@Test
	public void testCharMatcher() {
		String str = " hello world ";
		String result = CharMatcher.BREAKING_WHITESPACE.trimFrom(str);
		System.out.println(result);
	}
	
	@Test
	public void testPredicates() {
		//用于判断两个类是否相等或者是另一个类的超类
		boolean result = Predicates.assignableFrom(List.class).apply(ArrayList.class);
		System.out.println(result);
		
		
		//判断给定的对象是否是指定类型的实例对象
		result = Predicates.instanceOf(Integer.class).apply("hello");
		System.out.println(result);
	}
	
	
	
}
