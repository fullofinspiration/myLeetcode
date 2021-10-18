 网上其他人的面试题，是有参考性的面经
# 亚马逊  2021-04-25 12:18:54（实习）
Spring生命周期：没有背熟导致被回答的不好

Spring事物原理：不清楚

MySQL事物原理：undolog

项目问题：支付幂等性悲观锁金额乐观锁

线程池：回答了参数和原理

Qps如果需要大幅提高怎么半：横向扩展，纵向扩展，缓存，消息队列，数据库级群，数据库连接池多个方面回答

Jvm问题优化：想回答八股文被打断，说问的是实际使用怎么优化，打到了关于fullgc，空间分配，碎片空间以及垃圾回收器选择

如何解决redis穿透问题：redis缓存空值，布隆过滤器

布隆过滤器如解决删除问题：将0，1改为0，n

如果redis极热点redis缓存失效大量打到数据库中就会造成奔溃怎么半？

后台设置线程将数据库热点恢复到redis上，这期间调用分布式锁，只有获得锁的才能访问数据库，造成短时间等待防止数据库不可用

算法题：最长无重复子串

场景题：设计秒杀系统
答了：静态资源，负载均衡，分布式，redis缓存级群搭建，rocketMQ异步，mysql主从分离，分库分表
云平台使用以及背后原理：基本不会，许多概念都没有明白
防止超卖：落单减库存，失败再加回去

# 亚马逊  2021-09-08 （校招）
作者：牛客838810660号
链接：https://www.nowcoder.com/discuss/735325?channel=-1&source_id=profile_follow_post_nctrack
来源：牛客网

亚马逊一共约了2面连着，共两小时
一面：
简单问了一下基本情况，因为我主要做数据的，所以问了一下关系型数据库和非关系型数据库区别
直接做题，岛屿问题
岛屿问题的拓展：求最大岛屿面积
小哥哥超级温柔，也在一直帮你看代码的问题，在写代码的过程中也不断提问

二面：
项目深问
你的优势是什么，缺点是什么
你在过往经历中成长最快的一件事
你在日常生活中是如何学习的，有没有什么小窍门
java的gc机制
java的多线程
OOD：设计一个餐厅的点单服务系统，需要哪些类以及接口，如何交互
因为时间来不及，所以只说了初步的想法，没有思路实现
二面面试官总是说“好问题”，起初还以为在夸我，后来发现是他的口头禅

# 亚马逊 2021-09-27 
作者：yang👴yang
链接：https://www.nowcoder.com/discuss/758595?type=2&order=0&pos=9&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

一面
java基础知识
青蛙跳台阶，口述，优化
区间合并问题，区分开区间闭区间
设计一个自动售货机
10亿数取top100

二面
问项目
统计词频，不用考虑标点符号大小写，先输出次数高的再输出次数低的
如果不用sort，怎么排序（写了个快排)
设计一个餐厅订座系统
有没有做除了自己需求之外的事

2021.3.25 实习一二面
一面
全程挖项目
二面
手撕代码：究极版正则表达式匹配，带星号，加号，问号，句号

# 亚马逊 2021-06-09 实习一二面（已通过）
作者：liyirui
链接：https://www.nowcoder.com/discuss/670416?type=2&order=0&pos=13&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

已拿到offer，希望能转正。

一面：
五十分钟做两道题，最后十分钟提问。

两个有序数组，求他们的中位数。（我写的O(n)的解法，介绍了一下O(logn)的方法的思路）Leetcode-4. 寻找两个正序数组的中位数

两个用链表表示的整数，可能非常大，求他们的差的绝对值，也用链表表示。leetcode上没找到相减，这里有一道相加的。（最后剪完的前0没处理好，时间不够了）Leetcode-2. 两数相加


二面：
聊了一下项目，问了几个基础题

函数传入两个参数，一个是int类型，一个是一个类的对象。请问在函数执行完以后传入的int值是否会改变，对象的属性是否会改变。

讲一下单例模式。

讲一下抖音、快手用到的推荐算法。

讲一下如何对视频按照内容或者质量进行分类。

