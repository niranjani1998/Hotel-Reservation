
select * from[dbo].[Reservation_Details]
select Guest_name,Booking_Date,No_of_Rooms,username from Reservation_Details R
join UserDetails U on U.userid=R.userid where Hotelid='ha05';
