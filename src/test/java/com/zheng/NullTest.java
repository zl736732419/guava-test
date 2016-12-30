package com.zheng;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
    Guava中是不允许存在null键值的，如果存在null就直接报错。
 1. 在开发中尽量避免在set/list/map中存放null值，这样会导致代码语义模糊，
    可以采用特殊值代替，比如Map中存在key它的值为null与Map中不存在key这两个是无法通过null区别的。
 
 2. 如果使用枚举值，可以定义一个字面量来代表null,比如java.math.RoundingMode.UNNECESSARY，
    这样比null更容易理解。
 * 
 */
public class NullTest {

    @Test
    public void test() {
        //直接拋出异常
//        Optional<Integer> optional1 = Optional.of(null);
        
        //将null视为一个absent optional，通过isPresent()方法可以判断出来
        Optional<Integer> optional2 = Optional.fromNullable(null);
        
        //判断optional值是否存在
        System.out.println(optional2.isPresent());
        Optional<Integer> optional3 = Optional.of(5);
        
        //获取值
        System.out.println(optional3.get());
        
        //如果为null就返回指定的value值
        Integer value = optional2.or(10);
        System.out.println(value);
        
        //如果为空直接返回null,需要借助Optional.fromNull();来定义optional
        Integer value2 = optional2.orNull();
        System.out.println(value2);
        
        //返回immutable set集合,如果存在值，则返回长度为1的集合，否则为空集合
        Set<Integer> set = optional3.asSet();
        System.out.println(set.iterator().next());
        Set<Integer> set2 = optional2.asSet();
        System.out.println(set2.isEmpty());
    }

    /**
     * Objects提供的处理null的方法
     */
    @Test
    public void testObjectsNull() {
        //如果所提供的两个值都为空则抛出异常
        Integer value1 = MoreObjects.firstNonNull(null, 3);
        System.out.println(value1);
    }

    /**
     * 强烈建议将null于空区分开
     * 用来与混淆的null于empty进行交互的方法
     */
    @Test
    public void testStringsNull() {
        //用null代替""
        String value = Strings.emptyToNull("");
        System.out.println(value);
        
        //判断是否是null或者空对象
        boolean isNull = Strings.isNullOrEmpty(null);
        System.out.println(isNull);
        
        //将null转为""
        String value3 = Strings.nullToEmpty(null);
        System.out.println("".equals(value3));
    }
    
    /**
     * StringUtils会判断是否是null, 空串或者空白字符
     *
     * @author zhenglian
     * @data 2016年12月30日 下午4:34:55
     */
    @Test
    public void testStringUtils() {
    	String str = "       ";
    	boolean value = StringUtils.isBlank(str);
    	System.out.println(value);
    }
    
    
}
