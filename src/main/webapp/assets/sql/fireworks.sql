/*
 Navicat Premium Data Transfer

 Source Server         : ChenJY's MySQL
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : fireworks

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 03/27/2018 17:00:38 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Activity`
-- ----------------------------
DROP TABLE IF EXISTS `Activity`;
CREATE TABLE `Activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Activity`
-- ----------------------------
BEGIN;
INSERT INTO `Activity` VALUES ('49', '四天雨天之后，终于天气放晴！', '2018-03-23 16:50:49', '上海', ''), ('50', '最近看了几本怀旧的小说，有点想看看九十年代中国的样子了', '2018-03-23 16:50:59', '上海', ''), ('52', '国足确实还有好长的路要走啊', '2018-03-23 16:54:57', '上海', '');
COMMIT;

-- ----------------------------
--  Table structure for `Blog`
-- ----------------------------
DROP TABLE IF EXISTS `Blog`;
CREATE TABLE `Blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogName` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `blogTitle` varchar(255) DEFAULT NULL,
  `blogTag` varchar(255) DEFAULT NULL,
  `viewCount` int(10) DEFAULT NULL,
  `favouriteCount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `Blog`
-- ----------------------------
BEGIN;
INSERT INTO `Blog` VALUES ('3', '2014-06-12-gaokao.md', '2014-06-12 00:00:00', '停留是刹那，转身是天涯', '', '0', '0'), ('4', '2015-01-06-cherish-everyday.md', '2015-01-06 00:00:00', '且行且珍惜', '', '0', '0'), ('5', '2015-11-03-old-time.md', '2015-11-03 00:00:00', '等不及的旧时光', '', '0', '0'), ('6', '2015-11-09-visit-SZU.md', '2015-11-09 00:00:00', '反正地球本来就很圆', '', '0', '0'), ('7', '2015-12-14-sanmao.md', '2015-12-14 00:00:00', '韶华易逝，皆付红尘', '', '0', '0'), ('8', '2015-12-30--movie-laopao.md', '2015-12-30 00:00:00', '老炮儿', '', '0', '0'), ('9', '2015-12-31-new-year.md', '2015-12-31 00:00:00', '2015  愿你们都幸福安好~', '', '0', '0'), ('12', '2016-02-12-i-will-make-it.md', '2016-02-12 00:00:00', '我要做到，这就是我的人生', '', '0', '0'), ('13', '2016-03-04-she-is-nice.md', '2016-03-04 00:00:00', '这样的她，璀璨明亮', '', '0', '0'), ('17', '2016-06-25-Cameron-speech.md', '2016-06-25 00:00:00', '英国公投脱欧 卡梅伦辞职演说全稿', '', '0', '0'), ('18', '2016-07-01-Android-QRCode-Scan.md', '2016-07-01 00:00:00', '暑期大作业Android相关整理', '', '0', '0'), ('20', '2016-07-13-what-makes-you-know-tem.md', '2016-07-13 00:00:00', '【转载】有没有一张图片让你瞬间明白了什么叫「气质」', '', '0', '0'), ('21', '2016-07-16-functional-programing.md', '2016-07-16 00:00:00', '收藏的关于函数式编程思想的文章', '', '0', '0'), ('22', '2016-07-16-law-spirit-in-HongKong.md', '2016-07-16 00:00:00', '【转载】《寒战》中折射出的香港法治精神', '', '0', '0'), ('23', '2016-09-25-recitation1.md', '2016-09-25 00:00:00', 'Recitation 1 Worse is Better ', '', '0', '0'), ('24', '2016-10-05-AndroidBug.md', '2016-10-05 00:00:00', '暑期大作业Android相关整理', '', '0', '0'), ('25', '2016-10-06-recitation2.md', '2016-10-06 00:00:00', 'Recitation 2 A Fast File System for UNIX ', '', '0', '0'), ('26', '2016-10-07-AndroidUI.md', '2016-10-07 00:00:00', '暑期大作业Android相关整理', '', '0', '0'), ('27', '2016-10-15-strangers-story.md', '2016-10-15 00:00:00', '陌生人的故事', '', '0', '0'), ('28', '2016-10-18-recitation3.md', '2016-10-18 00:00:00', 'Recitation 3 Eraser: A Dynamic Data Race Detector for Multithreaded Programs ', '', '0', '0'), ('29', '2016-11-07-keluoze.md', '2016-11-07 00:00:00', '【转载】你带走的，是我们的青春', '', '0', '0'), ('30', '2016-12-07-OpenGL.md', '2016-12-07 00:00:00', 'OpenGL读取obj文件模型', '', '0', '0'), ('31', '2016-12-08-hongchenfireworks.md', '2016-12-08 00:00:00', '红尘烟火 ——《碎片》征文作品', '', '0', '0'), ('33', '2016-12-31-new-year-2017.md', '2016-12-31 00:00:00', '2016 年关曲调', '', '0', '0'), ('34', '2017-01-12-headfirst-designpatterns.md', '2017-01-12 00:00:00', '设计模式一 —— 单例模式', '', '0', '0'), ('35', '2017-04-14-java-memory-area.md', '2017-04-14 00:00:00', '深入理解java虚拟机 —— java 内存模型', '', '0', '0'), ('36', '2017-04-17-GC.md', '2017-04-17 00:00:00', '深入理解java虚拟机 —— Java GC简述', '', '0', '0'), ('37', '2017-04-27-GC-algorithm.md', '2017-04-27 00:00:00', '深入理解java虚拟机 —— Java GC算法', '', '0', '0'), ('38', '2017-04-28-class-load.md', '2017-04-28 00:00:00', '深入理解java虚拟机 —— 类加载机制', '', '0', '0'), ('39', '2017-05-01-class-loader.md', '2017-05-01 00:00:00', '深入理解java虚拟机 —— 类加载器', '', '0', '0'), ('40', '2017-05-04-java-volatile.md', '2017-05-04 00:00:00', '深入理解java虚拟机 —— Java内存模型和volatile关键字', '', '0', '0'), ('41', '2017-05-09-java-thread.md', '2017-05-09 00:00:00', '深入理解java虚拟机 —— Java 线程', '', '0', '0'), ('42', '2017-05-11-thread.md', '2017-05-11 00:00:00', '谈谈普通的线程', '', '0', '0'), ('43', '2017-05-13-thread-security.md', '2017-05-13 00:00:00', '深入理解java虚拟机 —— Java 线程安全', '', '0', '0'), ('44', '2017-05-14-lock-optimization.md', '2017-05-14 00:00:00', '深入理解java虚拟机 —— Java 锁优化', '', '0', '0'), ('45', '2017-07-17-mybatis-architecture.md', '2017-07-17 00:00:00', '【转载】MyBatis的架构设计以及实例分析', '', '0', '0'), ('46', '2017-07-25-how-to-improve-search-efficiency.md', '2017-07-25 00:00:00', '【转载】在一个千万级的数据库查寻中，如何提高查询效率？', '', '0', '0'), ('47', '2017-07-28-db-isolation.md', '2017-07-28 00:00:00', '数据库事务 ACID 和 隔离级别', '', '0', '0'), ('48', '2017-07-28-sth-about-network.md', '2017-07-28 00:00:00', '计算机网络 —— 网络分层架构', '', '0', '0'), ('49', '2017-07-29-copy.md', '2017-07-29 00:00:00', '【转载】java 中的深拷贝和浅拷贝', '', '0', '0'), ('50', '2017-07-29-https-cookie-session.md', '2017-07-29 00:00:00', 'HTTP & HTTPS, Session & Cookie', '', '1', '0'), ('51', '2017-07-31-concurrenthashmap.md', '2017-07-31 00:00:00', '【转载】Java 集合类 —— ConcurrentHashMap 初探', '', '0', '0'), ('52', '2017-07-31-spring-ioc-aop.md', '2017-07-31 00:00:00', 'Spring 加载过程 & IOC & Spring AOP', '', '0', '0'), ('53', '2017-07-31-springmvc.md', '2017-07-31 00:00:00', '聊一聊 Spring MVC', '', '0', '0'), ('54', '2017-08-01-java-memory-leak.md', '2017-08-01 00:00:00', '【转载】Java 内存泄漏及避免方法', '', '0', '0'), ('55', '2017-08-02-algorithm-treeorder.md', '2017-08-02 00:00:00', '【转载】Java 递归、非递归遍历二叉树', '', '0', '0'), ('56', '2017-08-02-java-threadpool.md', '2017-08-02 00:00:00', 'Java 线程池介绍', '', '0', '0'), ('57', '2017-08-03-is-list-cycle.md', '2017-08-03 00:00:00', 'Java 判断单链表是否有环', '', '0', '0'), ('58', '2017-08-03-tcp-connection.md', '2017-08-03 00:00:00', '计算机网络 —— TCP、UDP 和 ARP 的知识点总结', '', '0', '0'), ('59', '2017-08-07-sort-algorithm.md', '2017-08-07 00:00:00', '各种排序算法总结', '', '0', '0'), ('60', '2017-08-25-consistent-hash.md', '2017-08-25 00:00:00', '一致性哈希算法详解', '', '0', '0'), ('61', '2017-08-25-readwritelock.md', '2017-08-25 00:00:00', '【转载】Java的读写锁', '', '0', '0'), ('62', '2017-08-30-java-reflect.md', '2017-08-30 00:00:00', 'Java 注解工作原理', '', '0', '0'), ('63', '2017-11-09-talk-about-architecture-in-website.md', '2017-11-09 00:00:00', '网站技术架构总结', '', '0', '0'), ('64', '2017-11-25-redis-data-structure.md', '2017-11-25 00:00:00', 'Redis 内部数据结构及存储方式', '', '0', '0'), ('65', '2017-11-30-saysth-about-techbook.md', '2017-11-30 00:00:00', '我理解的: 什么是一本好的技术书籍', '', '0', '0'), ('66', '2017-12-09-arraylist-source-code.md', '2017-12-09 00:00:00', 'ArrayList 源码分析', '', '0', '0'), ('67', '2017-12-10-linkedlist-source-code.md', '2017-12-10 00:00:00', 'LinkedList 源码分析', '', '0', '0'), ('68', '2017-12-11-hashmap-source-code.md', '2017-12-11 00:00:00', 'HashMap 源码分析', '', '1', '1'), ('69', '2017-12-19-priorityqueue-source-code.md', '2017-12-19 00:00:00', 'PriorityQueue 源码分析', '', '1', '1'), ('70', '2017-12-25-how-to-add-https-githubpages.md', '2017-12-25 00:00:00', '在 Github Pages 搭建的静态博客中添加 https 访问', '', '0', '0'), ('71', '2017-12-31-about-2017.md', '2017-12-31 00:00:00', '2017 年终总结', '', '1', '0'), ('72', '2018-01-05-redis-replication.md', '2018-01-05 00:00:00', '小议 Redis 的主从复制功能', '', '2', '0'), ('73', '2018-01-07-translation-redis-replication.md', '2018-01-07 00:00:00', '【译】Redis Replication', '', '1', '0'), ('74', '2018-01-26-threadlocal-source-code.md', '2018-01-26 00:00:00', '深入解析 ThreadLocal 和 ThreadLocalMap', '', '3', '1'), ('75', '2018-01-29-linkedBlockingQueue-source-code.md', '2018-01-29 00:00:00', 'LinkedBlockingQueue 源码分析', '', '7', '3');
COMMIT;

-- ----------------------------
--  Table structure for `Photograph`
-- ----------------------------
DROP TABLE IF EXISTS `Photograph`;
CREATE TABLE `Photograph` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` longtext,
  `desc` varchar(255) DEFAULT NULL,
  `filmDateAndPlace` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Photograph`
-- ----------------------------
BEGIN;
INSERT INTO `Photograph` VALUES ('1', 'http://o9oomuync.bkt.clouddn.com/bloghometown.jpeg', '年关的家乡', '2018.02 摄于张家港乐余镇', '2018-03-26 15:24:02'), ('2', 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170921164059.jpg', '东南大学毕业照拍摄地', '2017.09 摄于东大四牌楼校区', '2018-03-26 15:24:02'), ('3', 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170921161442.jpg', '暴风雨来临前的晚霞', '2017.09 摄于东二十六楼寝室阳台', '2018-03-26 15:24:02'), ('4', 'http://o9oomuync.bkt.clouddn.com/blog%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20170711192848.jpg', '阵雨过后远处的上海中心', '2017.08 摄于来安路', '2018-03-26 15:24:02'), ('5', 'http://o9oomuync.bkt.clouddn.com/bloglove.jpg', '球场看台上的求婚', '2017.05 摄于上海八万人体育场', '2018-03-26 15:24:02'), ('6', 'http://o9oomuync.bkt.clouddn.com/blogHackathon.jpg', '2016 Microsoft Penta-Hackathon', '2016.11 摄于微软紫竹亚研院', '2018-03-26 15:24:02'), ('7', 'http://o9oomuync.bkt.clouddn.com/blogmuseum.jpg', '唐朝彩色侍女佣像', '2016 年中秋摄于上海博物馆', '2018-03-26 15:24:02'), ('8', 'http://o9oomuync.bkt.clouddn.com/blogbinjiang_park.jpg', '初春公园门口的风筝摊', '2016.04 摄于闵行区滨江公园外', '2018-03-26 15:24:02'), ('9', 'http://o9oomuync.bkt.clouddn.com/blogmilitary_training.jpg', '大一军训晚会', '2015.09 摄于上海交通大学霍英东体育馆', '2018-03-26 15:24:02'), ('10', 'http://o9oomuync.bkt.clouddn.com/blogstadium.jpg', '2015 赛季中超首轮', '2015.03 摄于上海八万人体育场', '2018-03-26 15:24:02'), ('11', 'http://o9oomuync.bkt.clouddn.com/blogWechatIMG26.jpeg', '梁丰大礼堂', '2015.01 摄于梁丰高级中学', '2018-03-26 15:57:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
