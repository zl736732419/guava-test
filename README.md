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
	11.添加拓展工具类测试ForwardingXXX, PeekingIterator/AbstractInterator/AbstractsequentialIterator
	12.添加Predicates测试，主要用于filter/transform
	13.添加Strings测试,主要使用Joiner/Splitter/CharMatcher/Charsets/CaseFormat
	14.添加Streams关闭流处理方式，采用try-with-resources或者ByteSource/ByteSink,CharSource/CharSink代替Stream处理
	15.添加事件总线EventBus，注意AsyncEventBus采用多线程执行，在编写测试用例的时候需要让主线程一直执行，不然看不到结果(子线程来不及执行就已经结束了),
	EventBus则是在单线程中执行，内部采用自定义的枚举类实现Executor来构造一个执行器进行事件处理的
	EventBus中如果定义了通用的事件类型，那么EventBus也可以定义一个处理通用事件的处理方法
