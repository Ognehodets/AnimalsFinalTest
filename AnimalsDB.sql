CREATE DATABASE Animals;

USE Animals;

DROP TABLE IF EXISTS Pets;

CREATE TABLE Pets (
id int auto_increment not null primary key,
name varchar(45) not null,
type varchar(45) not null,
birthDate date not null,
commands varchar(250) not null 
);

INSERT INTO Pets (name, type, birthDate, commands)
VALUES ("Fido", "dog", "2020-01-01", "sit, stay, fetch"),
("Whiskers", "cat", "2019-05-15", "sit, pounce"),
("Hammy", "hamster", "2021-03-10", "roll, hide, тапать"), 
("Buddy", "dog", "2018-12-10", "sit, paw, bark"),
("Smudge", "cat", "2020-02-20", "sit, pounce, scratch"),
("JasonStatham", "hamster", "2021-08-01", "roll, hide, тапать");

SELECT * FROM Pets;

DROP TABLE IF EXISTS PackAnimals;

CREATE TABLE PackAnimals(
id int auto_increment not null primary key,
name varchar(45) not null,
type varchar(45) not null,
birthDate date not null,
commands varchar(250) not null 
);

INSERT INTO PackAnimals (name, type, birthDate, commands)
VALUES ("Thunder", "horse", "2015-07-21", "trot, canter, gallop"),
("Sandy", "camel", "2016-11-03", "walk, carry load"),
("Eeyore", "donkey", "2017-09-18", "walk, carry load, bray"),
("Storm", "horse", "2014-05-05", "trot, canter"),
("Dune", "camel", "2018-12-12", "walk, sit"),
("Burro", "donkey", "2019-01-23", "walk, bray, kick"),
("Blaze", "horse", "2016-02-29", "trot, jump, gallop");

SELECT * FROM PackAnimals;

/*Необходимо удалить записи о верблюдах. 
Для этого пришлось отключить режим безопасных обновлений.*/
SET SQL_SAFE_UPDATES = 0;
DELETE FROM PackAnimals
WHERE type="camel";

SELECT * FROM PackAnimals;

/*Необходимо объединить две таблицы в одну с указанием на принадлежность изначальной таблице.
Для этого добавлено новое поле "originalTable".*/
SELECT name, type, birthDate, commands, "Pets" AS originalTable FROM Pets
UNION 
SELECT name, type, birthDate, commands, "PackAnimals" AS originalTable FROM PackAnimals;


/*Необходимо вывести всех животных в возрасте от 1 до 3 лет, для этого их возраст выделен в отдельное поле "age".*/
SELECT name, type, birthDate, commands, 
DATEDIFF(NOW(), birthDate)/365 AS age
FROM Pets WHERE DATEDIFF(NOW(), birthDate)/365 BETWEEN 1 AND 3
UNION
SELECT name, type, birthDate, commands, 
DATEDIFF(NOW(), birthDate)/365 AS age
FROM PackAnimals WHERE DATEDIFF(NOW(), birthDate)/365 BETWEEN 1 AND 3;


