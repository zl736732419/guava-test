###Guava工具库使用
	1.增加Guava Optional处理null方式，MoreObjects处理null方法firstNotNull
	以及Strings类提供的处理null/empty的几种方法nullToEmpty,emptyToNull,isNullOrEmpty
	2.添加前置条件判断Preconditions
	3.添加异常处理Throwables
	4.添加不可变集合
	5.添加Multiset,支持存放相同元素，并计算各个相同元素出现的次数
	6.添加Multimap,支持一个key对应多个键值
	7.添加BiMap,支持键值相互映射，value不能重复，如果要强制插入重复的值，则采用forcePut()方法
	8.添加Table,两个键对应一个值，可以把它看做一个Excel,通过row,col定位value，遍历采用cellSet()转化为单元格操作
	9.添加RangeSet,RangeMap支持范围值
	10.添加各个集合工具类常用方法测试