算法题，不要求写代码，只要求说思路：在一条无穷长的直线上放两个机器人，
机器人只有四种行为，向左、向右、插旗子、查看当前位置是否有旗。
两个机器人受同一条程序控制。问，该程序如何书写才能够让两个机器人面对面相遇。

我的思路：

每秒向右走一步，走一步插一个旗子。执行步骤2。

判断地上是否有旗子，如果没有旗子，执行步骤1；如果有旗子，执行步骤3。

每秒向右走N步（N >= 2）。执行步骤4

判断地上是否有旗子，如果没有旗子，执行步骤5；如果有旗子，执行步骤3。

说明此时已经超过了之前位于它前面的机器人，此时向左回头或者停下来都可以。被超过的机器人几步以后会赶上来。

# 亚马逊 2021-09-04 笔试第三题
作者：牛客851240507号
链接：https://www.nowcoder.com/discuss/731199?type=2&order=0&pos=14&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

笔试第三题是有一个分好的组，每个组有多少个学生。现在要把麦克风分给这些组，而麦克风有多余的，所以要重新分组。重新分组是找最大的进行划分为2部分，详情见实例
求重新分组后小组中最多成员的个数是多少。
示例：
5 7
10 8 6 4 3

5表示组数，7表示麦克风数，下面一行，表示每个组成员的个数。

输出是
6
解释，7-5=2，要做两次调整。
1、先把10划分为两个5，变成[8,6,4,3,5,5]
2、把8划分为两个4，变成[6,4,3,5,5,4,4]
最后得出，人数最多的为6

然后给了两个测试用例
输入：
5 9
100 80 60 40 30
输出：
40

这题是不是有问题，不应该是输出50吗？

100分成60和40，这样最大值就是40了。。。。。

# 亚马逊 2020-09-11 社招内推

作者：Safelanding
链接：https://www.nowcoder.com/discuss/507175?type=2&order=0&pos=16&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

一面 Manager 1h
聊了聊项目，问了一下“你最创新的一个项目是什么？”我讲了一个自己开发的APP，面试官表示认可
一道算法：买卖股票的最佳时机，一次买一次卖，最简单的版本。用了类似单调栈的结构解决，不是最优解
面试官提出了一个比较新的点，即不应该以单纯差价衡量最大利润，而是以利润率来衡量最大利润
二面 Tech 1h
聊了聊实习经历
数据结构：list, set, hash_set, heap的理解
算法1:判断平衡二叉树
算法2:三角矩阵最短路径，用DP实现。
实现完成后又行了两次优化：第一次优化空间复杂度，第二次优化最后获取结果时的遍历操作
反问环节中，了解到国内亚马逊主要做电商中的全球购，说自营因为利润率不高被砍掉了。
至于SDE的职责比较杂，前端、后端、数据挖掘、大数据等都会有。面试官还说如果能做到全栈选择会更多一些，对晋升也更有帮助一些，当然单做后端，保持技术深度也没有问题

# 亚马逊 2021-05-10 实习面经 已通过
作者：狂暴巨鲨
链接：https://www.nowcoder.com/discuss/655789?type=2&order=0&pos=18&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

投的SDE，一二面一起。看了为数不多的几篇亚马逊中国面经，面试难度个人感觉真是看组。
一面:
问项目，
全排列，
二叉搜索树转双向链表，
层次遍历
二面:
问项目里数据库的设计，项目难点
mybatis那些，答的不好，用的太浅
写LRU
准备了很多八股文，国内互联网会问很多源码和底层的设计思想，面了后一直被养鱼。而亚马逊这基本都是原题，微软还会再改编一些，难度对没有JAVA项目的实习生很友好了。
五月了，面了一个多月真的心态崩了，进去了好好学习查漏补缺了_(:з」∠)_

# 亚马逊 2020-10-01 
作者：狗傻
链接：https://www.nowcoder.com/discuss/531857?type=2&order=0&pos=19&page=2&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

