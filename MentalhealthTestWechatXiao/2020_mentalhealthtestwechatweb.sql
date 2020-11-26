/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3307
 Source Schema         : 2020_mentalhealthtestwechatweb

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 08/03/2020 23:19:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `Aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Apwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Atel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', '123');

-- ----------------------------
-- Table structure for cartoonanimats
-- ----------------------------
DROP TABLE IF EXISTS `cartoonanimats`;
CREATE TABLE `cartoonanimats`  (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Ctitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Cdate` datetime(0) NULL DEFAULT NULL,
  `Cpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Cjianjie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Cauthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Cflag` int(11) NULL DEFAULT 1 COMMENT '1 漫画 2 动画',
  `Cimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Ccont` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cartoonanimats
-- ----------------------------
INSERT INTO `cartoonanimats` VALUES (1, '方法郭德纲333', '2020-03-02 16:00:00', '/20200302215218307252.mp4', '发送到发送到555', '范德萨范德萨发444', 2, '', '<p>分身乏术地方士大夫士大夫杀对方水电费水电费是的 法师打发第三方</p>');

-- ----------------------------
-- Table structure for musics
-- ----------------------------
DROP TABLE IF EXISTS `musics`;
CREATE TABLE `musics`  (
  `Mid` int(11) NOT NULL AUTO_INCREMENT,
  `Mtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Msinger` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Mimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Mpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Mtid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of musics
-- ----------------------------
INSERT INTO `musics` VALUES (1, '嫁汉嫁汉', '发个梵蒂冈发的', '', '', 1);
INSERT INTO `musics` VALUES (2, '11111', '111111111', '', '', 2);

-- ----------------------------
-- Table structure for musictypes
-- ----------------------------
DROP TABLE IF EXISTS `musictypes`;
CREATE TABLE `musictypes`  (
  `Mtid` int(11) NOT NULL AUTO_INCREMENT,
  `Mtname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Mtid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of musictypes
-- ----------------------------
INSERT INTO `musictypes` VALUES (1, '个共和国');
INSERT INTO `musictypes` VALUES (2, 'drdr');

-- ----------------------------
-- Table structure for professionalselftests
-- ----------------------------
DROP TABLE IF EXISTS `professionalselftests`;
CREATE TABLE `professionalselftests`  (
  `Psid` int(11) NOT NULL AUTO_INCREMENT,
  `Pstitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Psfirtoptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Psfirstnum` int(11) NULL DEFAULT NULL,
  `Pssecondoptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Pssecondnum` int(11) NULL DEFAULT NULL,
  `Psthreeoptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Psthreenum` int(11) NULL DEFAULT NULL,
  `Psfouroptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Psfournum` int(11) NULL DEFAULT NULL,
  `Psindex` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Psid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professionalselftests
-- ----------------------------
INSERT INTO `professionalselftests` VALUES (1, '第一题', '0.fsdfdfds', 0, '1，我有时感到悲伤。', 1, '2，我总是感到悲伤，而且不能摆脱它。', 2, '3，我感到极度悲伤，甚至不能自制。', 3, 1);
INSERT INTO `professionalselftests` VALUES (2, '第二题', '0.梵蒂冈梵蒂冈', 0, '1，我对未来信心不足。', 1, '2，我感到对未来没有什么可期望。', 2, ' 3，我感到未来毫无希望，情况也不会改善。', 3, 2);
INSERT INTO `professionalselftests` VALUES (3, '第三题', '0，我地方个梵蒂冈', 0, '1，我感到我比一般人失败的多些。', 1, '2，当我回顾过去时，我看到的都是失败。', 2, '3，我感到自己总是失败，毫无出息。', 3, 3);
INSERT INTO `professionalselftests` VALUES (4, '第四题', '0.梵蒂冈梵蒂冈梵蒂冈梵蒂冈梵蒂冈地方', 0, '1，我对做过的事，不太满意.', 1, '2，我对任何事情都感到不满意。', 2, '3，我对一切都感到厌倦。', 3, 4);
INSERT INTO `professionalselftests` VALUES (5, '第五题', '0，我不感到有什防守打法罪恶感。', 0, '1，有时，我感到自己有罪。', 1, '2，大部分时间内，我感到自己有罪。', 2, '3，我总是感到自己有罪。', 3, 5);
INSERT INTO `professionalselftests` VALUES (6, '第六题', '0，我不会认为我会受罚。', 0, '1，我感到我可能受罚。', 1, '2，我预感到我会受罚。', 2, '3，我感到我正受到惩罚。', 3, 6);
INSERT INTO `professionalselftests` VALUES (7, '第七题', '0，我从没有大失所望的感觉。', 0, '1，我有时有对自己感到失望。', 1, '2，我对自己感到厌恶。', 2, '3，我十分怨恨自己。', 3, 7);
INSERT INTO `professionalselftests` VALUES (8, '第八题', '0，我从不认为我比别人差。', 0, '1，对自己的缺点和错误总是感到不满。', 1, '2，对自己的失败总是在责备自己。', 2, '3，对所有的过错总是在谴责自己。', 3, 8);
INSERT INTO `professionalselftests` VALUES (9, '第九题', '0，我从没有想过要自杀。', 0, '1，我想过自杀，但没有干过。', 1, ' 2，我想要去自杀。', 2, ' 3，如果有机会，我会自杀的.', 3, 9);
INSERT INTO `professionalselftests` VALUES (10, '第十题', '0，我不象一般人那样爱哭。', 0, '1，我比过去爱哭了。', 1, '2，我爱哭了。', 2, '3，我过去总爱哭，但想哭也哭不出来了。', 3, 10);
INSERT INTO `professionalselftests` VALUES (11, '第十一题', '0，我不象以往那样焦急。', 0, '1，我比过去容易烦恼和焦急。', 1, '2，我总是非常焦急。', 2, ' 3，任何一件事都会使我焦躁。', 3, 11);
INSERT INTO `professionalselftests` VALUES (12, '第十二题', '0，我对别人没有失去兴趣。', 0, '1，与过去相比，我对别人的兴趣减退了。 ', 1, '2，我对别人已没有多大兴趣了。', 2, '3，我对别人已毫无兴趣。', 3, 12);
INSERT INTO `professionalselftests` VALUES (13, '第十三题', '0，我仍象往常一样自己可以决定事情。', 0, '1，与过去相比，我常推迟作出决定。', 1, '2，与过去相比，我常难以作出决定。', 2, '3，我不能做成任何决定。', 3, 13);
INSERT INTO `professionalselftests` VALUES (14, '第十四题', '0，我感到自己各方面跟过去一样。', 0, '1，我担心自己在变老或失去魅力。 ', 1, '2，我感到青春已逝而失去魅力。', 2, '3，我确信自己很丑。', 3, 14);
INSERT INTO `professionalselftests` VALUES (15, '第十五题', '0，我能和往常一样地工作。', 0, '1，开始去做某些事要付出很大的努力。', 1, '2，我不得不强迫自己去做事情。', 2, '3，我什么事也干不成。', 3, 15);
INSERT INTO `professionalselftests` VALUES (16, '第十六题', '0，我象往常一样睡的香。', 0, '1，我不如以前睡得香。', 1, '2，我比过去早1~2小时醒来，而且再难入睡。', 2, '3，我比过去早几小时醒来，而再也不能入睡。', 3, 16);
INSERT INTO `professionalselftests` VALUES (17, '第十七题', '0，我象往常一样不知疲倦。', 0, '1，我比过去容易疲倦。', 1, '2，我做什么事情都容易疲倦。', 2, ' 3，我疲乏的不愿意做什么事了。', 3, 17);
INSERT INTO `professionalselftests` VALUES (18, '第十八题', '0，我的食欲和以前一样好。', 0, '1，我的食欲不如以前好。', 1, '2，我的食欲很差。', 2, '3，我没有一点食欲。', 3, 18);
INSERT INTO `professionalselftests` VALUES (19, '第十九题', '0，我的体重没有减轻多少。', 0, '1，我的体重减轻了2公斤多。', 1, '2，我的体重减轻了5公斤多.', 2, '3，我的体重减轻了7公斤多。', 3, 19);
INSERT INTO `professionalselftests` VALUES (20, '第二十题', '0，我不象往常那样担心自己的健康。', 0, '1，我担心自己的健康，如胃不舒服，便秘。', 1, '2，我很担心自己的健康，无暇顾及其他。', 2, '3，我非常担心自己的健康，根本不能想别的事情。', 3, 20);
INSERT INTO `professionalselftests` VALUES (21, '第二十一题', '0，我的性兴趣跟过去一样没有变化。', 0, '1，我不象往常那样对性感兴趣。 ', 1, '2，我对性没有多大兴趣。', 2, '3，我对性完全失去了兴趣.', 3, 21);

-- ----------------------------
-- Table structure for professionalselftestscore
-- ----------------------------
DROP TABLE IF EXISTS `professionalselftestscore`;
CREATE TABLE `professionalselftestscore`  (
  `Psid` int(11) NOT NULL AUTO_INCREMENT,
  `Psuid` int(11) NULL DEFAULT NULL,
  `Psscore` int(255) NULL DEFAULT NULL,
  `Psdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Psid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professionalselftestscore
-- ----------------------------
INSERT INTO `professionalselftestscore` VALUES (1, 1, 18, '2020-03-03 16:00:00');

-- ----------------------------
-- Table structure for selftests
-- ----------------------------
DROP TABLE IF EXISTS `selftests`;
CREATE TABLE `selftests`  (
  `Stid` int(11) NOT NULL AUTO_INCREMENT,
  `Sttitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stfirstoption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stfirstnum` int(11) NULL DEFAULT NULL,
  `Stsecondoption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stsecondnum` int(11) NULL DEFAULT NULL,
  `Stthreeoption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stthreenum` int(11) NULL DEFAULT NULL,
  `Stfouroption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stfournum` int(11) NULL DEFAULT NULL,
  `Sindex` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Stid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selftests
-- ----------------------------
INSERT INTO `selftests` VALUES (1, '第一题', '0.我不感到悲伤。', 0, '1.我感到悲伤。', 1, '2.我始终悲伤，不能自制。', 2, '3.我太悲伤或不愉快，不堪忍受。', 3, 1);
INSERT INTO `selftests` VALUES (2, '第二题', '0.我对将来并不失望。', 0, '1.对未来我感到心灰意冷。', 1, '2.我感到前景黯淡。', 2, '3.我觉得将来毫无希望，无法改善。', 3, 2);
INSERT INTO `selftests` VALUES (3, '第三题', '0.我没有感到失败。', 0, '1.我觉得比一般人失败要多些。', 1, '2.回首往事，我能看到的是很多次失败。', 2, '3.我觉得我是一个完全失败的人。', 3, 3);
INSERT INTO `selftests` VALUES (4, '第四题', '0.我从各种事件中得到很多满足。', 0, '1.我不能从各种事件中感受到乐趣。', 1, '2.我不能从各种事件中得到真正的满足。', 2, '3.我对一切事情不满意或感到枯燥无味。', 3, 4);
INSERT INTO `selftests` VALUES (5, '第五题', '0.我不感到有罪过。', 0, '1.我在相当的时间里感到有罪过。', 1, '2.我在大部分时间里觉得有罪。', 2, '3.我在任何时候都觉得有罪。', 3, 5);
INSERT INTO `selftests` VALUES (6, '第六题', '0.我没有觉得受到惩罚。', 0, '1.我觉得可能会受到惩罚。', 1, '2.我预料将受到惩罚。', 2, '3.我觉得正受到惩罚。', 3, 6);
INSERT INTO `selftests` VALUES (7, '第七题', '0.我对自己并不失望。', 0, '1.我对自己感到失望。', 1, '2.我讨厌自己。', 2, '3.我恨自己。', 3, 7);
INSERT INTO `selftests` VALUES (8, '第八题', '0.我觉得并不比其他人更不好。', 0, '1.我要批判自己的弱点和错误。', 1, '2.我在所有的时间里都责备自己的错误。', 2, '3.我责备自己把所有的事情都弄坏了。', 3, 8);
INSERT INTO `selftests` VALUES (9, '第九题', '0.我没有任何想弄死自己的想法。', 0, '1.我有自杀想法，但我不会去做。', 1, '2.我想自杀。', 2, '3.如果有机会我就自杀。', 3, 9);
INSERT INTO `selftests` VALUES (10, '第十题', '0.我哭泣与往常一样。', 0, '1.我比往常哭得多。', 1, '2.我一直要哭。', 2, '3.我过去能哭，但要哭也哭不出来。', 3, 10);
INSERT INTO `selftests` VALUES (11, '第十一题', '0.和过去相比，我生气并不更多。', 0, '1.我比往常更容易生气发火。', 1, '2.我觉得所有的时间都容易生气。', 2, '3.过去使我生气的事，目前一点也不能使我生气了。', 3, 11);
INSERT INTO `selftests` VALUES (12, '第十二题', '0.我对其他人没有失去兴趣。', 0, '1.和过去相比，我对别人的兴趣减少了。', 1, '2.我对别人的兴趣大部分失去了。', 2, '3.我对别人的兴趣已全部丧失了。', 3, 12);
INSERT INTO `selftests` VALUES (13, '第十三题', '0.我作出决定没什么困难。', 0, '1.我推迟作出决定比过去多了。', 1, '2.我作决定比以前困难大得多。', 2, '3.我再也不能作出决定了。', 3, 13);
INSERT INTO `selftests` VALUES (14, '第十四题', '0.觉得我的外表看上去并不比过去更差。', 0, '1.我担心自己看上去显得老了，没有吸引力。', 1, '2.我觉得我的外貌有些变化，使我难看了。', 2, '3.我相信我看起来很丑陋。', 3, 14);
INSERT INTO `selftests` VALUES (15, '第十五题', '0.我工作和以前一样好。', 0, '1.要着手做事，我目前需额外花些力气。', 1, '2.无论做什么我必须努力催促自己才行。', 2, '3.我什么工作也不能做了。', 3, 15);
INSERT INTO `selftests` VALUES (16, '第十六题', '0.我睡觉与往常一样好。', 0, '1.我睡眠不如过去好。', 1, '2.我比往常早醒 l～2 小时，难以再睡。', 2, '3.我比往常早醒几个小时，不能再睡。', 3, 16);
INSERT INTO `selftests` VALUES (17, '第十七题', '0.我并不感到比往常更疲乏。', 0, '1.我比过去更容易感到疲乏无力。', 1, '2.几乎不管做什么，我都感到疲乏无力。', 2, '3.我太疲乏无力，不能做任何事情。', 3, 17);
INSERT INTO `selftests` VALUES (18, '第十八题', '0.我的食欲和往常一样。', 0, '1.我的食欲不如过去好。', 1, '2.我目前的食欲差得多了。', 2, '3.我一点也没有食欲了。', 3, 18);
INSERT INTO `selftests` VALUES (19, '第十九题', '0.最近我的体重并无很大减轻。', 0, '1.我体重下降2.27 千克以上。', 1, '2.我体重下降5.54 千克以上。', 2, '3.我体重下降7.81 千克以上。', 3, 19);
INSERT INTO `selftests` VALUES (20, '第二十题', '0.我对健康状况并不比往常更担心。', 0, '1.我担心身体上的问题，如疼痛、胃不适或便秘。', 1, '2.我很担心身体问题，想别的事情很难。', 2, '3.我对身体问题如此担忧，以致不能想其他任何事情。', 3, 20);
INSERT INTO `selftests` VALUES (21, '第二十一题', '0.我没有发现自己对性的兴趣最近有什么变化。', 0, '1.我对性的兴趣比过去降低了。', 1, '2.我现在对性的兴趣大大下降。', 2, '3.我对性的兴趣已经完全丧失。', 3, 21);

-- ----------------------------
-- Table structure for selftestscores
-- ----------------------------
DROP TABLE IF EXISTS `selftestscores`;
CREATE TABLE `selftestscores`  (
  `Ssid` int(11) NOT NULL AUTO_INCREMENT,
  `Ssuid` int(11) NULL DEFAULT NULL,
  `Ssscore` int(11) NULL DEFAULT NULL,
  `Ssdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Ssid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selftestscores
-- ----------------------------
INSERT INTO `selftestscores` VALUES (1, 1, 12, '2020-03-04 16:00:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `Uid` int(11) NOT NULL AUTO_INCREMENT,
  `Uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Upwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Utel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Udate` datetime(0) NULL DEFAULT NULL,
  `Usex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Uage` int(255) NULL DEFAULT NULL,
  `Unicheng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Uimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Uopenid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, NULL, NULL, NULL, '2020-02-28 16:00:00', NULL, NULL, '梦醒飞翔', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIvEq4QwVhNhgJVdR5wjBk3Mgt9icr2Tlb6Vzkg4HP6IkEMKCUdPuWzjVicppngOjL5dH7ZHjxfeibUg/132', 'ourD64uLyRXaD5qvHacn3x5yQ37U');

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos`  (
  `Vid` int(11) NOT NULL AUTO_INCREMENT,
  `Vtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Vperformers` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演员',
  `Vtid` int(11) NULL DEFAULT NULL COMMENT '电影类型',
  `Vscores` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评分',
  `Vjianjie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `Vpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Vimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Vid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES (1, '发送到发送到', '发的所发生的', 3, '发送到发多少', '范德萨范德萨', '', '');
INSERT INTO `videos` VALUES (2, '的放大幅度', '都是范德萨', 3, '范德萨范德萨', '第三方第三方', '', '');
INSERT INTO `videos` VALUES (3, '范德萨范德萨', '范德萨范德萨发', 2, '范德萨范德萨发', '发生的发生的发', '', '');
INSERT INTO `videos` VALUES (4, '发送到发多少', '发个大概地方', 2, '是分散', '撒的发生', '', '');
INSERT INTO `videos` VALUES (5, '发生大法师', '防守打法', 3, '防守打法', '鼎折覆餗', '', '');
INSERT INTO `videos` VALUES (6, '防守打法', '士大夫撒旦', 2, '防守打法', '防守打法', '', '');
INSERT INTO `videos` VALUES (7, '是大范德萨范德萨', '法师打发第三方', 2, '范德萨范德萨', '发的所发生的发', '', '');

-- ----------------------------
-- Table structure for videostypes
-- ----------------------------
DROP TABLE IF EXISTS `videostypes`;
CREATE TABLE `videostypes`  (
  `Vtid` int(11) NOT NULL AUTO_INCREMENT,
  `Vtname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Vtid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videostypes
-- ----------------------------
INSERT INTO `videostypes` VALUES (1, '发的发打发士大夫');
INSERT INTO `videostypes` VALUES (2, '是打发第三方');
INSERT INTO `videostypes` VALUES (3, '发的所发生的发');

-- ----------------------------
-- Table structure for wechats
-- ----------------------------
DROP TABLE IF EXISTS `wechats`;
CREATE TABLE `wechats`  (
  `Wid` int(11) NOT NULL AUTO_INCREMENT,
  `Wuid` int(11) NULL DEFAULT NULL,
  `Wcont` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Wdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Wid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wechats
-- ----------------------------
INSERT INTO `wechats` VALUES (1, 1, 'fdsf', '2020-03-05 16:00:00');

SET FOREIGN_KEY_CHECKS = 1;
