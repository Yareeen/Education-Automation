-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 17 Oca 2022, 19:45:04
-- Sunucu sürümü: 5.7.31
-- PHP Sürümü: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `devlet_egitim`
--
CREATE DATABASE IF NOT EXISTS `devlet_egitim` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `devlet_egitim`;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `alinan_ders`
--

DROP TABLE IF EXISTS `alinan_ders`;
CREATE TABLE IF NOT EXISTS `alinan_ders` (
  `ogrenci_kod` int(11) NOT NULL,
  `ogretmen_kod` int(11) DEFAULT NULL,
  `ders_adi` varchar(45) NOT NULL,
  `not1` int(45) DEFAULT '0',
  `not2` int(11) DEFAULT NULL,
  `sinav_tarihi` date DEFAULT NULL,
  PRIMARY KEY (`ogrenci_kod`,`ders_adi`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `alinan_ders`
--

INSERT INTO `alinan_ders` (`ogrenci_kod`, `ogretmen_kod`, `ders_adi`, `not1`, `not2`, `sinav_tarihi`) VALUES
(1, NULL, 'Biyoloji', 80, NULL, NULL),
(1, NULL, 'Kimya', 50, NULL, NULL),
(1, NULL, 'Matematik', 100, NULL, NULL),
(1, NULL, 'Türkçe', 0, NULL, NULL),
(2, NULL, 'Biyoloji', 0, NULL, NULL),
(2, NULL, 'Matematik', 0, NULL, NULL),
(7, NULL, 'Türkçe', 40, NULL, NULL),
(9, NULL, 'Kimya', 0, NULL, NULL),
(9, NULL, 'Matematik', 100, NULL, NULL),
(9, NULL, 'Türkçe', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ders`
--

DROP TABLE IF EXISTS `ders`;
CREATE TABLE IF NOT EXISTS `ders` (
  `kod` int(45) NOT NULL,
  `ders_adi` varchar(45) NOT NULL,
  `kac_saat` int(25) NOT NULL,
  `gunu` varchar(255) NOT NULL,
  PRIMARY KEY (`kod`,`ders_adi`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `ders`
--

INSERT INTO `ders` (`kod`, `ders_adi`, `kac_saat`, `gunu`) VALUES
(1, 'Matematik', 5, 'Pazartesi'),
(2, 'Biyoloji', 2, 'Cuma'),
(3, 'Kimya', 3, 'Çarşamba'),
(4, 'Türkçe', 4, 'Çarşamba');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `devamsizlik`
--

DROP TABLE IF EXISTS `devamsizlik`;
CREATE TABLE IF NOT EXISTS `devamsizlik` (
  `ogrenci_kod` int(45) NOT NULL,
  `tarih` date NOT NULL,
  PRIMARY KEY (`ogrenci_kod`,`tarih`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `devamsizlik`
--

INSERT INTO `devamsizlik` (`ogrenci_kod`, `tarih`) VALUES
(1, '2022-01-12'),
(1, '2022-01-30'),
(2, '2022-01-14'),
(12, '2022-01-29');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `idari_personel`
--

DROP TABLE IF EXISTS `idari_personel`;
CREATE TABLE IF NOT EXISTS `idari_personel` (
  `kod` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL,
  `TC` int(11) NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `isim` varchar(255) NOT NULL,
  `okul_kod` int(11) NOT NULL,
  PRIMARY KEY (`kod`,`no`),
  KEY `okul_kod` (`okul_kod`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `idari_personel`
--

INSERT INTO `idari_personel` (`kod`, `no`, `TC`, `sifre`, `isim`, `okul_kod`) VALUES
(1, '100', 100, '100', '100', 1),
(2, '600', 600, '600', 'Pinar', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogrenci`
--

DROP TABLE IF EXISTS `ogrenci`;
CREATE TABLE IF NOT EXISTS `ogrenci` (
  `kod` int(11) NOT NULL AUTO_INCREMENT,
  `no` int(11) NOT NULL,
  `TC` varchar(45) DEFAULT NULL,
  `sifre` varchar(255) NOT NULL,
  `isim` varchar(45) NOT NULL,
  `okul_kod` int(11) NOT NULL,
  PRIMARY KEY (`kod`),
  KEY `fk_ogrenci_okul_idx` (`okul_kod`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `ogrenci`
--

INSERT INTO `ogrenci` (`kod`, `no`, `TC`, `sifre`, `isim`, `okul_kod`) VALUES
(1, 100, '218', 'yaren1763', 'Yaren Can', 1),
(2, 105, '5', '105', 'İstanbul', 1),
(5, 6, '6', '6', '6', 3),
(6, 0, '0', '0', '0', 1),
(7, 7, '7', '7', '7', 1),
(8, 88, '88', '88', '88', 1),
(9, 4, '4', 'Sevval', '123', 1),
(12, 1, '02', 'can09', 'can', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogretmen`
--

DROP TABLE IF EXISTS `ogretmen`;
CREATE TABLE IF NOT EXISTS `ogretmen` (
  `kod` int(11) NOT NULL AUTO_INCREMENT,
  `no` int(255) NOT NULL,
  `TC` varchar(11) NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `isim` varchar(255) NOT NULL,
  `okul_kod` int(11) NOT NULL,
  PRIMARY KEY (`kod`),
  KEY `okul_kod` (`okul_kod`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `ogretmen`
--

INSERT INTO `ogretmen` (`kod`, `no`, `TC`, `sifre`, `isim`, `okul_kod`) VALUES
(6, 1, '1', '1', '1', 1),
(7, 8, '8', '8', '8', 1),
(8, 3, '3', '3', '3', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `okul`
--

DROP TABLE IF EXISTS `okul`;
CREATE TABLE IF NOT EXISTS `okul` (
  `kod` int(11) NOT NULL AUTO_INCREMENT,
  `isim` varchar(255) NOT NULL,
  `kademe` varchar(255) NOT NULL,
  `tur` varchar(255) NOT NULL,
  `il` varchar(45) NOT NULL,
  `iletisim_no` varchar(20) NOT NULL,
  PRIMARY KEY (`kod`),
  UNIQUE KEY `isim_UNIQUE` (`isim`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `okul`
--

INSERT INTO `okul` (`kod`, `isim`, `kademe`, `tur`, `il`, `iletisim_no`) VALUES
(1, 'Marmara Üniversitesi', 'Üniversite', 'Devlet', 'İstanbul', '02167772000'),
(2, 'İstanbul Teknik Üniversitesi', 'Üniversite', 'Devlet', 'istanbul', '001'),
(3, 'Asiye Ağaoğlu Anadolu Lisesi', 'Lise', 'Devlet', 'istanbul', '44');

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `alinan_ders`
--
ALTER TABLE `alinan_ders`
  ADD CONSTRAINT `alinan_ders_ibfk_1` FOREIGN KEY (`ogrenci_kod`) REFERENCES `ogrenci` (`kod`);

--
-- Tablo kısıtlamaları `devamsizlik`
--
ALTER TABLE `devamsizlik`
  ADD CONSTRAINT `devamsizlik_ibfk_1` FOREIGN KEY (`ogrenci_kod`) REFERENCES `ogrenci` (`kod`);

--
-- Tablo kısıtlamaları `idari_personel`
--
ALTER TABLE `idari_personel`
  ADD CONSTRAINT `idari_personel_ibfk_1` FOREIGN KEY (`okul_kod`) REFERENCES `okul` (`kod`);

--
-- Tablo kısıtlamaları `ogrenci`
--
ALTER TABLE `ogrenci`
  ADD CONSTRAINT `fk_ogrenci_okul` FOREIGN KEY (`okul_kod`) REFERENCES `okul` (`kod`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Tablo kısıtlamaları `ogretmen`
--
ALTER TABLE `ogretmen`
  ADD CONSTRAINT `ogretmen_ibfk_1` FOREIGN KEY (`okul_kod`) REFERENCES `okul` (`kod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