一面 1h
面试官自我介绍并且简单介绍了部门的情况。
中文自我介绍，所学专业是做什么的，通俗地讲解一下。
实习的项目和用到的算法。
算法题：套了个电商背景的次模优化问题。大意是有一个必须购买的商品集合，商城搞大促，一些商品捆绑销售。要求用最少的钱去购买一些捆绑商品，使得能够覆盖必买商品。举个例子，比如必须购买的物品列表为{A,B}。{A,C}捆绑销售，售价为10，{B,C}捆绑销售，售价为10，{A,B}捆绑销售，售价为30。那么最少花费20，购买{A,C},{B,C}可以覆盖{A,B}。实习的时候有一部分工作是研究类似的问题，虽然约束和优化目标有所区别。拿到题目先是和面试官确认了一下题意（英文题目，中文交流，那个在线白板只能打英文和数字），试探了数据规模，明确函数接口以及返回值。
反问环节：部门具体业务、技术栈、招人偏好。
二面 1h
面试官自我介绍。
中文自我介绍，挑一个项目讲一下。
算法题：Leetcode上一道非常经典的hard题copy books（这道题没做过的小伙伴强烈建议看一下）。我先扭捏了一下，说了一个二维dp的做法，面试官说复杂度不够好，你再优化优化，提示了答案有单调性。然后我就不装了，写了个二分答案转判定的做法。
反问环节：公司的新人培训、transfer的难度和流程、面试官从国内互联网跳到亚马逊的感受。
两轮面试其实运气更重要一些，大家可能题都做出来了，剩下的选拔和排序的机制如何并不清楚。如果面试官人力足够的情况下，多一些轮次可能会更好一些。

# 此处之后 没有在companyCode中增加统计了
# 亚马逊 2021-06-05
作者：牛客488290605号
链接：https://www.nowcoder.com/discuss/669173?type=2&order=0&pos=20&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

楼主是3月中旬投递的简历，之后很长时间都没有收到过回复，直到5月初，在垃圾邮件里发现了亚麻发来的面试邀请邮件，一度以为和亚马逊无缘了。

后来5月中旬收到亚麻HR电话，约楼主5月21日参加电面，一次约了2面，但是到了5月21日，一面的面试官咕了，所以直接先面了二面，次周的周一（5月24日）才进行了另一轮面试。
最后楼主于本周二（6月1日）收到HR的电话通知楼主面试通过，周三（6月2日）收到Offer。

5月21日一面（1H）：
1.问了项目，问的比较多，主要是详细的问了项目内我担任的工作，询问我是否有做涉及前端的工作。
2.在亚马逊的白板上做题，统计字符串中每个单词出现的次数。

5月24日而面（1H）：
1.自我介绍+详细的询问了楼主的硕士在校研究课题。（第一次遇到问楼主研究课题的面试官！
2.详细的询问楼主的项目，包括楼主在项目中主要担任的职责，在项目中遇到的困难和挑战，抓住楼主项目中一些有优化空间的部分，和可能出现的一些常见问题（大概涉及到消息队列、分库分表和负载均衡）和楼主讨论了一下优化方案。
3.前面2项面完之后大概就差不多一小时了，面试官本来想让楼主写一个LFU，但楼主刚刚把堆的几个基本方法写出来，面试官就打断楼主，说大概了解了，一会还要去开会。（一度以为自己凉了

春招真是太辛苦了 😤终于可以休息2天了

------
悄悄吐槽一下某大厂，刚刚写完突发奇想去查了一下自己的流程，流程已经两个多月了，距离面完也一个多月了，还在鱼池里挂着……

# 亚马逊 2021-04-14
作者：决斗要带着笑
链接：https://www.nowcoder.com/discuss/629159?type=2&order=0&pos=22&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

亚麻的面试跟别的厂不太一样，他在约时间的时候就直接约了两面（而且只有两面，第二轮直接boss面，这个我在面试的时候才知道……）
所以我一开始准备面试的时候准备的都是一面的内容，像经常在二三面时才会问到的系统设计题根本没准备，完全凭潜意识回答的……

一面

自我介绍
项目
手写代码：用的是亚马逊的一个网页编辑器，没有词联想功能，完全手打
Lc15 三数之和=0
Lc486 预测赢家 时间只剩20分钟了，就讲讲思路（dp）
上一个题做出来了，还剩一点时间，所以问了几个八股文
面向对象的三大特征
Java垃圾回收机制
Java多线程的实现方式，用过吗，知道哪些多线程类
Java内存机制
堆的内容
新生代与老生代，永久代
OOD：设计一个停车管理系统，里面会用到哪些类
反问
二面（boss面）

