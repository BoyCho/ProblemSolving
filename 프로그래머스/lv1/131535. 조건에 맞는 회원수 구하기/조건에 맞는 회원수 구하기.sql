-- 코드를 입력하세요
SELECT count(user_id) AS 'USERS'
FROM user_info
WHERE joined LIKE '2021-%' 
AND age BETWEEN 20 AND 29;