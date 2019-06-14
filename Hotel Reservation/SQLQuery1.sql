
ALTER TABLE UserDetails
CHANGE COLUMN userid userid INT NOT NULL AUTO_INCREMENT;

ALTER TABLE UserDetails RENAME COLUMN userid to UserId;


select * from Reservation_Details;
EXEC sp_RENAME 'Reservation_Details.userid' , 'UserId', 'COLUMN'
select * from Booking_Rates;
ALTER TABLE Booking_Rates DROP column [Booking_code];
alter table Booking_Rates add Booking_ref varchar(30) not null primary key 
insert into UserDetails values('#36','poori@gmail.com','7871395195','poori','poori');

select * from Reservation_Details
insert into Booking_Rates values('ha05','P1','2 month','10%','2m2');
delete from [dbo].[Booking_Rates]
select count(Cancellation_code) from Reservation_Details;
insert into Reservation_Details(Booking_Id,UserId,Hotelid,Roomid,Guest_name,Check_In_Date,Check_Out_Date,No_of_Rooms,Booking_Amount,Booking_Date,Transaction_id,Transaction_amount, Payment_Description,Payment_mode) values('$3','#36','ha05','P1','poori','2019/06/09','2019/06/18',2,2000,'2019/06/03','poori#',2000,'Fully paid','UPI');

select H.HotelName,R.Guest_name,count(*)Booking_ref from Reservation_Details R
join HotelDetails H on H.Hotelid=R.Hotelid
group by H.HotelName,R.Guest_name,R.Booking_ref 


update Reservation_Details set Booking_ref='1m'
where Booking_Id='$1';
update Reservation_Details set Booking_ref='sd2'
where Booking_Id='$3';
insert into RoomDetails values('ac09','C1','Conference hall',3,5000,500,2);
alter table Reservation_Details add foreign key (Booking_ref) references Booking_Rates(Booking_ref);
insert into HotelDetails values('ac09','accord metro','56 rajiv gandhi salai','omr','chennai','india',600114,'arul',7890654321,'accord@gmail.com','accordmetro.in','3@');