项目（15min）
服务设计&设计里面可能用到的类（45min）
反问
亚麻在我面的几个厂里算是体验最好的了，尤其是二面系统设计的时候，面试官会引导你去思考和解决问题。整体来看，亚麻的题也不算很难吧，我看大家的说法也是，亚麻很看重知识之外的东西，所以重要的是如何在面试的2个小时里把自己展现给面试官。
亚麻也算是我心里比较理想的offer了，所以当收到的时候我就直接接下了。本来还有别的厂正在面，但是也不考虑了……3月终于过去了，卷不动了，不卷了，希望入职之前能把论文投出去吧。

# 亚马逊 2021-05-13 一面社招

作者：这谁能不哭呢
链接：https://www.nowcoder.com/discuss/658372?type=2&order=0&pos=23&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

亚马逊的研发岗位叫做SDE，我面试的就是这个岗位。

一面：

1 多线程的通信，同步方式。面试官问我 volatile 和 synchronized 的区别。 我从底层原理方面讲了两者的实现方式，主要解释了 synchronized 基于 mutex lock 实现，重 量级锁，需要从用户态切换到内核态。volatile 则是通过插入内存屏障的方式，保证变量读 写的可见性。

2 集合类用过哪些 当时回答的是 ArrayList，linkedlist，hashmap 这类简单的集合类，于是面试官就问了 hashmap 的实现原理，以及和 chm 的比较，不同版本 JDK 的区别。也是比较老生常谈的问题了。

3 JVM 的内存模型 说完内存模型的主要情况，面试官开始问我关于内存泄漏和内存溢出相关的问题，也比较简 单，另外还问了 GC 相关的问题。

4 NIO 和 BIO 的区别 主要就是讲述 BIO 的阻塞式 IO 读写，然后讲一下 NIO 的实现原理，相关类，并且说到 IO 多 路复用的实现方式，底层的 epoll 实现方式等等。

5 算法题：实现一个 LRU 只要求实现超过容量时的缓存淘汰，不用处理缓存超时的问题，所以只要写一个双向链表来 存节点即可。另外，不能直接使用 linkedhashmap 实现，所以直接用 hashmap 作为成员变量， 另外写一个含有容量参数的构造方法即可，也是比较常见的问题了。

6 n 个有序链表合并，怎么实现。 刚开始说的是直接合并，然后优化使用多机进行。后来看了一下，可以用最小堆实现。


二面：

这轮是经理面

1 项目

2 项目的多线程问题

3 项目的架构

4 项目的数据库使用，部署方式，缓存部署方式。

5 项目的实际场景

6 讲一下 JVM 的内存分区

7 秒杀系统架构设计 秒杀系统设计也是一个比较常见的问题了。一般可以分几个方面作答。 首先，前端限制访问时间，以及同一 IP 的访问次数。 然后，第一层的服务做负载均衡，比如使用 nginx，然后服务器做集群。 接着，可以用消息队列做削峰和限流，然后做一层缓存，最后只有少量请求到达数据库。 面试官问 nginx 怎么做高可用，前一层能不能再做负载均衡，我回答的是 nginx 也做集群， 前一层可以用硬件负载均衡或者 dns 服务器做第一层负载均衡。 另外面试官还问了如果有 ddos 攻击怎么办，我刚好想到通过人机验证来避免大量肉鸡的攻 击，于是就说了验证码的方式，面试官也说可以。

8 Redis 的分布式部署 说了 Redis cluster 的部署方式，其实就是分片加哨兵的部署方式，另外 Redis 还可以使用 codis 这类***来做分布式。

9 MySQL 的主从部署，读写分离。 这个就是比较常见的 MySQL 部署方案了，稍微说了一下实现方式就没再问了。

10 cap 定理 讲了一下为什么三者只能选两者，这个问题还是挺绕的。 11 负载均衡怎么做

