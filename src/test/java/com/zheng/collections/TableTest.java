package com.zheng.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.zheng.User;
import org.junit.Test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 通过多个key定位一个value,比如姓+名=>姓名
 * Created by zhenglian on 2017/1/1.
 */
public class TableTest {
    
    @Test
    public void test() {
        Table<String, String, User> users = HashBasedTable.create();
        users.put("张", "三", new User(1, "zhangsan"));
        User user = users.get("张", "三");
        System.out.println(user);

        users.put("王", "张", new User(2, "xiaozhang"));
        Map<String, Map<String, User>> rows = users.rowMap();
        Map<String, User> cols = users.column("张");
        System.out.println("张col========");
        for(Entry<String, User> en : cols.entrySet()) {
        	System.out.println(en.getKey() + ":" + en.getValue());
        }
        
        
        //获取一个不存在的行会返回一个空行
        System.out.println("empty row========");
        Map<String, User> row = users.row("宋");
        System.out.println(row);
        row.put("江", new User(3, "宋江"));
        System.out.println(users.get("宋", "江"));
        
        users.put("张", "飞", new User(4, "张飞"));
        
        System.out.println("rowKeySet=========");
        System.out.println(users.rowKeySet());

        System.out.println("foreach cells ======");
        //单元格
        Set<Table.Cell<String, String, User>> cells = users.cellSet();
        String firstName, lastName;
        for(Table.Cell<String, String, User> cell : cells) {
            firstName = cell.getRowKey();
            lastName = cell.getColumnKey();
            user = cell.getValue();
            System.out.println(firstName + lastName + user.toString());
        }
        
        
        
    }
    
    
}
