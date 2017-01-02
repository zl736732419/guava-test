package com.zheng;

import org.junit.Test;

import com.google.common.base.Throwables;

/**
 * 异常测试 
 *
 * @author zhenglian
 * @data 2016年12月30日 下午6:37:24
 */
public class ThrowableTest {

	@Test
	public void test() {
		//抛出RuntimeException Error 或者其他异常类型将会被包装成RuntimeException
		Throwables.propagate(new NullPointerException());
		
		//抛出RuntimeException Error
		Throwables.propagateIfPossible(new NullPointerException());
		
		//指定类型的异常才抛出
		Throwables.propagateIfInstanceOf(new NullPointerException(), NullPointerException.class);
		
		//抛出指定类型异常或者RuntimeException Error
		Throwables.propagateIfPossible(new NullPointerException(), NullPointerException.class);
	}
	
	@Test
	public void test1() {
		String a = "hello world";
		System.out.println(String.class.isInstance(a));
	}
	
}
