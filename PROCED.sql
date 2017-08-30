CREATE PROCEDURE PROCED
AS
SET NOCOUNT ON
DECLARE @prod_id bigint, @frequency int,
		@title varchar(10),
		@category varchar(10), @message varchar(80)

PRINT '-----Popular Products Report-----'

DECLARE Popular_Cursor CURSOR FOR
SELECT P1.PRODID, P1.TITLE, P1.CATEGORY, P1.FREQUENCY
FROM PRODS_MORE P1
WHERE P1.FREQUENCY >
	(SELECT AVG(P.FREQUENCY)
	FROM PRODS_MORE P WHERE P.FREQUENCY > 0)
	ORDER BY FREQUENCY DESC

OPEN Popular_Cursor
FETCH NEXT FROM Popular_Cursor INTO @prod_id,
				@title, @category, @frequency
WHILE @@FETCH_STATUS=0
BEGIN
PRINT ''
SELECT @message=@title+'    '+@category+'    '

PRINT RTRIM(CAST(@prod_id AS VARCHAR(10)))+'    '+
@message+RTRIM(CAST(@frequency AS VARCHAR(10)))

SELECT @prod_id, @title, @category, @frequency

FETCH NEXT FROM Popular_Cursor INTO @prod_id,
				@title, @category, @frequency

END
CLOSE Popular_Cursor
DEALLOCATE Popular_Cursor
SET NOCOUNT OFF