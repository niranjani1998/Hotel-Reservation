USE [hotel reservation]
GO

/****** Object:  StoredProcedure [dbo].[uspLogin]    Script Date: 6/5/2019 3:19:12 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[Loginsp]
    @pUserId VARCHAR(20),
    @ppasswo VARCHAR(20)
AS
BEGIN

    SET NOCOUNT ON

    DECLARE @userID NVARCHAR(max)

    IF EXISTS (SELECT TOP 1 UserId  FROM [dbo].[UserDetails]  WHERE UserId=@pUserId)
    BEGIN
        SET @userID=(SELECT UserId FROM [dbo].[UserDetails] WHERE UserId=@pUserId AND passwo=HASHBYTES('MD5',cast(@ppasswo as varchar(max))))

       IF(@userID IS NULL)
           select 'Incorrect password'
       ELSE 
           select 'User successfully logged in'

    END
    
	ELSE
              select 'Invalid login'
       

END

--exec uspLogin 'ts1','gOODD1234'


GO


exec  [dbo].[Loginsp] '#37','y@nis@r@'
