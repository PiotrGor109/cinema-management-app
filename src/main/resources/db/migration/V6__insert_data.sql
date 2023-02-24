Insert into cinema_halls values (1, 10);
Insert into cinema_halls values (2, 100);
Insert into cinema_halls values (3, 50);
Insert into cinema_halls values (4, 60);



Insert into shows values (1, 'Batman', 180, 'action, fantasy','batman.jpg', '2022-10-10 11:00', 1);
Insert into shows values (2,'Asterix', 240, 'comedy, animated','asterix.jpg', '2022-10-10 18:00', 1);
Insert into shows values (3, 'Piranha 3D', 80, 'action, comedy','piranha.jpg', '2022-10-10 13:00', 2);


Insert into tickets values (1, 'normal', 30);
Insert into tickets values (2, 'reduced', 20);

Insert into seats values (1, 1, 'free', 1, null);
Insert into seats values (2, 2, 'free', 1, null);

Insert into reservations values (1, 'Piotr Koralski', '794147671');
Insert into reservations values (2, 'Adam Wiecki', '123123123');


Update seats SET status='reserved',reservation_id=1 WHERE id=1;

