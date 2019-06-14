-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[UserSp]
@pUserId varchar(20),
@pmailid varchar(25),
@pphoneno varchar(20),
@ppasswo varchar(20),
@pusername varchar(20),
@OutputMessage nvarchar(250)=''OUTPUT
As
BEGIN
     SET NOCOUNT ON
declare @password_Check varchar(20)=(select case when @ppasswo like '%[0-9]%' and @ppasswo like '%[A-Z]%' and @ppasswo like '%[!@#$%^&*()-_]%' and len(@ppasswo)>=8
                                                                               then 'password ok' else'password should be combination of numeric special symbols'end)



if(@password_Check='password ok')
begin
    BEGIN TRY


	       insert into [dbo].[UserDetails](UserId,mailid,phoneno,passwo,username) values(@pUserId,@pmailid,@pphoneno,HASHBYTES('md5',@ppasswo),@pusername)
		   set @OutputMessage='User created successfully'
		     select @OutputMessage
    END TRY
	BEGIN CATCH
	 declare @Error_Message varchar(max)=ERROR_MESSAGE() 
          
        SET @OutputMessage= case when @Error_Message like '%violation%primary%key%constraint%' then 'User Already exist'
                                                                                                   when @Error_Message like '%conflicted %Check constraint %phone%' then 'Invalid Phone Number'
                                                                                                         when @Error_Message like '%conflicted %Check constraint%mail%' then 'Invalid mail Id' 
                                                                                                         else @Error_Message end


              select @OutputMessage
    END CATCH
	end
if (@password_Check!='Password Ok')
begin
RAISERROR(@password_Check,16,1);

set @OutputMessage=@password_Check

select @OutputMessage
end
END


GO


exec [dbo].[UserSp] '#37','niji34@gmail.com',6789054321,'y@nis@r@09','sanjay'
select * from [dbo].[UserDetails]