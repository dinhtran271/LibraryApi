-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 16, 2022 lúc 01:57 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `library`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_category` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `year_of_publication` varchar(255) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`book_id`, `book_author`, `book_category`, `book_name`, `price`, `year_of_publication`, `publisher_id`, `reader_id`, `staff_id`) VALUES
(1, 'Trường Đại học Kinh tế – Đại học Quốc gia Hà Nội', 'Kinh tế học', 'International Trade And Investment Towards Green And Digital Transformation', 300000, '2022', 1, 5, 1),
(2, 'Nguyễn Thu Hà', 'Kinh tế học', 'Nghiên Cứu Về Quản Trị Kinh Doanh: Lý Luận Cơ Bản Và Các Tình Huống Thực Tiễn', 199000, '2022', 1, 4, 1),
(3, ' Dương Quốc Việt', 'Toán học', 'Bài tập cơ sở đại số hiện đại', 120000, '2020', 2, 3, 1),
(4, ' Dương Quốc Việt', 'Toán học', 'Cơ sở Lí thuyết số và đa thức', 70000, '2022', 2, 2, 2),
(5, 'Faculty of English', 'Ngoại ngữ', 'Theoretical Background to ELT Methodology', 70000, '2021', 2, 1, 2),
(6, 'PGS. TS. Võ Đại Quang', 'Ngoại ngữ', 'Major Issues In English Phonetics And Phonology', 120000, '2022', 1, 1, 2),
(7, 'GS.TS. KNUD S. LARSEN – PGS.TS. LÊ VĂN HẢO', 'Tâm lý học', 'Tâm Lý Học Xã Hội Trong Cuộc Sống Hiện Đại', 398000, '2021', 1, 3, 2),
(8, 'TS. Vũ Thị Bình ', 'Tâm lý học', 'Kỹ Năng Tư Vấn Tâm Lý Học Đường ', 120000, '2021', 1, 3, 2),
(9, 'VŨ VĂN THUẤN-TRẦN VĂN CÔNG', 'Tâm lý học', 'Đào Tạo Kỹ Năng Xã Hội Cho Trẻ Rối Loạn Phát Triển', 120000, '2020', 1, 5, 1),
(10, 'Nguyễn Hoàng Hải', 'Khoa học công nghệ', 'Cơ Học Lượng Tử: Từ Nguyên Lí Đến Nguyên Tử', 200000, '2022', 1, 2, 1),
(11, 'Nguyễn Hữu Hiếu', 'Khoa học công nghệ', 'Graphene & Vật Liệu Nanocomposite Trên Cơ Sở Graphene: Tổng Hợp, Đặc Tính Và Ứng Dụng', 250000, '2021', 1, 1, 2),
(12, 'Đỗ Trung Tuấn', 'Khoa học công nghệ', 'Khoa Học Dữ Liệu', 219000, '2021', 1, 1, 2),
(13, 'Nguyễn Văn Sửu', 'Khoa học công nghệ', 'Nhân Học: Ngành Khoa Học Về Con Người', 108000, '2021', 1, 1, 2),
(14, 'Lương Mỹ Vân', 'Lịch sử-Văn hóa-Chính trị', 'Lê Quý Đôn Và Jeong Yak Yong – Từ Chú Giải Kinh Thư Đến Tư Tưởng Chính Trị', 240000, '2022', 1, 4, 1),
(15, 'TS. Đào Thị Thu Hường', 'Lịch sử-Văn hóa-Chính trị', 'Giải Quyết Tranh Chấp Biển Đông Từ Các Nguyên Tắc Cơ Bản Của Pháp Luật Quốc Tế', 980000, '2022', 1, 5, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`id`, `address`, `email`, `name`) VALUES
(1, '16 Hàng Chuối, Phạm Đình Hổ, Hai Bà Trưng, Hà Nội', 'nxb@vnu.edu.vn', 'Nhà xuất bản Đại học quốc gia Hà Nội'),
(2, 'Tầng 6, Toà nhà số 128 đường Xuân Thuỷ, phường Dịch Vọng Hậu, Quận Cầu Giấy, Thành phố Hà Nội', 'sachsp.nxb@hnue.edu.vn', 'Nhà xuất bản Đại học Sư phạm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reader`
--

CREATE TABLE `reader` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `reader`
--

INSERT INTO `reader` (`id`, `address`, `email`, `name`, `phone`, `staff_id`) VALUES
(1, 'Thái Bình', 'binhew432@gmail.com', 'Nguyễn Văn Bình', '0325986352', 2),
(2, 'Hà Nội', 'canhdang324@gmail.com', 'Đặng Văn Cảnh', '0365824693', 2),
(3, 'Hà Nội', 'minh4324@gmail.com', 'Hoành Anh Minh', '0356983146', 1),
(4, 'Thanh Hóa', 'taitai4324@gmail.com', 'Nguyễn Văn Tài', '0325971568', 1),
(5, 'Hà Nội', 'linhthu324@gmail.com', 'Nguyễn Thu Linh', '0325934781', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`id`, `date_of_birth`, `name`, `phone`) VALUES
(1, '1990-02-12 07:00:00', 'Nguyễn Thị Tuyết', '0368324526'),
(2, '1991-06-22 07:00:00', 'Hoàng Huỳnh Như', '0359642521');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `FKgtvt7p649s4x80y6f4842pnfq` (`publisher_id`),
  ADD KEY `FKo2a7jqe0tbyfishgmlad1gmad` (`reader_id`),
  ADD KEY `FKjle3rtfuyuv1b0tp1vpkgw2v8` (`staff_id`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `reader`
--
ALTER TABLE `reader`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3q7twcnu2vkkowr963yxqmuh2` (`staff_id`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `reader`
--
ALTER TABLE `reader`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKgtvt7p649s4x80y6f4842pnfq` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `FKjle3rtfuyuv1b0tp1vpkgw2v8` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `FKo2a7jqe0tbyfishgmlad1gmad` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`);

--
-- Các ràng buộc cho bảng `reader`
--
ALTER TABLE `reader`
  ADD CONSTRAINT `FK3q7twcnu2vkkowr963yxqmuh2` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
