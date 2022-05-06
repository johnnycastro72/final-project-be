CREATE TABLE `category` (
  `id` long PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `task` (
  `id` long PRIMARY KEY AUTO_INCREMENT,
  `idcategory` long,
  `message` varchar(255) UNIQUE NOT NULL,
  `done` boolean
);

ALTER TABLE `task` ADD FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`);
