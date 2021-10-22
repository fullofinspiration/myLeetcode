# 欧科互动1面 20210923 20：00-20：33
问题：
  数据结构：
  1 链表和数组的区别
  2 如果有一个链表，如何快速查找到链表中的某个位置(没答上来)了解跳表吗
  guava:
    1 Guava cache 淘汰策略有哪些
    2 cache淘汰缓存的时刻是什么时候
    3 什么是lru
    4 Guava了解那些类
    5 Guava cache的rate limiter使用以及如何实现的

  说一个最了解的中间件，说了mysql
  1 mysql一条语句插入经过了什么过程
  2 db中有1，2，10， mysql插入一条数据时会加什么锁
  3 如果插入过程中主机的binlog没有传输就崩溃了，备机成了主机，这种情况如何故障恢复
  4 插入语句的redo log插入了几次
  5 什么是回表
  6 讲一下mvcc
  7 delete时会加什么锁

  jvm相关
  1 g1和cms区别
  2 new一个对象分别放在那个区
  3 什么是卡表
  Java相关
  NIO
  
答案：
数据结构：
1 链表和数组的区别
2 如果有一个链表，如何快速查找到链表中的某个位置(没答上来)了解跳表吗
 https://www.jianshu.com/p/9d8296562806

guava:
1 Guava cache 淘汰策略有哪些
lru+fifo 访问多久删除 写入多久删除，固定数量删除，弱引用删除
2 cache淘汰缓存的时刻是什么时候
young gc时刻删除 get时删除
3 什么是lru
最近最少使用
4 Guava了解那些类
https://www.bloglhy.com/article/69
5 Guava cache的rate limiter使用以及如何实现的
https://zhuanlan.zhihu.com/p/60979444

说一个最了解的中间件，说了mysql
1 mysql一条语句插入经过了什么过程

2 db中有1，2，10， mysql插入一条数据时会加什么锁
https://www.aneasystone.com/archives/2018/06/insert-locks-via-mysql-source-code.html
3 如果插入过程中主机的binlog没有传输就崩溃了，备机成了主机，这种情况如何故障恢复
4 插入语句的redo log插入了几次 没找到答案
5 什么是回表
6 讲一下mvcc
7 delete时会加什么锁

# momenta 1面 20210930 13: 00 ~ 13:30
1 讲一下java内存模型 
Java虚拟机规范规定了6块区域，分别是虚拟机栈，堆，方法区，native区，(另外3块区域忘记了)
虚拟机栈：线程执行时，方法中的变量，会在虚拟机栈中，下一行要执行的指令地址，
堆：所有new的对象最终是在堆中分配
方法区：虚拟机运行时的类信息，字面量的指针
对于垃圾回收，主要回收堆上的区域，对于垃圾回收
2 讲一下垃圾回收
3 redis如何使用 哨兵模式
4 Cap 理论和base理论
5 乐观锁是如何实现的
6 Kafka原理，kafka为什么这么快
7 B加树和红黑树 b树 二叉树区别

# 白龙马一面
# 白龙马二面

# 58 一面
主要


# 陌陌一面
mysql为什么使用b+树不使用b树
讲一下concurrentHashmap 和hashmap
java7为什么并发度是16
如何计算出三层b+树最大数量是2000w？
hashmap扩容为什么使用2的整数倍
myasm和innodb区别
b+树 每个非叶子节点保存了什么

算法题 19题
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
# 陌陌二面
判断链表是否有环

# 新浪微博一面
rpc原理

# aviagames一面  2021 20:10
内存模型
volatile synchronized lock区别
hashmap自动扩容
垃圾回收设置young gc暂停时间和最小间隔参数
future task原理
kafka高可用 高吞吐原因
零拷贝是如何实现的，调用了操作系统的什么系统方法
# aviagames cto面  2021 10.21 14:00
zab如何解决脑裂问题
redis如何多个key排序问题
redis如何实现内存回收的

# 快手三面 2021 10.22 10:30
业务相关 现公司架构，自己在小组主要负责内容，优缺点
