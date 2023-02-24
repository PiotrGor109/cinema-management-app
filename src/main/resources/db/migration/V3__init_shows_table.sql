create table shows (
id int primary key auto_increment,
title varchar(200),
duration_time double,
movie_type varchar(200),
image_path varchar(200),
date_time timestamp,
cinema_hall_id int,
foreign key(cinema_hall_id) references cinema_halls(id)
);