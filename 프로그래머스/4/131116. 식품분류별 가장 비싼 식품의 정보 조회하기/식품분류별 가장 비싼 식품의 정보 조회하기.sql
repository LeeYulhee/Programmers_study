WITH PRICE_RANK AS (
    SELECT ROW_NUMBER() OVER(PARTITION BY CATEGORY ORDER BY PRICE DESC) AS `RN`
         , PRODUCT_NAME
         , CATEGORY
         , PRICE
      FROM FOOD_PRODUCT
)
SELECT CATEGORY
     , PRICE AS `MAX_PRICE`
     , PRODUCT_NAME
  FROM PRICE_RANK
 WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
   AND RN = 1
 ORDER BY MAX_PRICE DESC
;