12 kafka 的作用，持久化，其他问题 kafka 之前看了一些比较好的文章，但是时间一久就忘了，于是我就说了读写性能好，以及 多个副本的部署方式。

13 前端解决一些无效的请求过滤，怎么做

14 有什么 offer，为什么想要换工作，工作不注重稳定性吗？想去哪里工作。

# 面经
作者：浅前
链接：https://www.nowcoder.com/discuss/519269?type=2&order=0&pos=39&page=1&source_id=discuss_tag_nctrack&channel=-1&gio_id=C453B3ADA6CA6DF41D80E167026E0409-1634401711081
来源：牛客网

背景：硕 2 年 Java 开发

之前面试看了不少牛客的面经，这里记录了最近面试的一些问题，回馈下社区。
（不是全部的面试，只记录了部分）

亚马逊二面
项目介绍
算法题：平衡二叉树
算法题：三角形最小路径（下一层长度大于等于上一层长度）
亚马逊一面
项目介绍
设计 TinyURL
快手商业化二面
设计一个定时触发的生产者消费者
给定 log 日志，每行代表用户进入的开始时间和离开时间。统计当天最高的同时在线人数。
给定 list，表示 id，可能重复。要求用 stream 实现 list -> map 的转换，map 统计 id 出现的次数。
shutdown 和 shutdownNow 的区别
什么状态的线程可以中断
网易有道二面
部门介绍
系统设计题：假设有 10-100 万的词条。每天定时更新。要求系统高可用，更新完成时间尽量快。
系统设计题：假设客户端有一个大文件与服务端同步。已知文件中某处被修改，请设计一个算法更新被修改的部分。
反问：网易的培养体系
一般性培养：

技术上独当一面的能力
软技能：对结果负责
再进一步：
结合个人意愿，提高技术影响力
发挥大于 1 的价值
快手一面
JVM 运行时区域
常见的堆内存溢出情况
JVM 内存分配策略
FullGC 的触发条件有哪些
锁升级的过程
volatile 如何保证可见性的
分布式事务的解决方案
MySQL 聚簇索引与普通索引的区别
为什么要建前缀索引
B 树和 B+ 树的比较
联合索引
Redis 主从复制的过程
Redis 跳表的实现
Redis 实现分布式锁
Linux 打印文件第 10-20 行
Linux 查看当前目录大小
Linux 查看网络端口占用
算法题：旋转有序数组的最小值（含重复元素）
京东基础架构三面（8.17）
简单介绍下 RabbitMQ
RabbitMQ 如何保证消息一致性的
开启 ACK 后的具体流程是怎样的
RabbitMQ 如何保证高可用的
RabbitMQ 集群模式下主宕机了如何选主
线上机器 CPU 突然增高如何处理
接口不定时出现高时延如何处理
处理过哪种线上问题
如何加速计算 1+2...+100
京东基础架构二面
项目介绍（责任链模式和数据一致性）
算法题：在一场活动中，已知参加活动的人数先缓慢增加，达到峰值后再逐渐减少，求峰值
算法题：假设有一个接口，QPS 在万级别，每次访问均统计了时延，求时延的 TP99
为什么选择消息中间件组
介绍下 Redis
实习或之前还做过什么项目
BIGO 三面
自我介绍
项目介绍
项目中遇到的技术难题有哪些（线上问题排查）
Spring AOP 底层实现
Redis 如何进行容灾
Redis 哨兵是怎样的一个机制
如何评估服务的能力？怎么压测你的服务？
出于什么考虑想找一份新工作
你希望的工作内容或工作方式？
算法题：0-n 中缺失的数字
算法题：微信红包算法
系统设计：每天 100 万微博的存储系统设计
MySQL 如何平滑扩展
京东物流二面
自我介绍
项目介绍
项目难点（线上问题排查）
消息队列的选型
Spring AOP 原理和应用
链路追踪
最近在学什么技术
Kafka 如何做到高性能
网易有道一面
如果因为 MQ 引起的发送失败，怎么处理？
消息队列和 HTTP 调用的区别是什么？
如果 HTTP 调用也失败了怎么办？
消息队列消息堆积了几个小时数据怎么处理？
为什么不直接扩展消费端呢？而是引入新的消息队列？
MQ 有哪些应用场景？这里主要用来解决什么问题呢？
网关选型 Zuul 和 Spring Cloud Gateway
Eureka 服务发现的原理
服务发现选型应该要考虑的因素有哪些？
MySQL 性能优化指什么？
MySQL 优化的经验或知识？
为什么使用索引可以加速查询？
为什么 B+ 树和 IO 次数有关系？
除了我以上问的，其他觉得有擅长但是没有问到的吗？
Spring IOC 原理
Spring 如何解决循环依赖的问题
比较熟悉的数据结构有哪些？
算法题：判断一个链表是否有环
系统设计题：准备一批文本，收集用户的录音。用户获取待读文本，然后提交。要求每个文本只能被读一次，以及统计每个用户读了多少条。
建议：了解用到技术的原理

