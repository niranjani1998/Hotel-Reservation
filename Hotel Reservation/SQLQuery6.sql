 create TABLE Room(
roomid varchar(10) NOT NULL PRIMARY KEY,
roomtype varchar(40) NOT NULl,
roomno integer NOT NULL,
hotelid varchar(10),
price integer NOT NULL,
);

alter table [dbo].[Room] add foreign key([hotelid]) references [dbo].[Location]([hotelid]);
alter table [dbo].[Room]
alter column hotelid varchar(10);
ALTER TABLE Room
add price integer;

insert into [Room] (roomid,roomtype,roomno,hotelid,price) values ('2v','ac',31,'vi03',9500);

update Room set hotelid= 'ac09' where  roomid='1a';

select * from[dbo].[Location];
select * from [dbo].[Room];


Select hotelid from room where hotelid not in (Select hotelid from location)

Select hotelid,LTRIM(RTRIM(hotelid)) from location where LTRIM(RTRIM(hotelid)) ---= 'ac09'
='ge10'


 ac09


 Select RTRIM(LTRIM('    niranjani    '))


 update location set hotelid = LTRIM(RTRIM(hotelid)) where LTRIM(RTRIM(hotelid)) in ('ac09','ge10')