-- 코드를 입력하세요
SELECT P.*
FROM PLACES P
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES 
    GROUP BY HOST_ID
    HAVING count(*) > 1 )
ORDER BY P.ID