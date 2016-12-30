package com.zheng;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Preconditions测试
 * 如果某个值有多重判断条件，强烈建议将多个条件分行处理，这样可以方便错误时调试
 * @author zhenglian
 * @data 2016年12月30日 下午4:38:48
 */
public class PreconditionTest {

	@Test
	public void test() {
		//判断条件是否为真
		Preconditions.checkArgument(1>0, "参数不能小于0");

		//判断不能为null
		String str = "hello world";
		str = Preconditions.checkNotNull(str, "%s不允许为空", "str");
		
		//判断某对象状态，与checkArgument实现方式相同，只是返回不同的异常
		List<Integer> list = Lists.newArrayList(1,2,3);
		Iterator<Integer> iterator = list.iterator();
		Preconditions.checkState(iterator.hasNext() && //这里多个条件，将条件拆分成多行
				iterator.next() == 2 
				, "迭代器已经遍历完毕");
		
		//判断集合索引是否越界，从0开始计数，比较的是索引
		Preconditions.checkElementIndex(2, list.size(), "超出list范围");
		
		//判断位置是否在范围之内,与index区别在于从1开始计数，比较的是顺序号
		Preconditions.checkPositionIndex(3, list.size(), "超出list范围"); // yes
		Preconditions.checkPositionIndexes(0, 3, list.size());
	}
	
	
	
	
}