小马智行一面
算法题：

数据流的中位数，要求提供 add、delete、getMedian 三个接口。

BIGO 二面
项目中做的工作包括哪些
服务治理做的相关工作
Eureka 服务发现的主要功能
Eureka 服务有多少个实例
Eureka 服务同步每次都是全量吗
Eureka 服务发现的数据一致性
Eureka 如何保证数据可靠性，如何确认是一致的
Eureka 如果实例数太多，会面临同步的问题吗
Zuul 限流是如何实现的
限流是这一层起作用还是下一层起作用
为什么要在你这一层去做呢？那如何保护自身呢？
限流的实现方式，有哪几种算法
时间窗口与令牌桶的对比
配置管理是如何实现的
应用配置的场景
为什么选择 zk 做配置管理
为什么不用 zk 做服务注册
怎么防止雪崩、服务过载这些
网络平时有遇到什么问题吗？
服务间调用丢包、传输速度慢，怎么去解决？
如何查看连接是否丢包
大量的连接导致短暂的瘫痪状态，怎么去解决？
HTTP 1.0 和 HTTP 2.0 的区别
HTTP 2.0 做了哪些优化
同一个域名复用一个连接是如何实现的？
Redis 在项目中用在哪里
Redis 常见的数据结构
Sorted Set 是如何实现的
跳表如何实现 log n 的，跳表的实现原理
为什么选择跳表来实现 Sorted Set
常见的垃圾回收算法有哪些，各自算法的优缺点
算法题：一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序
follow up：输出一个序列的所有可能的弹出顺序
反问：

