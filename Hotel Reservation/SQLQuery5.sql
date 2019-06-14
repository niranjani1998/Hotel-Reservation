CREATE TABLE Location(
hotelid varchar(10) NOT NULL PRIMARY KEY,
area varchar(40) NOT NULl,
hotelname varchar(40) NOT NULL,

);
insert into [dbo].[Location] (hotelid,area,hotelname,hoteltype) values(' ge10','omr','geetham homes','r');
--ALTER TABLE [dbo].[Location]
--ADD hoteltype varchar(70);
select * from [dbo].[Location] ;
