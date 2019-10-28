-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: springBoot
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父类id',
  `type` int(11) DEFAULT NULL COMMENT '父类类型',
  `commentor` int(11) DEFAULT NULL COMMENT '评论人id',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  `like_count` bigint(20) DEFAULT NULL,
  `content` varchar(1024) CHARACTER SET utf8 NOT NULL,
  `comment_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,1,1,1567211711183,1567211711183,NULL,'测试数据',0),(2,2,1,1,1567211770290,1567211770290,NULL,'测试数据',0),(3,1,1,1,1567211862289,1567211862289,NULL,'测试数据',0),(4,1,1,1,1567211962371,1567211962371,NULL,'测试数据',0),(5,12,1,1,1567212049132,1567212049132,NULL,'测试数据',0),(6,1,1,1,1567212051248,1567212051248,NULL,'测试数据',0),(7,1,1,1,1567212051867,1567212051867,NULL,'测试数据',0),(8,1,1,1,1567212071156,1567212071156,NULL,'测试数据',0),(9,1,1,1,1567212082884,1567212082884,NULL,'测试数据',0),(30,1,1,1,1567214030171,1567214030171,NULL,'测试数据',0),(31,12,1,1,1567233862675,1567233862675,1,'测试数据',0),(32,12,1,1,1567233975896,1567233975896,1,'测试数据',0),(33,21,1,1,1567235126849,1567235126849,1,'测试数据',0),(34,21,1,1,1567240667338,1567240667338,1,'测试数据',0),(35,21,1,1,1567240713749,1567240713749,1,'我的ajax请求',0),(36,11,1,12,1567240887814,1567240887814,1,'测试ajaca',0),(37,11,1,12,1567241478157,1567241478157,1,'你好！',0),(38,11,1,12,1567241481548,1567241481548,1,'你好！',1),(39,11,1,12,1567241491285,1567241491285,1,'你好！',0),(40,11,1,12,1567241558717,1567241558717,1,'你好！',0),(41,11,1,12,1567241914854,1567241914854,0,'你好啊！',0),(42,11,1,12,1567241974140,1567241974140,0,'哈哈！',0),(43,11,1,12,1567244065294,1567244065294,0,'风格',0),(44,11,1,12,1567249499659,1567249499659,0,'先查出',0),(45,11,1,12,1567249641618,1567249641618,0,'cv ',1),(46,11,1,12,1567296078399,1567296078399,0,'我觉得也是！',0),(47,22,1,12,1567300418037,1567300418037,0,'没你哈',0),(48,22,1,12,1567300488330,1567300488330,0,'haha ',0),(49,11,1,12,1567300524776,1567300524776,0,'你好啊',1),(50,22,1,12,1567304209112,1567304209112,0,'haha ',0),(51,11,1,12,1567327117621,1567327117621,0,'你好！',6),(52,51,2,12,1567328242256,1567328242256,0,'你好！',0),(53,51,2,12,1567328261712,1567328261712,0,'二级评论测试',0),(54,51,2,12,1567413686568,1567413686568,0,'haha ',NULL),(55,49,2,12,1567413760720,1567413760720,0,'你说的是！',NULL),(56,51,2,12,1567413958048,1567413958048,0,'你傻！',NULL),(57,51,2,12,1567517522471,1567517522471,0,'haha ',NULL),(58,26,1,12,1567673230228,1567673230228,0,'好好学习sql语句。',NULL),(59,58,2,12,1567674478892,1567674478892,0,'你说的对！',NULL),(60,26,1,12,1567840374970,1567840374970,0,'CRUD哦！',NULL),(86,14,1,12,1567933372618,1567933372618,0,'sd ',NULL),(87,19,1,12,1567942743272,1567942743272,0,'hao !\n',NULL),(99,19,1,12,1567943542406,1567943542406,0,'hahah ',NULL),(101,23,1,12,1568022277855,1568022277855,0,'你好啊！',NULL),(104,51,2,12,1568022870891,1568022870891,0,'哈哈！',NULL),(105,45,2,12,1568025565202,1568025565202,0,'你是傻子吗',NULL),(106,101,2,12,1568098801313,1568098801313,0,'你好！',NULL),(107,38,2,12,1568100315226,1568100315226,0,'你好!',NULL),(108,11,1,12,1568100324232,1568100324232,0,'hah !!',NULL),(109,30,1,12,1568188814022,1568188814022,0,'好！',NULL),(110,109,2,12,1568188823907,1568188823907,0,'啊哈哈',NULL),(111,32,1,12,1568358917473,1568358917473,0,'没错！',NULL),(112,32,1,12,1568359325153,1568359325153,0,'哈哈',NULL),(113,28,1,12,1568425792941,1568425792941,0,'haha ',NULL),(114,30,1,12,1570761676809,1570761676809,0,'很好啊！没啥问题。',NULL),(115,30,1,12,1570778610855,1570778610855,0,'陈玉琳吶，如果有机会，我想照顾你一辈子，我不在乎你以前发生的事，就是想让你开心。',NULL),(116,115,2,12,1570843672585,1570843672585,0,'我现在才发现你身上发生了很多事，你还保持这种乐观积极向上的态度去迎接生活，你真的很伟大，我在想，如果你没有得这种病，或许我们会不会真的在一起，一起生孩子，将孩子抚养大，一起度过余生。可是这毕竟不现实，请好好生活，不要害怕疾病！',NULL),(117,115,2,12,1570843720262,1570843720262,0,'也许我也很怂。',NULL),(118,115,2,12,1571225619821,1571225619821,0,'好烦，感觉我迈不出这步。',NULL),(119,115,2,12,1571225643207,1571225643207,0,'要是你没这病该有多好。',NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notifier` int(11) DEFAULT NULL COMMENT '回复的人',
  `receiver` int(11) DEFAULT NULL COMMENT '消息接收者',
  `outer_id` int(11) DEFAULT NULL COMMENT '外键',
  `notified_type` int(11) DEFAULT NULL COMMENT '回复或者评论',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `notified_status` int(11) DEFAULT '0' COMMENT '消息未读或者已读',
  `notifier_name` varchar(100) DEFAULT NULL,
  `out_title` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (2,12,12,14,1,1567933372646,1,'TomAlen','如何学习springboot'),(3,12,12,19,1,1567942743296,1,'TomAlen','如何学习数据结构'),(4,12,12,19,1,1567943542435,1,'TomAlen','如何学习数据结构'),(5,12,12,23,1,1568022277888,1,'TomAlen','如何学习springboot'),(6,12,12,11,2,1568022870923,1,'TomAlen','如何学习springboot'),(7,12,12,11,2,1568025565230,1,'TomAlen','如何学习springboot'),(8,12,12,23,2,1568098801341,1,'TomAlen','如何学习springboot'),(9,12,12,11,2,1568100315260,1,'TomAlen','如何学习springboot'),(10,12,12,11,1,1568100324237,1,'TomAlen','如何学习springboot'),(11,12,12,30,1,1568188814043,1,'TomAlen','这段HTML代码'),(12,12,12,30,2,1568188823909,1,'TomAlen','这段HTML代码'),(13,12,12,32,1,1568358917493,1,'TomAlen','看看我这代码！'),(14,12,12,32,1,1568359325176,1,'TomAlen','看看我这代码！'),(15,12,12,28,1,1568425792960,0,'TomAlen','看看我这代码！'),(16,12,12,30,1,1570761676839,0,'TomAlen','这段HTML代码'),(17,12,12,30,1,1570778610882,0,'TomAlen','这段HTML代码'),(18,12,12,30,2,1570843672606,0,'TomAlen','这段HTML代码'),(19,12,12,30,2,1570843720265,0,'TomAlen','这段HTML代码'),(20,12,12,30,2,1571225619857,0,'TomAlen','这段HTML代码'),(21,12,12,30,2,1571225643220,0,'TomAlen','这段HTML代码');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (11,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,14,244,0,'java,springboot'),(13,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,0,22,0,'kk'),(14,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,1,18,0,'kk'),(15,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,0,14,0,'kk'),(16,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,0,13,0,'kk'),(17,'如何学习springboot','多敲代码！',1566868707644,1566868707644,12,0,26,0,'kk'),(18,'如何学习数据结构','多看书',1567037420603,1567037420603,12,0,15,0,'数据结构'),(19,'如何学习数据结构','ds',1567061786675,1567061786675,12,2,24,0,'数据结构'),(20,'如何学习springboot','多敲代码！',1567069274800,1567069274800,12,0,13,0,'springboot'),(22,'如何学习前端','多学习',1567297980618,1567297980618,12,3,36,0,'前端'),(23,'如何学习springboot','多敲代码！',1567586291818,1567586291818,12,1,10,0,'springboot,java,后端'),(24,'如何学习springboot','多敲代码！',1567586314071,1567586314071,12,0,2,0,'后端,java'),(25,'如何学习前端','多学习',1567672522896,1567672522896,12,0,0,0,'前端,html'),(26,'学习MySql','MySql',1567673207285,1567673207285,12,2,17,0,'MySql,java'),(27,'如何学习springboot','多敲代码！',1567840395844,1567840395844,12,0,5,0,'java,springboot,spring'),(28,'看看我这代码！','```java\r\n //添加评论进数据库\r\n    @RequestMapping(value = \"/comment\", method = RequestMethod.POST)\r\n    @ResponseBody\r\n    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,\r\n                       HttpServletRequest request) {\r\n        User user = (User) request.getSession().getAttribute(\"user\");\r\n        //返回异常码和异常信息\r\n        if (user == null) {\r\n            return ResultDTO.errorOf(2002, \"用户未登录，是否登录登录？\");\r\n        }\r\n        //判断传入的评论内容是否为空\r\n        if (commentCreateDTO.getContent().isEmpty()) {\r\n            throw new TomalenException(TomalenErrorCode.CONTENT_IS_EMPTY);\r\n        }\r\n        Comment comment = new Comment();\r\n        comment.setParentId(commentCreateDTO.getParentId());\r\n        comment.setContent(commentCreateDTO.getContent());\r\n        comment.setType(commentCreateDTO.getType());\r\n        //创建时间\r\n        comment.setGmtCreate(System.currentTimeMillis());\r\n        comment.setGmtModified(comment.getGmtCreate());\r\n        comment.setCommentor(user.getId());\r\n        comment.setLikeCount(0L);\r\n        commentService.insert(comment, user);\r\n        return ResultDTO.okOf();\r\n    }\r\n```',1568105063305,1568105063305,12,1,13,0,'java'),(29,'你好！','```java\r\n public static List<TagCacheDTO> getTags () {\r\n\r\n        ArrayList<TagCacheDTO> tagCacheDTOS = new ArrayList<>();\r\n        //添加开发语言\r\n        TagCacheDTO programLanguage = new TagCacheDTO();\r\n        programLanguage.setCategoryTag(\"开发语言\");\r\n        programLanguage.setTags(Arrays.asList(\"javascript\" ,\"php\",\"css\" ,\"html\",\"html5\" ,\"java\",\"node.js\" ,\"python\",\"c++\" ,\"c\",\"golang\" ,\"objective-c\",\"typescript\" ,\"shell c#\",\"swift\" ,\"sass\",\"bash\" ,\"ruby\",\"less\" ,\"asp.net\",\"lua scala\" ,\"coffeescript\",\"actionscript\" ,\"rust\",\"erlang\"));\r\n        tagCacheDTOS.add(programLanguage);\r\n\r\n        //添加框架\r\n        TagCacheDTO frame = new TagCacheDTO();\r\n        frame.setCategoryTag(\"开发框架\");\r\n        frame.setTags(Arrays.asList(\"spring\" ,\"express\" ,\"django\" ,\"flask\" ,\"yii\" ,\"ruby-on-rails \" ,\"tornado\" ,\"koa\" ,\"struts\" ,\"springMvc\" ,\"mybatis\" ,\"springboot\"));\r\n        tagCacheDTOS.add(frame);\r\n\r\n        //服务器\r\n```',1568105570425,1568105570425,12,0,14,0,'java'),(30,'这段HTML代码','```html\r\n   <hr class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\" id=\"comment_section\">\r\n                <div class=\"media\">\r\n                    <div class=\"media-left\">\r\n                        <a href=\"#\">\r\n                            <img class=\"media-object img-rounded\" style=\"width: 39px\" th:src=\"${question.user.avatarUrl}\">\r\n                        </a>\r\n                    </div>\r\n                    <div class=\"media-body\">\r\n                        <h4 class=\"media-heading\" style=\"padding-top: 10px\">\r\n                            <span th:text=\"${question.user.name}\"></span>\r\n                        </h4>\r\n                    </div>\r\n                </div>\r\n                <input type=\"hidden\" id=\"parent_id\" name=\"parent_id\"  th:value=\"${question.id}\">\r\n                <!--上下边距为10px，左右为0-->\r\n                <textarea id=\"content\" name=\"content\"  class=\"form-control\" rows=\"3\" style=\"margin: 10px 0\"></textarea>\r\n                <!--向左浮动，上边距为10px-->\r\n                <button type=\"button\" class=\"btn btn-success\" style=\"float: right;margin-top: 10px\" onclick=\"post()\">回复</button>\r\n            </div>\r\n        </div>\r\n```',1568188791965,1568188791965,12,3,19,0,'html5'),(31,'如何学习springboot','多敲代码！',1568189148149,1568189148149,12,0,3,0,'php'),(32,'看看我这代码！','```java\r\n //添加评论进数据库\r\n    @RequestMapping(value = \"/comment\", method = RequestMethod.POST)\r\n    @ResponseBody\r\n    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,\r\n                       HttpServletRequest request) {\r\n        User user = (User) request.getSession().getAttribute(\"user\");\r\n        //返回异常码和异常信息\r\n        if (user == null) {\r\n            return ResultDTO.errorOf(2002, \"用户未登录，是否登录登录？\");\r\n        }\r\n        //判断传入的评论内容是否为空\r\n        if (commentCreateDTO.getContent().isEmpty()) {\r\n            throw new TomalenException(TomalenErrorCode.CONTENT_IS_EMPTY);\r\n        }\r\n        Comment comment = new Comment();\r\n        comment.setParentId(commentCreateDTO.getParentId());\r\n        comment.setContent(commentCreateDTO.getContent());\r\n        comment.setType(commentCreateDTO.getType());\r\n        //创建时间\r\n        comment.setGmtCreate(System.currentTimeMillis());\r\n        comment.setGmtModified(comment.getGmtCreate());\r\n        comment.setCommentor(user.getId());\r\n        comment.setLikeCount(0L);\r\n        commentService.insert(comment, user);\r\n        return ResultDTO.okOf();\r\n    }\r\n```',1568358898416,1568358898416,12,2,11,0,'java,ruby,objective-c'),(33,'java代码！','```java\r\n public static List<TagCacheDTO> getTags () {\r\n\r\n        ArrayList<TagCacheDTO> tagCacheDTOS = new ArrayList<>();\r\n        //添加开发语言\r\n        TagCacheDTO programLanguage = new TagCacheDTO();\r\n        programLanguage.setCategoryTag(\"开发语言\");\r\n        programLanguage.setTags(Arrays.asList(\"javascript\" ,\"php\",\"css\" ,\"html\",\"html5\" ,\"java\",\"node.js\" ,\"python\",\"c++\" ,\"c\",\"golang\" ,\"objective-c\",\"typescript\" ,\"shell c#\",\"swift\" ,\"sass\",\"bash\" ,\"ruby\",\"less\" ,\"asp.net\",\"lua scala\" ,\"coffeescript\",\"actionscript\" ,\"rust\",\"erlang\"));\r\n        tagCacheDTOS.add(programLanguage);\r\n\r\n        //添加框架\r\n        TagCacheDTO frame = new TagCacheDTO();\r\n        frame.setCategoryTag(\"开发框架\");\r\n        frame.setTags(Arrays.asList(\"spring\" ,\"express\" ,\"django\" ,\"flask\" ,\"yii\" ,\"ruby-on-rails \" ,\"tornado\" ,\"koa\" ,\"struts\" ,\"springMvc\" ,\"mybatis\" ,\"springboot\"));\r\n        tagCacheDTOS.add(frame);\r\n\r\n        //服务器\r\n```',1568425811462,1568425811462,12,0,7,0,'java');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `token` char(36) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `modified_time` bigint(20) DEFAULT NULL,
  `bio` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `avatar_url` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (12,'36147869','TomAlen','dadb33c9-1242-4dc7-8c6d-7aeb9c95d488',1567061772313,1571225609024,'Keep Coding!','https://avatars3.githubusercontent.com/u/36147869?v=4');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'springBoot'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-28 15:31:55
