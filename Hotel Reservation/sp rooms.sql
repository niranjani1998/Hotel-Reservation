USE [hotel reservation]
GO

/****** Object:  StoredProcedure [dbo].[uspAddRooms]    Script Date: 6/5/2019 4:11:38 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE PROCEDURE [dbo].[Roomssp]
    @pHotelid [varchar](20) ,
       @pRoomid [varchar](20) ,
       @pRoom_Desc [varchar](40),
       @pTotal_No_Of_Rooms varchar(20),
       @pRoom_Rent varchar(10) ,
       @pOccupancy_Allowed varchar(20) ,
       @pRoom_Available [integer] ,
    @OutputMessage NVARCHAR(250)='' OUTPUT
AS
BEGIN
    SET NOCOUNT ON

       BEGIN TRY
       

        INSERT INTO dbo.RoomDetails (Hotelid,Roomid,Room_Desc,Total_No_Of_Rooms,Room_Rent,Occupancy_Allowed,Room_Available)
        VALUES(@pHotelid,@pRoomid,@pRoom_Desc,@pTotal_No_Of_Rooms,@pRoom_Rent,@pOccupancy_Allowed,Null)

        SET @OutputMessage='New Rooms added to the Hotel Successfully'
              select  @OutputMessage
    END TRY
    BEGIN CATCH
          declare @Error_Message varchar(max)=ERROR_MESSAGE() 
          
        SET @OutputMessage=case when @Error_Message like '%FOREIGN KEY%constraint%' then 'Hotel Doesnt exist'
                                                                                                    else @Error_Message end


              select @OutputMessage
    END CATCH

END

GO


