package com.zheng;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class StringsTest {

	/**
	 * joiner用于连接多个元素，组成一个字符串，元素与元素之间通过sepearator分隔
	 * joiner总是线程安全的，每一个配置方法都返回一个新的joiner实例对象
	 * @author zhenglian
	 * @data 2017年1月3日 下午9:27:35
	 */
	@Test
	public void joinerTest() {
		//去除null
		List<Integer> list = Lists.newArrayList(1, 2, 3, null, 4);
		String str = Joiner.on(";").skipNulls().join(list);
		System.out.println(str);
		
		//null用指定的字符串代替
		str = Joiner.on(";").useForNull("null").join(list);
		System.out.println(str);
	}
	
	/**
	 * 相对于jdk内建的字符拆分器来说，它语义更加直白。jdk内建的拆分器会忽略掉尾部的空白
	 *
	 * @author zhenglian
	 * @data 2017年1月3日 下午9:38:13
	 */
	@Test
	public void splitterTest() {
		List<String> list = Lists.newArrayList(Splitter.on(";").trimResults().omitEmptyStrings().split("1;2;3; ;4;5"));
		System.out.println(list);

		//CharMatcher
		Iterable<String> iterable = Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings().split("1;2;3;4; ;5;6");
		list = Lists.newArrayList(iterable);
		System.out.println(list);
	}
	
	@Test
	public void testCharMatcher() {
		String digits = CharMatcher.DIGIT.retainFrom("helloworld123hhh"); //只保留数字
		System.out.println(digits);
		
		String str = CharMatcher.WHITESPACE.trimAndCollapseFrom("hello   world", '-'); //替换空白字符
		System.out.println(str);
		
		str = CharMatcher.WHITESPACE.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("Hello World");// 保留小写字符和空白
		System.out.println(str);
		
		str = CharMatcher.anyOf("abcde").removeFrom("hello,marry"); //anyOf 其中任何一个
		System.out.println(str);
	}
	
	@Test
	public void testCharSets() {
		String str = "hello world";
		
		//Don't do this 
		try {
			str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//do this
		byte[] bytes = str.getBytes(Charsets.UTF_8);
	}
	
	@Test
	public void testCaseFormat() {
		String str = "JAVA_HOME";
		String result = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, str); //jAVA_HOME
		System.out.println(result);
		
		result = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, str); //j-a-v-a_-h-o-m-e
		System.out.println(result);
		
		result = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str); //j_a_v_a__h_o_m_e
		System.out.println(result);
		
		result = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_CAMEL, str); //JAVA_HOME
		System.out.println(result);
		
		result = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str); //J_A_V_A__H_O_M_E
		System.out.println(result);
	}
}
