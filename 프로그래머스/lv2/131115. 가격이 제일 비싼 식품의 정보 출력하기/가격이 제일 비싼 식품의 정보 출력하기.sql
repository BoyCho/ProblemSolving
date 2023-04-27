-- 코드를 입력하세요
SELECT *
FROM food_product
WHERE price = (SELECT max(price) FROM food_product)