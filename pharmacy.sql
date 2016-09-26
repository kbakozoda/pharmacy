-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Сен 26 2016 г., 13:52
-- Версия сервера: 5.7.11
-- Версия PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `pharmacy`
--

-- --------------------------------------------------------

--
-- Структура таблицы `drugs`
--

CREATE TABLE `drugs` (
  `id` int(11) NOT NULL,
  `typeid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `instruction` text NOT NULL,
  `agerestriction` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `drugs`
--

INSERT INTO `drugs` (`id`, `typeid`, `name`, `instruction`, `agerestriction`) VALUES
(7, 7, 'testmed', 'qweqweq', 0),
(16, 11, 'fffff', 'asdffdsa', 11),
(15, 7, 'asdf', 'bad drugx', 12);

-- --------------------------------------------------------

--
-- Структура таблицы `drugtypes`
--

CREATE TABLE `drugtypes` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `drugtypes`
--

INSERT INTO `drugtypes` (`id`, `name`) VALUES
(16, 'rrd'),
(14, 'aaaab'),
(11, 'fd'),
(7, 'Test space'),
(13, 'secc'),
(12, 'fsdfsdf');

-- --------------------------------------------------------

--
-- Структура таблицы `networks`
--

CREATE TABLE `networks` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `adminId` int(11) NOT NULL DEFAULT '-1'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `networks`
--

INSERT INTO `networks` (`id`, `name`, `adminId`) VALUES
(2, 'TestNetwork1', 3),
(3, 'd8s', 6),
(5, 'netw', 8),
(6, 'nbc', -1),
(8, 'bbc', -1);

-- --------------------------------------------------------

--
-- Структура таблицы `operationhistory`
--

CREATE TABLE `operationhistory` (
  `id` int(11) NOT NULL,
  `networkid` int(11) NOT NULL,
  `pharmacyid` int(11) NOT NULL,
  `purchasedate` date NOT NULL,
  `drugid` int(11) NOT NULL,
  `totalexpense` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `operationhistory`
--

INSERT INTO `operationhistory` (`id`, `networkid`, `pharmacyid`, `purchasedate`, `drugid`, `totalexpense`) VALUES
(1, 1, 1, '2016-09-08', 1, 123),
(2, 5, 3, '2016-09-02', 7, 12);

-- --------------------------------------------------------

--
-- Структура таблицы `pharmacies`
--

CREATE TABLE `pharmacies` (
  `id` int(11) NOT NULL,
  `networkid` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `pharmacistid` int(11) NOT NULL DEFAULT '-1',
  `address` varchar(50) NOT NULL DEFAULT 'undef.'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `pharmacies`
--

INSERT INTO `pharmacies` (`id`, `networkid`, `number`, `pharmacistid`, `address`) VALUES
(1, 1, 119, -1, 'lolstreet 87'),
(2, 1, 116, -1, 'lolstreet 26'),
(3, 5, 113, 9, 'obshaga 1'),
(10, 5, 312, 11, 'undef.'),
(8, 5, 130, 7, '5ret 453'),
(9, 5, 129, 12, 'bbgf');

-- --------------------------------------------------------

--
-- Структура таблицы `requeststoadmin`
--

CREATE TABLE `requeststoadmin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `pharmacyid` int(11) NOT NULL,
  `networkid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `requeststoadmin`
--

INSERT INTO `requeststoadmin` (`id`, `username`, `password`, `name`, `surname`, `pharmacyid`, `networkid`) VALUES
(2, 'test1', 'qwerty123', 'Test', 'fff', 2, 1),
(3, 'superph', 'abcdefg123', 'abcdefg', 'HIJKL', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `requeststogod`
--

CREATE TABLE `requeststogod` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `networkid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'superuser'),
(2, 'admin'),
(3, 'pharmacist');

-- --------------------------------------------------------

--
-- Структура таблицы `sqltest`
--

CREATE TABLE `sqltest` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `sqltest`
--

INSERT INTO `sqltest` (`id`, `name`, `surname`) VALUES
(1, 'Komron', 'Bakozoda'),
(2, 'Ilya', 'Kislyi'),
(3, 'Alexey', 'Palto'),
(4, 'asdf', 'ggg');

-- --------------------------------------------------------

--
-- Структура таблицы `stockcontent`
--

CREATE TABLE `stockcontent` (
  `id` int(11) NOT NULL,
  `drugid` int(11) NOT NULL,
  `priceofsingle` int(11) NOT NULL,
  `pharmacyid` int(11) NOT NULL,
  `networkid` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `stockcontent`
--

INSERT INTO `stockcontent` (`id`, `drugid`, `priceofsingle`, `pharmacyid`, `networkid`, `amount`) VALUES
(1, 1, 13, 1, 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `username`, `name`, `surname`, `password`, `role`) VALUES
(1, 'superuser', 'Network', 'God', 'qwerty1234', 1),
(2, 'testadmin1', 'Test', 'Admin', 'a', 2),
(3, 'testadmin2', 'Test', 'AdminSec', 'iamatestadmin', 2),
(4, 'bestPharm', 'Phar', 'Master', 'iamthebest', 3),
(6, 'testguy', 'Test', 'Guy', 'testguy123', 2),
(7, 'qwerty1', 'Team', 'qwer', 'qwerty1234', 3),
(8, 'testt', 'Test', 'Admin', 'asdffdsa123', 2),
(9, 'qwerty12', 'Ph', 'Inter', 'asdffdsa1234', 3),
(11, 'qwerty123', 'qwer', 'ty', 'asdfasdf123', 3),
(12, 'qwerty1234', 'asdf', 'ty', 'asdfasdf1234', 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `drugs`
--
ALTER TABLE `drugs`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `drugtypes`
--
ALTER TABLE `drugtypes`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `networks`
--
ALTER TABLE `networks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Индексы таблицы `operationhistory`
--
ALTER TABLE `operationhistory`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `pharmacies`
--
ALTER TABLE `pharmacies`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `requeststoadmin`
--
ALTER TABLE `requeststoadmin`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `requeststogod`
--
ALTER TABLE `requeststogod`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Индексы таблицы `sqltest`
--
ALTER TABLE `sqltest`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `stockcontent`
--
ALTER TABLE `stockcontent`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role` (`role`),
  ADD KEY `role_2` (`role`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `drugs`
--
ALTER TABLE `drugs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT для таблицы `drugtypes`
--
ALTER TABLE `drugtypes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT для таблицы `networks`
--
ALTER TABLE `networks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT для таблицы `operationhistory`
--
ALTER TABLE `operationhistory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `pharmacies`
--
ALTER TABLE `pharmacies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `requeststoadmin`
--
ALTER TABLE `requeststoadmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT для таблицы `requeststogod`
--
ALTER TABLE `requeststogod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `stockcontent`
--
ALTER TABLE `stockcontent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
