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
