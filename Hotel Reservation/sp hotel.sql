USE [hotel reservation]
GO

/****** Object:  StoredProcedure [dbo].[uspAddHotel]    Script Date: 6/5/2019 3:53:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[Hotelsp]
    @pHotelid varchar(20),
    @pHotelName   VARCHAR(25),
    @pAddres   VARCHAR(40),
    @pArea   VARCHAR(20),
    @pCity   VARCHAR(20),
    @pCountry   VARCHAR(20) ,
    @pZipcode varchar(30) ,
    @pManagername   VARCHAR(20),
    @pPhone  varchar(20) ,
    @pEmail    VARCHAR(25),
    @pWebsite   VARCHAR(60),
    @pFacilityId    VARCHAR(20),
    @OutputMessage NVARCHAR(250)='' OUTPUT
AS
BEGIN
    SET NOCOUNT ON

       BEGIN TRY
       
       declare @pHotel_ID varchar(max)='HTL_'+CAST((SELECT COUNT(*)+1 FROM HotelDetails) AS VARCHAR(MAX))
        INSERT INTO [dbo].[HotelDetails] (Hotelid,HotelName,Addres,Area,City,Country,Zipcode,Managername,Phone,Email,Website,FacilityId)
        VALUES(@pHotelid,@pHotelName,@pAddres,@pArea,@pCity,@pCountry,@pZipcode,@pManagername,@pPhone,@pEmail,@pWebsite,@pFacilityId)

        SET @OutputMessage='New Hotel created Successfully'
              select  @OutputMessage
    END TRY
    BEGIN CATCH
          declare @Error_Message varchar(max)=ERROR_MESSAGE() 
          
        SET @OutputMessage=case when @Error_Message like '%violation%primary%key%constraint%' then 'Hotel Already exist'
                                                                                                   when @Error_Message like '%conflicted %Check constraint %phone%' then 'Invalid Phone Number'
                                                                                                         when @Error_Message like '%conflicted %Check constraint%ZIP%' then 'Invalid ZIP Code' 
                                                                                                         when @Error_Message like '%conflicted %Check constraint%mail%' then 'Invalid mail Id' 
                                                                                                         else @Error_Message end


              select @OutputMessage
    END CATCH

END

GO


exec  [dbo].[Hotelsp] '@le','Lemeridian','88 funcity near ','pelamedu','coimbatore','india',641045,'roy',9042964682,'le88@gmail.com','lemeridian.com','2@'
select * from [dbo].[HotelDetails]