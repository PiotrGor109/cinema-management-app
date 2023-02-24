create table seats (
    id int primary key auto_increment,
    seat_number int,
    status varchar(200),
    show_id int,
    foreign key(show_id) references shows(id),
    reservation_id int,
    foreign key(reservation_id) references reservations(id)
);


