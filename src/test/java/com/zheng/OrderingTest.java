package com.zheng;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 排序比较器测试
 * Ordering排序器本身其实就是一个Comparator
 * 支持链式调用
 * ordering排序器处理顺序是从右往左进行的
 * 
 * Collections.sort(iterator, ordering); //调用该方法只会在原来的iterator中进行排序
 * ordering.sortedBy(iterator); //该方法将会基于排序的结果构建新的集合，原来的列表顺序不变
 *
 * @author zhenglian
 * @data 2016年12月30日 下午5:20:47
 */
public class OrderingTest {

	@Test
	public void test() {
		List<Integer> numbers = Lists.newArrayList(1, 10, 8, 6, 7, 4, 2, 3);
		
		//自然排序，针对数字，日期类型
		Ordering<Integer> ordering = Ordering.natural();
		List<Integer> values = ordering.sortedCopy(numbers);
		System.out.println("natural===");
		System.out.println(values);
		
		//自然反序排序
		ordering = Ordering.natural().reverse();
		values = ordering.sortedCopy(values);
		System.out.println("reverse===");
		System.out.println(values);
		
		//按照字典排序
		Ordering<Object> ordering1 = Ordering.usingToString();
		values = ordering1.sortedCopy(numbers);
		System.out.println("usingToString===");
		System.out.println(values);
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		values = Ordering.from(comparator).sortedCopy(numbers);
		System.out.println("from comparator===");
		System.out.println(values);
		
		//将null放在前端
		List<Integer> numbers1 = Lists.newArrayList(1, 10, 8, 6, 7, null, 4, 2, 3, null);
		values = Ordering.natural().nullsFirst().sortedCopy(numbers1);
		System.out.println(values);

		//将null放在尾端
		values = Ordering.natural().nullsLast().sortedCopy(numbers);
		System.out.println(values);
		
		//onResultOf针对对象类型，根据返回的对象中的某一个属性进行排序
		List<User> users = Lists.newArrayList();
		Random random = new Random();
		Integer num = null; 
		for(int i = 0; i < 10; i++) {
			num = random.nextInt(10);
			users.add(new User(num, "name" + num));
		}
		
		Ordering<User> userOrding = Ordering.natural().nullsFirst().onResultOf(new Function<User, Integer>() {
			@Override
			public Integer apply(User input) {
				return input.getId();
			}
		});
		System.out.println("onResultOf===");
		System.out.println(userOrding.sortedCopy(users));
		
		//greastof 返回最大的k个元素
		values = Ordering.natural().greatestOf(numbers, 3); //greatestOf.reverse()就是leastof
		System.out.println("greatestOf==="); //greatest/leastof不允许其中存在空值
		System.out.println(values);
		
		//leastof 返回最小的k个元素
		values = Ordering.natural().leastOf(numbers, 3); // leastof.reverse()就是greatestof
		System.out.println("leastOf==="); //greatest/leastof不允许其中存在空值
		System.out.println(values);
		
		//isOrdered判断集合是否已经排序
		boolean isOrdered = Ordering.natural().isOrdered(numbers);
		System.out.println("isOrdered===");
		System.out.println(isOrdered);
		values = Ordering.natural().sortedCopy(numbers);
		isOrdered = Ordering.natural().isOrdered(values);
		System.out.println(isOrdered);
		
		//min最小值
		int min = Ordering.natural().min(numbers);
		System.out.println("min===");
		System.out.println(min);
	}
	
}
