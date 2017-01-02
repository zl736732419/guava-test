package com.zheng.collections.extension;

import com.google.common.collect.ForwardingList;

import java.util.List;

/**
 * Guava对所有集合都提供了ForwardingXXX抽象类，用于实现装饰模式，封装自己的业务逻辑
 * 并且对大多数常用的方法都提供了standardXXX()方法
 * 对于map集合类型包装的抽象视图通常情况下也都提供了标准实现，比如
 * ForwardingMap提供了StandardKeySet/StandardValues/StandardEntrySet等
 * 添加元素时打印消息日志
 * Created by zhenglian on 2017/1/2.
 */
public class LoggingList<E> extends ForwardingList<E>{
    private List<E> list;
    
    public LoggingList(List<E> list) {
        this.list = list;
    }
    
    @Override
    protected List<E> delegate() {
        return list;
    }

    @Override
    public boolean add(E element) {
        String msg = element.toString() + "add to list...";
        log(msg);
        return standardAdd(element);
    }
    
    private void log(String msg) {
        System.out.println(msg);
    }
}