北京负责的业务？直播业务线、视频业务线、社交软件业务线
全球产品与国内的区别？运营形态不一样，文化宗教冲突，跨区服务器
BIGO 一面
介绍下项目的大体框架
你负责哪几部分
流量 QPS 估计
网关里的限流、黑白名单这些功能是自带的还是自己实现的
有了解过 nginx 吗
nginx 和 网关的关系是什么
服务发现的原理
Eureka 的容灾
自我保护期间请求怎么处理
订单的数据一致性如何实现的
支付没有通知会怎么处理？
详细介绍一下本地消息表
服务是分布式多节点的，数据呢？
假设数据库分散在全国国内，如何处理请求分布到不同地点的数据库中
假设在北京下订单，但是跑到广州还款，如果就近原则的话， 连的数据库就不一样了，怎么处理？
能不能用一个策略，某个用户的数据指定到一个库去执行
Java 8 CompletableFuture 的原理
Future 的实现原理？Future 有哪些不好的地方
集合类型的遍历方式有哪些
集合 foreach 的 API用过吗
LinkedHashMap 和 TreeMap 的区别
TCP 为什么要四次挥手
假设客户端断开连接，服务器不停发数据不断开，这是允许的吗
客户端收到 FIN 后回的 ACK 丢了怎么办
为什么要等待 2 倍的 MSL 时间
select、poll 和 epoll 的区别
NIO 模型
简单描述下 Redis
Redis 的几种常用数据结构
如何实现一个分布式的栈
算法题：给定一个整数数组 a 和一个哈希表 b，b 指定了 a 中的位置，根据 b 调整 a 的位置，如果 b 中的数字 a 不存在，也需要插入。
美团基础架构二面
做服务发现时有遇到什么问题吗？
Eureka 损失了一致性会带来什么问题呢？
Eureka 有主吗？怎么实现的同步？如果遇到了不一致的问题，谁说了算？
如果多个节点同时尝试注册会有问题吗？
Eureka 内部采用的一致性算法是什么算法？
项目历时时间多久？
项目中遇到的技术难题是什么？
改进前使用的是什么垃圾收集器？
用了 CMS 之后配置了哪些参数？
列举常见的一致性算法？
介绍 Paxos 原理？缺点是什么？
本机宕机了怎么办？消息表会丢失的？
数据存在哪里？消息表存在磁盘或者内存还是远程的数据库？
本地消息表的缺点和优点是什么？
消息系统用的是什么组件？有消息重复的现象？
jdk1.8默认的垃圾收集器是哪个？
看过jdk哪方面的源码？
常用的container有哪些？
HashMap 和 HashTable的区别是什么？
Spring 的原理是什么？
介绍切面的底层实现
使用 zk 的时候有遇到什么问题吗？
研究最深入的组件是哪个？有哪些看过源码？
IOC 的本质是什么？
Mysql 的事物隔离级别有哪几种？有什么区别？
有看过 Mysql 的源码吗？
NIO 了解吗？是什么？
Linux 有多少种IO模型
常用的数据结构有哪些？
二叉树里了解哪些？
平衡树是用来做什么的？
B+树的特点是什么？
多线程并发的类有哪些？
信号量主要用来做什么？
编程题: 实现一个读写锁
美团基础架构一面
介绍下 JVM 堆栈模型，工作机制
哪些资源是线程私有/共有？
栈具体在做什么事情？
介绍java的线程池的原理和调度机制
介绍线程池的拒绝策略
如何释放线程池中的线程
核心线程数如何释放，可以通过线程空闲时间来控制释放吗？
shutdown, shutdown now 的区别？
锁
常用的锁有哪些？
synchronized 和 ReentrantLock 的区别？他们需要手动的释放吗？
介绍一下乐观锁，缺点是什么？如何保证原子性？
常用的垃圾回收算法有哪些？
描述新生代的回收过程，EMCC的回收过程？
怎么确定对象是否应该被释放？
描述NIO的概念
内核态IO的复用的机制？
TCP 如何保证可靠性的？
HashMap 是如何实现的？
ConcurrentHashMap 是如何实现的？
kafka的基本原理和架构？
不同的 partition 之间如何容灾备份？
同步时 high water
RabbitMQ 如何实现容灾？
RabbitMQ 发生脑裂怎么处理？
项目中遇到的难点是什么？如果解决的？
付款过程中的一致性怎么保证的？
滴滴二面
JVM 分配内存的过程
TLAB 的工作机制
TLS
CMS 并发收集，如何记录未收集的表
算法题：合并 K 个链表
算法题：火车排队
概率题：圆上任意两个弦相交的概率
MySQL 平滑迁库
MySQL 索引
MySQL 如何建索引
滴滴一面
百度 ACG AI商业平台部一面
API 是 RESTFul 风格的吗？设计的时候有哪些规则？用户 ID 和订单 ID 会在 url 中吗？
Hadoop、Spark、Docker 技术熟悉吗？
如何查看进程 ID 内有多少线程？
查看磁盘信息 df 命令卡住了，如何排查问题？
如何查看进程所使用的系统调用？
分布式事务，两阶段提交，TCC
进程、线程、协程的区别
虚拟地址如何转到物理地址
进程中的堆区和栈区
僵尸进程
HTTP Get 和 Post 的区别
HTTP API 如何设计幂等接口
如何设计 HTTP 长连接
http2、http3
快排的基本原理
数组和链表的区别
算法题：反转链表
算法题：求二叉树深度
Redis 项目中的使用
Redis 分布式锁
高并发的时候是怎么处理的？（消息队列、多线程）
ORM 框架的 SQL 注入是如何解决的
事务死锁如何排查？
并发更新同一条记录如何解决事务死锁？
MySQL 乐观锁和悲观锁
Java 单例模式
Java 原子操作
反问：
商业平台的难点：
对接存储：hadoop、对象存储 boos
大数据计算：k8s、spark，大批量数据处理
算法

