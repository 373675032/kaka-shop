/*
==========================================================================
郑重说明：本项目免费开源！原创作者为：薛伟同学，严禁私自出售。
==========================================================================
B站账号：薛伟同学
微信公众号：薛伟同学
作者博客：http://xuewei.world
==========================================================================
陆陆续续总会收到粉丝的提醒，总会有些人为了赚取利益倒卖我的开源项目。
不乏有粉丝朋友出现钱付过去，那边只把代码发给他就跑路的，最后还是根据线索找到我。。
希望各位朋友擦亮慧眼，谨防上当受骗！
==========================================================================
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收货地址',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `is_default` int(8) DEFAULT NULL COMMENT '是否默认【1:是】【0:否】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='收货地址';

-- ----------------------------
-- Records of address
-- ----------------------------
BEGIN;
INSERT INTO `address` (`id`, `user_id`, `name`, `address`, `phone`, `is_default`) VALUES (1, 2, '张三', '四川省成都市XXX区XXX街道999号', '17879540000', 1);
INSERT INTO `address` (`id`, `user_id`, `name`, `address`, `phone`, `is_default`) VALUES (2, 2, '张三', '四川省成都市高新区XXX大厦', '17879540000', 0);
INSERT INTO `address` (`id`, `user_id`, `name`, `address`, `phone`, `is_default`) VALUES (8, 3, '李四', '河北省唐山市迁安市XXX街', '17877779999', 1);
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `commodity_id` int(8) DEFAULT NULL COMMENT '商品ID',
  `count` int(8) DEFAULT NULL COMMENT '数量',
  `add_time` datetime DEFAULT NULL COMMENT '加入购物车时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
INSERT INTO `cart` (`id`, `user_id`, `commodity_id`, `count`, `add_time`) VALUES (32, 2, 8, 1, '2023-12-27 22:13:12');
INSERT INTO `cart` (`id`, `user_id`, `commodity_id`, `count`, `add_time`) VALUES (40, 3, 11, 12, '2023-12-27 22:32:34');
INSERT INTO `cart` (`id`, `user_id`, `commodity_id`, `count`, `add_time`) VALUES (42, 3, 9, 5, '2023-12-27 22:32:36');
INSERT INTO `cart` (`id`, `user_id`, `commodity_id`, `count`, `add_time`) VALUES (48, 2, 11, 1, '2023-12-27 22:52:08');
COMMIT;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='归类';

-- ----------------------------
-- Records of classify
-- ----------------------------
BEGIN;
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (1, '卡布其诺', '2021-04-10 21:52:25');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (2, '冰咖啡', '2021-04-10 21:52:37');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (3, '摩卡咖啡', '2021-04-10 21:52:54');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (4, '阿拉比卡咖啡', '2021-04-10 21:53:08');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (5, '罗布斯塔', '2023-12-27 21:41:00');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (6, '刚果咖啡', '2023-12-27 21:41:14');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (7, '蓝山咖啡', '2023-12-27 21:41:29');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (8, '夏威夷卡曼', '2023-12-27 21:41:41');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (9, '印度曼特宁', '2023-12-27 21:41:55');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (10, '乌干达咖啡', '2023-12-27 21:42:08');
INSERT INTO `classify` (`id`, `name`, `create_time`) VALUES (11, '哥伦比亚咖啡', '2023-12-27 21:42:51');
COMMIT;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `commodity_id` int(8) DEFAULT NULL COMMENT '商品ID',
  `add_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='收藏表';

-- ----------------------------
-- Records of collection
-- ----------------------------
BEGIN;
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (24, 2, 11, '2023-12-27 22:12:11');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (25, 2, 10, '2023-12-27 22:12:12');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (26, 2, 6, '2023-12-27 22:12:18');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (27, 3, 11, '2023-12-27 22:30:17');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (28, 3, 10, '2023-12-27 22:30:21');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (29, 3, 8, '2023-12-27 22:30:27');
INSERT INTO `collection` (`id`, `user_id`, `commodity_id`, `add_time`) VALUES (30, 3, 6, '2023-12-27 22:30:32');
COMMIT;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名称',
  `info` longtext COLLATE utf8mb4_bin COMMENT '商品简介',
  `description` longtext COLLATE utf8mb4_bin COMMENT '商品描述',
  `color` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '颜色',
  `material` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '原材料',
  `origin` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产地',
  `classify_id` int(8) DEFAULT NULL COMMENT '商品分类ID',
  `original_price` decimal(5,2) DEFAULT NULL COMMENT '原价',
  `now_price` decimal(5,2) DEFAULT NULL COMMENT '现价',
  `inventory` int(8) DEFAULT NULL COMMENT '库存',
  `publish_time` datetime DEFAULT NULL COMMENT '上架时间',
  `status` int(1) DEFAULT '1' COMMENT '状态【1:上架】【0:下架】',
  `img` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品图片地址',
  `sale_count` int(8) DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品表';

-- ----------------------------
-- Records of commodity
-- ----------------------------
BEGIN;
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (6, '「晨曦之舞」', '「晨曦之舞」是一款精致而富有诗意的卡布其诺咖啡豆。栽培于哥伦比亚的高海拔地区，这些咖啡豆经过精心挑选和烘焙，以确保每一杯都带来令人陶醉的味觉体验。「晨曦之舞」的浓郁口感融合了柔和的巧克力和坚果的风味，香气中透露着轻盈的水果和花香。无论是早晨的第一杯咖啡还是午后放松的时刻，「晨曦之舞」都能带给你温暖、愉悦的享受。', '「晨曦之舞」，一袋来自哥伦比亚的卡布其诺咖啡豆，带来了一场美妙的晨曦之舞。这些深棕色的咖啡豆散发着诱人的香气，仿佛清晨初露的第一缕阳光。每一颗豆子都经过精心挑选和烘焙，保留了卡布其诺咖啡独特的风味特点。品尝「晨曦之舞」，你会感受到浓郁的巧克力和坚果的滋味，伴随着轻柔的水果和花香，每一口都如同在优雅的舞蹈中徜徉。无论是与朋友分享欢乐的时刻，还是独自享受宁静的时光，「晨曦之舞」都会为你带来温暖、愉悦的咖啡体验，让你沉浸在一片美好的晨曦中。', '深棕色', '阿拉比卡咖啡豆', '哥伦比亚', 1, 99.00, 79.00, 89, '2023-12-27 21:50:38', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/cf7de3f56f3343c98211aee5a3b06d82.png', 11);
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (7, '「秘境之韵」', '「秘境之韵」是一款珍贵而迷人的乌干达咖啡。这些咖啡豆生长在乌干达的高海拔地区，经过精心挑选和精湛的烘焙工艺，展现出了它们独特的品质。「秘境之韵」散发着浓郁的巧克力和坚果的香气，口感饱满顺滑，带来一种令人陶醉的感受。无论是悠闲地品味一杯，还是与朋友分享美好时光，「秘境之韵」都能带给你独特而深沉的咖啡体验。', '「秘境之韵」，一袋来自乌干达的顶级咖啡豆，诠释着这片神秘土地的独特韵味。这些深沉的棕褐色咖啡豆散发着浓郁的香气，仿佛置身于乌干达的广袤大地。每一颗豆子都经过精心挑选和精湛的烘焙工艺，保留了乌干达咖啡的独特风味。品尝「秘境之韵」，你会感受到浓郁的巧克力和坚果的口感，带来舌尖上的愉悦与满足。无论是沉浸在宁静的早晨，还是享受夜晚的宁静时刻，「秘境之韵」都将为你带来一场独特的咖啡冒险，让你感受到大地的沉静与厚重，品味乌干达的秘境之美。', '棕褐色', '阿拉比卡', '乌干达', 10, 109.00, 99.00, 1, '2023-12-27 21:53:04', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/e19c9c52289140618f50d6206b2e94c1.png', 9);
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (8, '「阳光之舞」', '「阳光之舞」是一款优雅而充满阳光气息的哥伦比亚咖啡。这些咖啡豆生长于哥伦比亚的高海拔地区，经过精心挑选和烘焙，展现出了它们独特的风味。「阳光之舞」的口感醇厚且平衡，带来了令人陶醉的味觉体验。无论是早晨的第一杯咖啡还是午后的放松时光，「阳光之舞」都能为你带来温暖、愉悦的享受。', '「阳光之舞」，一袋来自哥伦比亚的卓越咖啡豆，散发着温暖阳光的气息。这些深棕色的咖啡豆经过精心挑选和烘焙，保留了哥伦比亚咖啡独特的风味特点。「阳光之舞」的口感醇厚，带有巧克力和坚果的风味，伴随着轻盈的花香和水果香。无论是在早晨开始新的一天，还是在午后与朋友分享美好时刻，「阳光之舞」都能为你带来令人陶醉的味觉体验，让你沉浸在温暖阳光中跳跃的舞蹈中。', '深棕色', '阿拉比卡', '哥伦比亚', 11, 88.00, 60.00, 1, '2023-12-27 21:55:05', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/1c5b74dc6ef0411bba3fe6cf527ede3c.png', 9);
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (9, '「冰封之心」', '「冰封之心」是一款清新纯净的冰咖啡。这种独特的制作方式，使得咖啡豆的香气和口感更为浓郁，同时又不失清爽。无论是在炎炎夏日的午后还是加班疲惫的晚上，「冰封之心」都能为你带来一份清凉活力。', '「冰封之心」，一款清新纯净的冰咖啡。这种独特的制作方式，使得咖啡豆的香气和口感更为浓郁，同时又不失清爽。「冰封之心」独特的口感和香气，仿佛将冰雪的清凉和阳光的温暖融合在一起。无论是搭配甜品、沙拉，还是单独享用，「冰封之心」都能带给你一份清新纯净的味觉体验，让你的味蕾在冰凉中舒爽地展开', '明亮透明', '阿拉比卡', '巴西、哥伦比亚、埃塞俄比亚等', 2, 129.00, 99.00, 3, '2023-12-27 21:57:05', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/ec2218bf73744bb78ef765d933d9c7f1.png', 2);
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (10, '「巧克力之梦」', '「巧克力之梦」是一款浓郁而诱人的摩卡咖啡。这款咖啡融合了咖啡和巧克力的美妙组合，带来了独特的口感和香气。「巧克力之梦」让你仿佛置身于巧克力的世界中，感受到甜蜜与满足。', '「巧克力之梦」，一款浓郁而诱人的摩卡咖啡。这款咖啡融合了咖啡和巧克力的美妙组合，带来了独特的口感和香气。「巧克力之梦」的浓郁巧克力味与咖啡的醇厚回味相互交织，让你沉浸在无尽的味觉享受中。无论是早晨的第一杯咖啡还是下午休憩时光，「巧克力之梦」都能为你带来一份甜蜜、诱人的美味体验，让你的味蕾沉醉在巧克力的梦境中。', '深褐色', '阿拉比卡', '巴西、哥伦比亚等', 3, 100.00, 50.00, 94, '2023-12-27 21:59:27', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/bad46885096b43b89ab2417e39b80c36.png', 5);
INSERT INTO `commodity` (`id`, `name`, `info`, `description`, `color`, `material`, `origin`, `classify_id`, `original_price`, `now_price`, `inventory`, `publish_time`, `status`, `img`, `sale_count`) VALUES (11, '「赤道之韵」', '「赤道之韵」是一款充满活力和个性的刚果咖啡。这种咖啡以其深邃的口感和丰富的香气而著称。赤道之韵的咖啡豆种植于刚果的高海拔地区，得益于赤道地理位置的优势，享受到丰富的阳光和充沛的降雨。无论是清晨的第一口还是下午的小憩，赤道之韵都能为你带来一份充满活力和个性的咖啡体验，让你的味蕾沉浸在源自赤道大陆的热情与魅力中。', '「赤道之韵」一款充满活力和个性的刚果咖啡。这种咖啡以其深邃的口感和丰富的香气而著称。赤道之韵的咖啡豆在刚果的阳光和热带气候中茁壮成长，成为一款独具特色的咖啡作品。无论是清晨的第一口还是下午的小憩，赤道之韵都能为你带来一份充满活力和个性的咖啡体验，让你的味蕾沉浸在源自赤道大陆的热情与魅力中。', '深棕色', '刚果咖啡豆', '刚果高海拔地区', 1, 59.00, 50.00, 0, '2023-12-27 22:02:29', 1, 'https://su-share.oss-cn-beijing.aliyuncs.com/1/16bbcc17b2c14dd3a49e6e1213d44b89.png', 3);
COMMIT;

-- ----------------------------
-- Table structure for commodity_comment
-- ----------------------------
DROP TABLE IF EXISTS `commodity_comment`;
CREATE TABLE `commodity_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `commodity_id` int(8) DEFAULT NULL COMMENT '商品ID',
  `stars` int(1) DEFAULT NULL COMMENT '评星数【1-5】',
  `comment` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评价',
  `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
  `reply_id` int(11) DEFAULT NULL COMMENT '回复评论的ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品评价表';

-- ----------------------------
-- Records of commodity_comment
-- ----------------------------
BEGIN;
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (11, 3, 10, 4, '包装不错，快递迅速！质量嘎嘎好', '2023-12-27 22:43:34', NULL);
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (12, 2, 6, 5, '味道很好～', '2023-12-27 22:49:40', NULL);
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (13, 2, 8, 4, '还可以哦', '2023-12-27 22:49:57', NULL);
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (14, 2, 9, 3, '口感一般', '2023-12-27 22:50:16', NULL);
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (15, 2, 7, 5, '味道很不错，咖啡味道浓郁', '2023-12-27 22:55:04', NULL);
INSERT INTO `commodity_comment` (`id`, `user_id`, `commodity_id`, `stars`, `comment`, `comment_time`, `reply_id`) VALUES (16, 3, 11, 5, '性价比可以', '2023-12-27 22:56:23', NULL);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_number` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '订单号',
  `user_id` int(8) DEFAULT NULL COMMENT '用户ID',
  `commodity_id` int(8) DEFAULT NULL COMMENT '商品ID',
  `content` longtext COLLATE utf8mb4_bin COMMENT '订单记录',
  `courier_number` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '快递单号',
  `courier_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '快递公司',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `sipping_time` datetime DEFAULT NULL COMMENT '发货时间',
  `success_time` datetime DEFAULT NULL COMMENT '成交时间',
  `status` int(1) DEFAULT NULL COMMENT '订单状态【-1:取消】【0:等待发货】【1:已发货】【2:已完成】',
  `address_id` int(8) DEFAULT NULL COMMENT '地址ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (18, '1703686315512', 2, 6, '卡布其诺-「晨曦之舞」*3', 'SF345834759394579', '顺丰快递', '2023-12-27 22:11:56', '2023-12-27 22:11:56', '2023-12-27 22:21:35', '2023-12-27 22:49:10', 2, 1);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (19, '1703686360015', 2, 8, '哥伦比亚咖啡-「阳光之舞」*1', 'YD5782345728935', '韵达快递', '2023-12-27 22:12:40', '2023-12-27 22:12:40', '2023-12-27 22:22:32', '2023-12-27 22:49:17', 2, 1);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (20, '1703686374468', 2, 9, '冰咖啡-「冰封之心」*1', 'YT32423487923423', '圆通快递', '2023-12-27 22:12:54', '2023-12-27 22:12:54', '2023-12-27 22:21:59', '2023-12-27 22:49:21', 2, 2);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (21, '1703687408750', 3, 8, '哥伦比亚咖啡-「阳光之舞」*1', NULL, NULL, '2023-12-27 22:30:09', '2023-12-27 22:30:09', NULL, NULL, 0, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (22, '1703687498076', 3, 8, '哥伦比亚咖啡-「阳光之舞」*5', NULL, NULL, '2023-12-27 22:31:38', '2023-12-27 22:31:38', NULL, NULL, -1, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (23, '1703687506494', 3, 6, '卡布其诺-「晨曦之舞」*4', NULL, NULL, '2023-12-27 22:31:46', '2023-12-27 22:31:46', NULL, NULL, 0, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (24, '1703687515172', 3, 9, '冰咖啡-「冰封之心」*1', 'SF723894728934', '顺丰快递', '2023-12-27 22:31:55', '2023-12-27 22:31:55', '2023-12-27 22:41:20', NULL, 1, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (25, '1703687522584', 3, 11, '卡布其诺-「赤道之韵」*2', 'EMS345897342342', '邮政EMS', '2023-12-27 22:32:03', '2023-12-27 22:32:03', '2023-12-27 22:53:50', '2023-12-27 22:56:03', 2, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (26, '1703687537380', 3, 10, '摩卡咖啡-「巧克力之梦」*2', NULL, NULL, '2023-12-27 22:32:17', '2023-12-27 22:32:17', NULL, NULL, -1, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (27, '1703687545402', 3, 7, '乌干达咖啡-「秘境之韵」*3', 'YT242342342345', '圆通快递', '2023-12-27 22:32:25', '2023-12-27 22:32:25', '2023-12-27 22:41:47', '2023-12-27 22:42:40', 2, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (28, '1703687623966', 3, 10, '摩卡咖啡-「巧克力之梦」*3', 'SF57892734594', '顺丰快递', '2023-12-27 22:33:44', '2023-12-27 22:33:44', '2023-12-27 22:41:27', '2023-12-27 22:42:45', 2, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (29, '1703687633368', 3, 6, '卡布其诺-「晨曦之舞」*4', NULL, NULL, '2023-12-27 22:33:53', '2023-12-27 22:33:53', NULL, NULL, 0, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (30, '1703687642921', 3, 7, '乌干达咖啡-「秘境之韵」*2', NULL, NULL, '2023-12-27 22:34:03', '2023-12-27 22:34:03', NULL, NULL, -1, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (31, '1703687651178', 3, 8, '哥伦比亚咖啡-「阳光之舞」*2', 'SF4782934789234', '顺丰快递', '2023-12-27 22:34:11', '2023-12-27 22:34:11', '2023-12-27 22:41:35', NULL, 1, 8);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (32, '1703688676216', 2, 7, '乌干达咖啡-「秘境之韵」*3', 'SF523458934025', '顺丰快递', '2023-12-27 22:51:16', '2023-12-27 22:51:16', '2023-12-27 22:53:23', '2023-12-27 22:54:28', 2, 1);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (33, '1703688701871', 2, 7, '乌干达咖啡-「秘境之韵」*1', NULL, NULL, '2023-12-27 22:51:42', '2023-12-27 22:51:42', NULL, NULL, -1, 1);
INSERT INTO `order` (`id`, `order_number`, `user_id`, `commodity_id`, `content`, `courier_number`, `courier_name`, `create_time`, `pay_time`, `sipping_time`, `success_time`, `status`, `address_id`) VALUES (34, '1703688718579', 2, 11, '卡布其诺-「赤道之韵」*1', NULL, NULL, '2023-12-27 22:51:59', '2023-12-27 22:51:59', NULL, NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱地址',
  `img` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像地址',
  `info` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `role` int(1) DEFAULT '0' COMMENT '个人说明',
  `update_time` datetime DEFAULT NULL COMMENT '最新更新',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `password`, `email`, `img`, `info`, `register_time`, `role`, `update_time`) VALUES (1, '管理员', 'x12345', 'admin@qq.com', 'https://xuewei-blog.oss-cn-beijing.aliyuncs.com/202312272104642.png', '我们热爱我们的咖啡。我们相信通过一杯高品质的手工咖啡可以传递和分享真挚情感，而这样简单的行为或许可以为顾客提供一些正能量。 因此，【咖咖】始终致力于通过道德采购，烘焙并提供高品质的咖啡豆。 从一粒种子到一杯咖啡，每一个环节都倾入了【咖咖】的心意和努力， 只为每一次光顾我们门店的顾客可以享受醇香的浓缩咖啡及其钟爱的咖啡饮品。', '2021-02-22 22:17:41', 1, '2021-04-22 21:16:04');
INSERT INTO `user` (`id`, `name`, `password`, `email`, `img`, `info`, `register_time`, `role`, `update_time`) VALUES (2, '张三', 'x12345', 'zs@qq.com', 'https://su-share.oss-cn-beijing.aliyuncs.com/2/483f32b2d8364ec690024c3cb8fc754a.jpg', '-', '2023-12-27 20:46:56', 0, '2023-12-27 22:11:13');
INSERT INTO `user` (`id`, `name`, `password`, `email`, `img`, `info`, `register_time`, `role`, `update_time`) VALUES (3, '李四', 'x12345', 'ls@qq.com', 'https://xuewei-blog.oss-cn-beijing.aliyuncs.com/202312272104642.png', '-', '2023-12-27 20:46:56', 0, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
