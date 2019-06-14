select * from [dbo].[Location];
select R.Guest_name,R.Cancellation_charge,Rm.Room_Desc,H.HotelName from Reservation_Details R
join Cancellation_Rate C on C.Cancellation_code=R.Cancellation_code
join RoomDetails Rm on Rm.Roomid=R.Roomid
join HotelDetails H on H.Hotelid=R.Hotelid;
select   A.Guest_name,S.Room_Desc,K.HotelName,A.Booking_Amount,A.Payment_mode,D.FacilityDesc from Reservation_Details A
join RoomDetails S on  S.Roomid=A.Roomid
join HotelDetails K on K.Hotelid=A.Hotelid
join FacilityDetails D on D.FacilityId=K.FacilityId;
select Check_In_date,Check_Out_Date,No_of_Rooms,Booking_Date from Reservation_Details;


alter table Reservation_Details add foreign key (Cancellation_code) references Cancellation_Rate(Cancellation_code);