package com.zheng.collections.utils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.zheng.User;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtilTest {

    @Test
    public void testMain() {
        System.out.println("main");
    }

    @Test
    public void testIterable() {
        Iterable<Integer> iterable = Iterables.concat(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4));
        System.out.println("orginal: " + Lists.newArrayList(iterable));
        //获取集合大小
        Iterables.size(iterable);

        ///获取第一个元素
        Integer value = Iterables.getFirst(iterable, -1);
        System.out.println("first element=======");
        System.out.println(value);

        //获取最后一个元素
        value = Iterables.getLast(iterable, -1);
        System.out.println("last element===========");
        System.out.println(value);
        System.out.println("partition=============");
        Iterable<List<Integer>> parts = Iterables.partition(iterable, 2);
        Iterator<List<Integer>> iterator = parts.iterator();
        List<Integer> list;
        while (iterator.hasNext()) {
            list = iterator.next();
            System.out.println(list);
        }

        //retainsAll 删除给定集合中的元素
        Iterables.retainAll(iterable, Lists.newArrayList(1, 2));
        System.out.println(Iterables.size(iterable));

        //get 
        System.out.println("get===========");
        value = Iterables.get(iterable, 0);
        System.out.println(value);

        //ToArray
        Integer[] arr = Iterables.toArray(iterable, Integer.class);
        System.out.println(arr);
    }

    @Test
    public void testLists() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> reverse = Lists.reverse(list);//reverse操作的是原来的list对象
        reverse.add(4);
        System.out.println("reverse========");
        System.out.println(reverse);
        System.out.println(list);

        //transform
        List<User> users = Lists.transform(list, new Function<Integer, User>() {
            @Override
            public User apply(Integer input) {
                return new User(input, "name" + input);
            }
        });

        System.out.println(users);
    }

    @Test
    public void testSets() {
        //powerSet
        Set<Integer> sets = Sets.newHashSet(1, 2, 3); //幂集(所有子集合，包括空集和自己)
        Set<Set<Integer>> powers = Sets.powerSet(sets);
        for (Set<Integer> power : powers) {
            System.out.println(power);
        }

        //filter
        Set<Integer> result = Sets.filter(sets, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input > 2;
            }
        });
        System.out.println("filter=======");
        System.out.println(result);

        //union  结果不可编辑
        Set<Integer> sets2 = Sets.newHashSet(2, 3, 4);
        Set<Integer> sets3 = Sets.union(sets, sets2);
        System.out.println("union==========");
        System.out.println(sets3);

        //去交集 结果不可编辑
        sets3 = Sets.intersection(sets, sets2);
        System.out.println("intersection==========");
        System.out.println(sets3);

        //difference 结果不可编辑
        sets3 = Sets.difference(sets, sets2);
        System.out.println("前者相对于后者不存在的元素=========");
        System.out.println(sets3);

        System.out.println("两者交集之外的元素==========");
        sets3 = Sets.symmetricDifference(sets, sets2);
        System.out.println(sets3);

        //两个集合的笛卡尔积
        System.out.println("笛卡尔积==========");
        Set<List<Integer>> results = Sets.cartesianProduct(sets, sets2);
        for (List list : results) {
            System.out.println(list);
        }
    }

    @Test
    public void testMaps() {
        List<String> strs = Lists.newArrayList("hello", "java", "yesterday");

        
        // Maps.uniqueIndex允许将值按照某个特征进行对应，但是不允许多个值存在相同的特征，
        // 也就是多个值不允许有多个key
        ImmutableMap<Integer, String> maps = Maps.uniqueIndex(strs, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        System.out.println("Maps.uniqueIndex()");        
        System.out.println(maps);
        
        strs.add("yeah");
        strs.add("great");
        ImmutableListMultimap<Integer, String> result = Multimaps.index(strs, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        System.out.println("Multimaps.index()");//允许多个值存在相同的特性
        System.out.println(result);
        
        //difference
        Map<Integer, String> map1 = ImmutableMap.of(1, "1", 2, "2", 3, "3");
        Map<Integer, String> map2 = ImmutableMap.of(1, "2", 3, "3", 4, "4");
        
        MapDifference<Integer, String> difference = Maps.difference(map1, map2);
        System.out.println("commons========");
        Map<Integer, String> commons = difference.entriesInCommon();
        System.out.println(commons);
        
        System.out.println("difference============");
        Map<Integer, MapDifference.ValueDifference<String>> differs = difference.entriesDiffering();
        System.out.println(differs);
        
        System.out.println("left differ=========");
        Map<Integer, String> leftDiffer = difference.entriesOnlyOnLeft();
        System.out.println(leftDiffer);
        
        System.out.println("right differ==========");
        Map<Integer, String> rightDiffer = difference.entriesOnlyOnRight();
        System.out.println(rightDiffer);

    }
    
    @Test
    public void testBiMap() {
        //BiMap直接通过Maps操作，因为BiMap本身就是一个Map
        
        BiMap<Integer, String> map = HashBiMap.create();
        map.put(1, "hello");
        map.put(2, "world");
        BiMap<Integer, String> biMap = Maps.synchronizedBiMap(map);
        biMap.put(3, "java");
        System.out.println("synchronized========");
        System.out.println(biMap);
        
        biMap = Maps.unmodifiableBiMap(map);
        System.out.println("unmodified===========");
        System.out.println(biMap);
//        biMap.put(4, "Guava");
        
    }
    
    @Test
    public void testMultiSets() {
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 5);

        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 2);

        //判断前者是否包含后者集合中的所有元素，并且元素出现次数至少一次
        boolean result = multiset1.containsAll(multiset2);
        System.out.println(result);
        
        //containsOccurences 前者包含后者所有元素集合，并且前者count(o)>=后者count(o) 
        result = Multisets.containsOccurrences(multiset1, multiset2);
        System.out.println(result);

        Multisets.removeOccurrences(multiset2, multiset1); // multiset2 now contains 3 occurrences of "a"
        System.out.println("multiset2: " + multiset2);
        multiset2.removeAll(multiset1); // removes all occurrences of "a" from multiset2, even though multiset1.count("a") == 2
        result = multiset2.isEmpty(); // returns true
        System.out.println(result);
        
    }
    
    @Test
    public void testMultimaps() {
        //index 允许一个Key对应多个values
        //需要与Maps.uniqueIndex相区别，它不允许有多个相同的key
        List<String> strs = Lists.newArrayList("hello", "world", "java", "Guava", "great");
        ImmutableListMultimap<Integer, String> result = Multimaps.index(strs, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        
        System.out.println("index");
        System.out.println(result);
        
        //反转map key-value,目的是为了将多个key映射一个value转化为一个key对应多个value，这样会很实用
        Multimap<Integer, String> maps = HashMultimap.create();
        maps.put(1, "a");
        maps.put(2, "a");
        maps.put(3, "a");
        maps.put(4, "a");
        
        Multimap<String, Integer> invertMap = HashMultimap.create();
        Multimaps.invertFrom(maps, invertMap);
        System.out.println(invertMap);
        
        Map<Integer, String> map1 = ImmutableMap.of(1,"a", 2,"b", 3,"c");
        SetMultimap<Integer, String> setMap = Multimaps.forMap(map1);
        System.out.println(setMap);
        
    }
    
    @Test
    public void testTables() {
        Table<String, String, User> users = HashBasedTable.create();
        users.put("张", "三", new User(1, "张三"));
        users.put("李", "四", new User(1, "李四"));

        Table<String, String, User> users1 = Tables.transpose(users); //将行列位置互换
        User user = users1.get("三", "张");
        System.out.println(user);
        
        //cellSet for each 
        Set<Table.Cell<String, String, User>> cells = users.cellSet();
        System.out.println("cellset foreach===========");
        for(Table.Cell<String, String, User> cell : cells) {
            System.out.println(cell.getRowKey() + "," + cell.getColumnKey() + ":" + cell.getValue());   
        }
         
    } 
    
    
    

}
