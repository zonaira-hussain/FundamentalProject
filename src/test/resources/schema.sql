DROP TABLE IF EXISTS review;
CREATE TABLE IF NOT EXISTS review (
reviewID int PRIMARY KEY auto_increment,
title varchar(500) not null,
genre varchar(100) not null,
rating tinyint not null,
summary varchar(3000)
);