京东基础架构一面
研究生阶段研究课题是什么？
责任链模式，更新的时候有并发怎么办？
责任链模式的动态配置时如何修改的？
RabbitMQ 发送失败怎么办？
消息主键 ID 是一样的，如何去重？
RabbitMQ 发送重复怎么处理？
Zookeeper 主要使用什么功能？
Zookeeper 怎么实现命名服务？
Zookeeper 怎么实现分布式锁？
Zookeeper 选主过程
Zookeeper 是如何避免或处理脑裂的？
线上 RabbitMQ 积压如何处理？
怎么保证数据一致性的？
Zookeeper 挂了怎么办？
MySQL 查询慢怎么优化？
什么情况下需要加索引？
什么情况下不需要加索引？
什么情况下索引不生效？
binlog 是什么？
Redis 的数据类型有哪些？除了常用的还有什么吗？
Redis 的持久化机制
Redis 的哨兵机制，与 Redis 集群有什么区别
HashMap 的插入一条数据的过程
HashMap 分别初始化大小 1k 和 10k，分别放 1k 和 10k 的数据，都会触发扩容吗？
ConcurrentHashMap 的实现方式，跟 HashTable 有什么区别？
线程池的参数和每个参数的含义
线程池的工作队列有哪些？如何选择？
RPC 框架有用过吗？
有哪几种垃圾回收器？CMS 和 G1 的区别？
CMS 的优点有哪些？G1 的优点有哪些？
方法区的作用
JVM 编译优化有哪些
synchronized 和 volatile 的区别
synchronized 和 ReentrantLock 的区别
常用的设计模式
JDK 有用到哪些设计模式
算法题：1-n 数中找第 k 大的数字。follow up：数据流中取第 k 大呢？
京东物流一面
项目中用到的技术架构
数据一致性是如何保证的？
Spring Bean 实例化有哪几种方式？
Spring 注解这种方式如何使用？
Spring 注入的方式？
@Autowired 和 @Resource 区别
Spring MVC 处理请求的过程，用到了什么设计模式
责任链模式和策略模式的区别
Integer 的缓存范围，这是什么设计模式
a == 1 为什么会报 NullPointerException
二分查找与顺序查找、树查找的比较
Mybatis 二级缓存原理
Redis 底层数据结构
Redis String 类型的最大容量
Redis 如何实现分布式锁
XA 事务和 TCC 的区别
如何解决 XA/TCC 的单点问题（数据分片）
腾讯-广告后台开发工程师一面
自我介绍
项目介绍
为什么使用消息队列？
消息队列选型，用 RabbitMQ 为什么不是 Kafka？（没答好）
什么时候出现数据不一致的情况？
为什么选择本地消息法做分布式事务？
什么是TCC，它的工作过程？
TCC 和 XA 的区别？
如果让你优化XA，你会如何优化？
你如何理解高可用性？
假设RabbitMQ宕机了，怎么保证服务仍然可用？
你们是如何做服务监控的？高可用级别？几个9？
skywalking 的监控原理
为什么用微服务架构？有什么优点？
拆分服务模块是如何考量的？
MySQL 的事务隔离级别？为什么选择这个隔离级别？什么是幻读？
MySQL 是如何实现事务的四大特性的？
简单说下 MVCC 的工作原理。
synchronized 和 ReentrantLock
为什么使用 ReentrantLock 而不是 synchronized？
synchronized 和 ReentrantLock 性能上的差别？
锁升级机制？轻量级锁自旋的过程？
CAS 还需要获取锁吗？
写个单例模式，选一种你觉得最合适的。（静态内部类和懒汉模式）
为什么用静态内部类？
为什么要加在实例前 volatile 关键字？
服务发现为什么用 Eureka？还有哪些实现方案？如何选型？
SpringBoot 的优势在哪？有哪些功能？
IOC 和 AOP 简单解释一下
AOP 的实现原理？动态代理是如何实现的？

# 2020-09-21 社招2年研究生
亚马逊二面
项目介绍
算法题：平衡二叉树
算法题：三角形最小路径（下一层长度大于等于上一层长度）
亚马逊一面
项目介绍
设计 TinyURL