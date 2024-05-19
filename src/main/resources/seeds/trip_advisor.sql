/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022 (8.0.22)
 Source Host           : localhost:3306
 Source Schema         : trip_advisor

 Target Server Type    : MySQL
 Target Server Version : 80022 (8.0.22)
 File Encoding         : 65001

 Date: 20/05/2024 02:34:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (1, 'emperorsheevpalpatine0@gmail.com', 'palpatine', '$2a$10$m7dsSlUTQ3tdexQzfLRr1OFDlSsLKhTgepy/qVmBrz1SgCJ80P7RG', '19124380339', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (2, '979380638@qq.com', 'percival', '$2a$10$7Qkl4j0cEcnfP7..2bpMjOHZ3AMQPgs3dawRVDr4cRAzSJzYKeKTa', '138353512311', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (15, '979380677@qq.com', 'aaaa', '$2a$10$stif4qE6aVAt3m.Tz9Pi0eMe7RzM9aRiupYyrh1awo1HcFVgHia0K', '11', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (19, 'emperorsheevpalpatine0000@gmail.com', 'sheevpalpatine0', '$2a$10$tU1K9432dXivEPmfS3/wmeb5y2jQWfwLbiiAaKuyisCc/qnDjYDXi', '19124380339', 0);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (21, 'baizhan@bz.com', 'baizhan', '$2a$10$oIofZttC0sVloQPo0bHvxemHq.fvTt8WPfor3JGoFpHMPhyenrzpG', '13835351231', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (22, 'sxt@bz.com', 'SSSSSFFFFF', '$2a$10$rKgDwlivaMX/BiDN7mQphuc/HregB3Ps3pKPDo0mbjCGYMSb9M83m', '13835351231', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (23, '1', '1', '$2a$10$xKgMawuczSaZQ8goPNPfBOkBQdEcaQGPk9qE/2Vg3PwkDFUEASkWa', '1', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (28, 'SS', 'SS', '$2a$10$sgUBFXuXvLRbWBxsj7.PGu4/CTGMr/4jXWRU1yXiHKg3DyhEQDxY6', 'SS', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (29, 'AAADDD', 'AAADDD', '$2a$10$7nTkBBEsXiCljEdfI2PWLOsgnoTVWlheQ61VoM0UdYuhZpUMuB15i', 'AAADDD', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (30, 'WEWXCaf', 'WEWXCaf', '$2a$10$5Siu.U8UEtkYT.oE9WMjnOHokvAwbeoEHSo.fwS5t./47haewptDe', 'WEWXCaf', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (31, 'JOHN DON', 'JOHN DON', '$2a$10$Mhrx.VP/odOh5wr5Sa2zAOyrr2XgSw2WQ.aUiwl/kE6gijSAemxti', 'JOHN DON', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (32, 'wafw', 'wafw', '$2a$10$qdxASt8pcPg.Fc10ubPjVOtJCknOIGkeSQ5fkvs6Jr3yMGsVGv4Ve', 'wafw', 1);
INSERT INTO `admin` (`aid`, `email`, `username`, `password`, `phoneNum`, `status`) VALUES (33, '11', '11', '11', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `aid` int NOT NULL,
  `rid` int NOT NULL,
  PRIMARY KEY (`aid`,`rid`) USING BTREE,
  KEY `aid` (`aid`) USING BTREE,
  KEY `rid` (`rid`) USING BTREE,
  CONSTRAINT `admin_role_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `admin` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `admin_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
BEGIN;
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (1, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (1, 3);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (2, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (16, 1);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (16, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (16, 3);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (18, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (19, 3);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (19, 9);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (21, 1);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (22, 1);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (22, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (23, 1);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (23, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (23, 3);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (23, 9);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (23, 10);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (28, 2);
INSERT INTO `admin_role` (`aid`, `rid`) VALUES (29, 2);
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE KEY `AK_nq_categoryname` (`cname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=959 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` (`cid`, `cname`) VALUES (5, 'Entertainment');
INSERT INTO `category` (`cid`, `cname`) VALUES (100, 'Instructions');
INSERT INTO `category` (`cid`, `cname`) VALUES (2, 'News');
INSERT INTO `category` (`cid`, `cname`) VALUES (3, 'Travel');
INSERT INTO `category` (`cid`, `cname`) VALUES (6, 'Work out');
COMMIT;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `remoteAddr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `commentText` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`) USING BTREE,
  KEY `pid` (`pid`) USING BTREE,
  KEY `mid` (`mid`) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `member` (`mid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comments
-- ----------------------------
BEGIN;
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (29, 592, 6, '0:0:0:0:0:0:0:1', '😍😍😍😍😍😍😍😍😍😍😍😍😍😍😍😍😍😍😍', '2023-06-13 16:18:03');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (30, 592, 26, '0:0:0:0:0:0:0:1', 'Wroth every price!!!', '2023-06-13 17:48:37');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (36, 603, 6, '0:0:0:0:0:0:0:1', 'Nothing better than Imperial Aesthetics. Should be it\'s own art genre\r\n\r\n', '2023-06-26 00:29:11');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (37, 597, 49, '0:0:0:0:0:0:0:1', 'SCREW THIS SUCKKERRRRR!!!!!!!!!!!!!!!', '2023-06-26 15:29:56');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (38, 598, 50, '0:0:0:0:0:0:0:1', 'sbhszsebsgh gs', '2023-06-26 16:22:57');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (39, 598, 6, '0:0:0:0:0:0:0:1', 'CQvrqfwcawQX', '2023-07-07 17:50:25');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (40, 599, 6, '0:0:0:0:0:0:0:1', 'ddfsass', '2023-07-10 12:07:27');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (41, 605, 26, '0:0:0:0:0:0:0:1', 'afqRGTBWRAWerd', '2023-07-22 19:37:56');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (42, 599, 6, '0:0:0:0:0:0:0:1', 'adw', '2023-10-29 15:27:25');
INSERT INTO `comments` (`cid`, `pid`, `mid`, `remoteAddr`, `commentText`, `createdAt`) VALUES (43, 623, 6, '0:0:0:0:0:0:0:1', 'screw u!!!!\r\n', '2023-11-21 21:53:17');
COMMIT;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `mid` int NOT NULL,
  `pid` int NOT NULL,
  PRIMARY KEY (`pid`,`mid`) USING BTREE,
  KEY `FK_user_favorite` (`mid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of favorite
-- ----------------------------
BEGIN;
INSERT INTO `favorite` (`mid`, `pid`) VALUES (1, 522);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 1);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 2);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 3);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 4);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 5);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 6);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 7);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 8);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 9);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 10);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 11);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 12);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (3, 13);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 562);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 569);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 592);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 593);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 594);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (6, 599);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (22, 510);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (22, 513);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (22, 518);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (22, 522);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (22, 524);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 524);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 526);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 555);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 565);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 566);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (26, 567);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (31, 567);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (38, 567);
INSERT INTO `favorite` (`mid`, `pid`) VALUES (50, 592);
COMMIT;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `score` int DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  UNIQUE KEY `AK_nq_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (1, 'baizhan', '$2a$10$s8A8EPUzinL.NCoTyXKu3eza5BTliAQEyeiv.R53R7Hw4hFhPVH8W', 'male', '13855555555', '461618768@qq.com', 210, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (6, 'EMPEROR PALPATINE', '$2a$10$xvTUUrbMIWRz7WFYPG77uedTJGpxlciZC40OVYnlP1aBvl6E9cvvW', 'Male', '1', 'AACWe', 1169, '/upload/72a89b74-7238-4da5-8557-1d70217170fd44a3a32719d47aea624f497e41171b4.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (8, 'AAA', '$2a$10$jvC9gjWDYZaK5FKpDaPNEOoZgOJ/2eeQJcxytpmnRH6MBzE84zpWu', 'Male', 'AA', 'AA', 180, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (9, 'sheevpalpatine00', '$2a$10$o/UY8OsfSLKSbjfRKfWnWuGBx7AErIbLC5sn7GkcXeO.n8W5mZ/..', 'Male', '111', '111', 1122, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (22, 'ww', '$2a$10$LGwENXjoXeLCIYZs7myIzebuF99o3JipAGPdsMfL0l3N58WlvnxQ6', 'Male', '19124380337', '979380638@qq.com', 1653, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (23, 'AAAAAAAAA', '$2a$10$FbmQez77ai4BBGoiC3HZ3OwFZCxRsYaRivdkL8efY9uqMEtw7Zc6W', 'Male', 'AAAAAAAAA', 'AAAAAAAAA', 440, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (25, 'AAAQQ', '$2a$10$WO52FjRmrMzwPcPqMfbW0u1WzcUe7Dtdo7j2jvKN6uSu.DS0CfaDa', 'Male', 'AAA', 'AAA', 180, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (26, 'sheevpalpatine0', '$2a$10$a2YVbyYDTaGLYINPiwSV7eKAARcrnQWuLRdt3yYZo4g8LGQY4cW9a', 'Male', '92438056399', 'emperorsheevpalpatine0@gmail.com', 380, '/upload/8e1eeda1-8fa9-4dbb-80e5-b7ff40bc017asad.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (27, 'afVER', '$2a$10$YRx1y..sqqe38eFnIKvJ0eJjOsiGKil0tc7fked7H8MuAUCG1t0Ye', 'Male', 'AFAEc', '11AD', 353, NULL);
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (28, '540', '$2a$10$jEhKtG4uUsittwdHT19uNu5qF1lw3KIoj3/zrkdnVgifYU3dyo5vq', 'Male', '540', '540', 245, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (30, '32', '$2a$10$ArvQMjTQlaYH0GcBm4TdSO4jYAF2PzWOYbIxZN1x7.MgQQi664unS', 'Male', '32', '32', NULL, '/upload/4d9251ca-b0c7-4a85-85cb-0f3e7f7d2ed144a3a32719d47aea624f497e41171b4.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (31, 'IKEA', '$2a$10$QHSsv/.YkuH5C3gIrP5lm.cNQW2mI/WrfxN/4N2055O5xKZjci3Iu', 'Male', 'IKEA', 'IKEA', NULL, '/upload/f499f28f-f3aa-4a59-ac54-0d5b9dac26774f6b90a48b5466b909e8e657937e643.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (32, 'WQ', '$2a$10$l.TVVTB4cNu9.0hQdrvYY.Xx4plvm.zQh33UFwZ2IiZ54QDkvn6fu', 'Male', 'WQ', 'WQ', NULL, '/upload/337aea5b-d36e-43fb-8b86-d7dc9ebcd3f2OIF-C.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (33, 'FF', '$2a$10$QK4Q.Du3l/h4mBMiBXlvP.d0K3AUVIhQu50dkL.CsVHa.eDGgKeXy', 'Female', 'FF', 'FF', NULL, '/upload/8bf0d6f1-aade-4b39-9e3d-5bb847bf2519OIF-C.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (34, 'ererer', '$2a$10$9XBmZ9wUM/wr4szQh3U7hOEryr1fdeaLEvNkYcx.LU1V8gh6zulQ.', 'Male', 'ererer', 'ererer', NULL, '/upload/206b7b7f-b874-4a4a-8b91-f81a1348e1ddTTT.png');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (35, 'FFE', '$2a$10$eaxhORiaaZnnsHWDLOysmOYypmD5woHfF9wEq2cizATdB98AoXPS.', 'Male', 'FFEE', 'FFE', 232, '/upload/9fb12f57-d789-40c7-a11b-1687d6664fd9bf4909536a5c7c4981af96d4ab645e1.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (36, '234', '$2a$10$EeURHf8U.leL/CPXXTj2EOIVlRLjCezD1P80aevS1SOrqGUzrRzfe', 'Male', '234', '234', 165, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (37, 'carcqwfc', '$2a$10$o9KltbaiDyaZXY2e.ALFh.neFJdOaMDLCYEh/s0Z8Q.fGG0zzQaBu', 'Male', 'carcqwfc', 'carcqwfc', NULL, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (38, 'fwvesfQVTG', '$2a$10$ZlQjyUBlf5pmLr7zubBcYetAhzCM7ER0tpIE4.cudeqGK01Ra1/ua', 'Male', 'fwvesfQVTG', 'fwvesfQVTG', 76, '/upload/deea4506-a4c2-4578-8df2-b1824273c70ee1c016d2780c3d5899d7df8e1a6edb2.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (39, '345e', '$2a$10$wyjohWlY.5.qTEcnz7X2O.IzZ1tXvLujXkm9zPJEYu7xWnRNjCY7K', 'Male', '345e', '345e', 100, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (42, 'AEEFV', '$2a$10$DvvxFCRrIsgMxtb5XOsPle9j2EK9IHUiT7st8Xez0/T8ZplPfrYpS', 'Male', 'AEEFV', 'AEEFV', 50, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (43, 'John Don', '$2a$10$Tjpw6wHyd2.tL6PV9dFqfeuv/0dHyRF44C04a2/3sV6LBQQD75rWG', 'Male', '86634114', 'John_Don@gmail.com', 50, '/upload/51b42ad3-3db6-4400-843b-3c56fdadbf5cTTT.png');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (44, '6345', '$2a$10$EIr.7zD/DparM8aI/hmVE.gnSKWqEcwgfS7jS1uFamoYChh4F5rCy', 'Male', '6345', '6345', 50, '/upload/e750c431-657b-4468-b821-494aa0ee593344a3a32719d47aea624f497e41171b4.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (45, 'sssaaa', '$2a$10$meWEOgR0gdBH.voMeHFIoeEMdu0RDVBK3UaLApPoogS0nVV.768mC', 'Male', 'sssaaa', 'sssaaa', 629, '/upload/c3c164d7-c13e-43db-826e-f8b85637534b44a3a32719d47aea624f497e41171b4.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (46, 'SSSFFFFAAA', '$2a$10$DrEpG4Vrie6diG8.T.SUXeES3COqKnQYjZmHD7uABp27wKVN7eP1i', 'Female', 'SSSFFFFAAA', 'SSSFFFFAAA', 50, '/upload/b8282229-2cd6-4b08-8058-f741aff47984d5e35f17387761ed1b91042ba83b11e.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (47, 'TESTTT', '$2a$10$PW/xL2xIpiHvMN8SEeMW0eUAOqyxCw2kTB9NWP54k6VfztEh6tKh2', 'Male', '19124380336', '979380638@qq.comDda', 50, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (48, 'WEWXC', '$2a$10$DhI62BfrHatVhtoynnn8jOWv4xdG0xjIeHOZ/86fp2fWEJCN2NfD.', 'Female', 'WEWXC', 'WEWXC', 50, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (49, 'WEWXCaf', '$2a$10$aIy7yVBdY3LHe5TCi3mLhOZkErBK9d/95S.LNHGN9Qu5ox.FuXYDu', 'Male', '1235234', 'WEWXCaf', 52, '/upload/638c7284-f25c-4d23-ab8f-6d5033d8150ee1c016d2780c3d5899d7df8e1a6edb2.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (50, 'seravwq', '$2a$10$XOnohyeqMCGMOjcPkEOYMeHfCDsnGIdRxkxKVW05sxORJt1VuAYRK', 'Male', 'segf', 'segf', 62, '/upload/1d757141-9806-411c-97bf-6805c87e803f44a3a32719d47aea624f497e41171b4.jpg');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (51, 'ss', '$2a$10$SbmhKG5rDGSIURQMd.v4pOgMLIWjBCQdrKjHozJbGfjkgVFXgjLCa', 'Male', 'ss', 'ss', 50, '');
INSERT INTO `member` (`mid`, `username`, `password`, `sex`, `phoneNum`, `email`, `score`, `avatar`) VALUES (52, 'sss', '$2a$10$GguY6Arj2dwaD/cpf64WZu.8IMF7V.wFT6sTLL//3.h7TkbYLs47K', 'Male', 'sss', 'sss', 50, '/upload/2a77f34c-5eb8-4ce7-b436-fec4132f4a24582-NOTTE_ARMANI_NEW-Client_BRONZE_20201207.1849-975x548.jpg');
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permissionDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (1, 'Browse Admin', '/admin/all');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (2, 'Browse Role', '/role/all');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (3, 'Browse Permission', '/permission/all');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (4, 'Add  Permisison', '/permission/add');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (5, 'Browse User Rank A', '/memberB/RA');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (6, 'Browse User Rank B', '/memberB/RB');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (7, 'Browse User Rank C', '/memberB/RC');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (8, 'Browse User Rank D', '/memberB/RD');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (9, 'Browse User Rank E', '/memberB/RE');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (10, 'Browse User Rank F', '/memberB/RF');
INSERT INTO `permission` (`pid`, `permissionName`, `permissionDesc`) VALUES (11, 'Edit USer', '/memberB/edit');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `productDesc` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pImage` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  KEY `FK_category_route` (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=630 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (588, 'Monora Bay', 1, '<p><br></p>', '/upload/8d03fd08-5a8d-44af-80d0-5368159f59efHarbor-East-marina-BPXWOZQ2k (1).jpg', 3, 'EMPEROR PALPATINE', 6, '2023-06-11');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (589, 'Stuffs for panache', 1, '<p><br></p>', '/upload/cd70d80d-d5a4-420e-b232-3372fc16f8ebmy-solandge-lursen-pool.jpg', 3, 'EMPEROR PALPATINE', 6, '2023-06-11');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (591, 'SOLANDGE-DECK POOL', 1, '<div>Her panoramic top deck plays host to a beach club area with customized dance floor, Jacuzzi and bar while the bridge deck is ideal for relaxation and casual al fresco dining with a spacious seating area. On the bridge deck there is also a fully-equipped health spa featuring massage room, sauna and gymnasium leading out onto a glass-edged plunge pool.&nbsp;<br></div><div><br></div>', '/upload/3e0f85e8-f4d7-4dd0-8fae-d29fe4164174R-C.jpg', 3, 'EMPEROR PALPATINE', 6, '2023-06-13');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (592, 'SOLANDGE-ONE NIGHT ON PACIFIC ', 1, '<p>Moran Yacht &amp; Ship has announced the largest brokerage deal of 2017 so far - the sale of 85m&nbsp;<a href=\"https://yachtharbour.com/yacht/solandge-1244\">Solandge</a>&nbsp;built by Lurssen in 2013 and on the market since summer 2015. The buyer was represented by SSH Maritime in this deal.<br></p>', '/upload/8a9fca35-bb44-4274-836b-bedc3b9ce98brawImage.jpg', 3, 'EMPEROR PALPATINE', 6, '2023-06-13');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (593, 'SOLANDGE-DECK', 1, '<p><br></p>', '/upload/9e3e7aa6-1f3c-474f-aaef-434d254724117_4.jpg', 3, 'EMPEROR PALPATINE', 6, '2023-06-13');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (594, 'SOLANGE-GYM', 1, '<p><br></p>', '/upload/90708cc2-2177-4597-aabb-078cf8b6d3c97_6B.jpg', 6, 'EMPEROR PALPATINE', 6, '2023-06-13');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (597, 'Hunter Biden investigation \'integrity\' undermined if just half of IRS whistleblowers\' claims are true: Turley', 1, '<p><strong>FIRST ON FOX:&nbsp;</strong>George Washington University law professor Jonathan Turley warned that if \"half\" of the IRS whistleblowers’ claims are true, then&nbsp;<a href=\"https://www.foxnews.com/politics/hunter-biden-scheduled-make-first-court-appearance-federal-tax-charges-july\" target=\"_blank\"><u>Hunter Biden’s tax evasion</u></a>&nbsp;investigation’s \"integrity and credibility would be greatly undermined.\"</p><p>Turley told Fox News Digital that Americans \"need to keep in mind that allegations are not proof\" and that the whistleblowers\' claims remain \"unverified but clearly worthy of investigation.\"</p><p>However, if even partially accurate, the allegations would hurt the trust in the investigation into Hunter Biden\'s taxes.</p><div><div></div></div><p>\"If half of these allegations are proven to be true, the investigation\'s integrity and credibility would be greatly undermined,\" Turley warned. \"At a minimum, these are questions that need to be answered.\"</p><p><br></p>', '/upload/c8a4ce47-c1c8-4756-bd33-d7f55469f0741687708842529.png', 2, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (598, 'Pentagon silent on whether it notified families of Titanic submersible implosion after initial detection', 1, '<p><br></p>', '/upload/9d80b5c2-b20e-4ba4-82a9-297aeb0c83a21687709131792.png', 2, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (599, 'US spy agencies had intel in mid-June Wagner chief Prigozhin was planning armed action in Russia: report', 1, '<p>U.S. spy agencies reportedly obtained intelligence in mid-June that Wagner mercenary chief Yevgeniy Prigozhin was planning \"armed action\" against Russian establishment.&nbsp;</p><p>The Washington Post reported Saturday, citing several U.S. officials, that Prigozhin even warned the White House and other U.S. agencies of his plot \"so that they were not caught off guard.\"</p><p>The officials said senior leadership at the Pentagon,&nbsp;<a href=\"https://www.foxnews.com/category/politics/foreign-policy/state-department\" target=\"_blank\">State Department,</a>&nbsp;and in Congress were briefed on the intelligence within the past two weeks, though the exact timing of Prigozhin’s plot had remained unclear up until the Wagner leader’s takeover of military command and tank run toward Moscow Friday and Saturday.&nbsp;</p><p>There was reportedly \"high concern\" in Washington over the potential prospects of what would become of Russia’s nuclear arsenal if&nbsp;<a href=\"https://www.foxnews.com/category/world/personalities/vladimir-putin\" target=\"_blank\">President Vladimir Putin</a>&nbsp;was removed from power and if there would be \"civil war\" in Russia.&nbsp;</p><p><a href=\"https://www.foxnews.com/live-news/putin-accuses-wagner-group-of-betrayal-as-russian-mercenaries-march-towards-moscow\" target=\"_blank\"><strong>WAGNER CHIEF ORDERS TROOPS TO TURN AROUND FROM MOSCOW \'TO AVOID BLOODSHED\'</strong></a></p><p><br></p><div baseimage=\"https://static.foxnews.com/foxnews.com/content/uploads/2023/06/AP23175810553033.jpg\" source=\"Associated Press\"><div><picture><source media=\"(max-width: 767px)\" srcset=\"https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/343/192/AP23175810553033.jpg?ve=1&amp;tl=1, https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/686/384/AP23175810553033.jpg?ve=1&amp;tl=1 2x\"><source media=\"(min-width: 767px) and (max-width: 1023px)\" srcset=\"https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/672/378/AP23175810553033.jpg?ve=1&amp;tl=1, https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/1344/756/AP23175810553033.jpg?ve=1&amp;tl=1 2x\"><source media=\"(min-width: 1024px) and (max-width: 1279px)\" srcset=\"https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/931/523/AP23175810553033.jpg?ve=1&amp;tl=1, https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/1862/1046/AP23175810553033.jpg?ve=1&amp;tl=1 2x\"><source media=\"(min-width: 1280px)\" srcset=\"https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/720/405/AP23175810553033.jpg?ve=1&amp;tl=1, https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2023/06/1440/810/AP23175810553033.jpg?ve=1&amp;tl=1 2x\"></picture></div></div>', '/upload/02e4095a-7c92-4fae-9970-e30a30811ef01687709251127.png', 2, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (602, 'StarWars Squadrons -ImperialHangar (NO MUSIC) - Ambience', 1, '<p><br></p>', '/upload/beaeb898-ed2d-4e23-bd02-054f14382ae01687709807861.png', 5, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (603, 'Director Krennic Edit - The PerfectGirl (Galactic Empire) 4K', 1, '<p>The video is not political, it does not promote any form of government or ideology it was made to honor the amazing work of people responsible for creating the Star Wars universe, and also to just enjoyment purposes!\r\nMusic - <a tabindex=\"0\" href=\"https://www.youtube.com/watch?v=4JEcgyVSlmw&amp;t=0s\" rel=\"nofollow\" target=\"\" force-new-state=\"true\">&nbsp;&nbsp;<img alt=\"\" src=\"https://www.gstatic.com/youtube/img/watch/yt_favicon.png\">&nbsp;•&nbsp;Death&nbsp;Squad&nbsp;&nbsp;</a><br></p>', '/upload/2adfc7a3-ba6c-49c3-9c9c-45ae747d10171687710461517.png', 5, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (605, 'Titan Squadron Ending Cinematic| STAR WARS: Squadrons', 1, '<p><span dir=\"auto\">This feels the best if you complete the game on Ace difficulty. </span><span dir=\"auto\">\r\n</span><span dir=\"auto\">This is THE Ending for me. For the Empire!</span><br></p>', '/upload/be511b94-5e66-4f4b-a687-27fd16aa77781687710231119.png', 5, 'EMPEROR PALPATINE', 6, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (608, 'FFFF', 1, '<p>VeVEACWC</p>', '/upload/34f30e0d-fc6d-4db2-a3c6-483713b2ad90b4aa50808cf0a9f1bbd4e644297ecf6.jpg', 3, 'seravwq', 50, '2023-06-26');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (623, 'Creating a New Post', 1, '<ul><li><p>Navigate to the \"Create Post\" section on your dashboard.<br>Provide a captivating title and a concise, engaging introduction.<br>Use the editor to format your text, add images, and embed multimedia content.<br>Add relevant tags and categories to make your post easily discoverable.<br></p></li></ul><p><br></p>', '/upload/55f9b1a5-b14b-4592-964c-4378dd666893AA.jpg', 100, 'EMPEROR PALPATINE', 6, '2023-11-21');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (624, 'Engaging with Readers', 1, '<p>Respond promptly to comments on your blog posts.<br>Encourage discussions by asking questions at the end of your posts.<br>Consider creating a dedicated space, like a forum or comments section, for readers to share their thoughts.<br>Showcase user-generated content, such as reader-submitted stories or comments, to foster a sense of community.</p><p><br></p>', '/upload/39aa62c2-f2e8-47f7-b335-9f3d6aa9c56dAA.jpg', 100, 'EMPEROR PALPATINE', 6, '2023-11-21');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (625, 'Optimizing for SEO', 1, '<p>Research and incorporate relevant keywords into your blog posts.<br>Use descriptive and SEO-friendly URLs for each post.<br>Optimize images with alt text to improve accessibility and SEO.<br>Regularly update and refresh old content to maintain its relevance in search engine rankings.</p><p><br></p>', '/upload/1d632482-ca35-45f8-a44d-93e476b2fa35AA.jpg', 100, 'EMPEROR PALPATINE', 6, '2023-11-21');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (627, 'Promoting Your Blog:', 1, '<p>Share new posts on your social media channels.<br>Collaborate with other bloggers or websites for guest posts and cross-promotion.<br>Utilize email newsletters to keep subscribers informed about new content.<br>Monitor analytics to understand your audience and tailor your promotion strategies accordingly.</p><p><br></p>', '/upload/1d9f9deb-8888-480e-ac8c-eb31e583de0cAA.jpg', 1, 'EMPEROR PALPATINE', 6, '2023-11-21');
INSERT INTO `product` (`pid`, `productName`, `status`, `productDesc`, `pImage`, `cid`, `username`, `mid`, `created_date`) VALUES (629, 'AAAA', 1, '<p><br></p>', '/upload/7387057e-35b3-47c3-8d82-3770212d44e1A.bmp', 1, 'EMPEROR PALPATINE', 6, '2023-11-28');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (1, 'Superme Admin', 'Manage All Data');
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (2, 'Post Admin', 'Manage Product');
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (3, 'Users Inspector (Rank A,B)', 'Manage users with rank A and B');
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (9, 'Users Inspector (Rank C,D)	', 'Manage users with rank C and D');
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (10, 'Users Inspector (Rank E,F)	', 'Manage users with rank E and F');
INSERT INTO `role` (`rid`, `roleName`, `roleDesc`) VALUES (11, 'Users Admin', 'Can edit user\'s details');
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rid` int NOT NULL,
  `pid` int NOT NULL,
  KEY `rid` (`rid`) USING BTREE,
  KEY `pid` (`pid`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `permission` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (2, 3);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (9, 7);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (9, 8);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (10, 9);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (10, 10);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (3, 5);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (3, 6);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 1);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 2);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 3);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 4);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 5);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 6);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 7);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 8);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 9);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 10);
INSERT INTO `role_permission` (`rid`, `pid`) VALUES (1, 11);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
