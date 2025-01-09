SELECT ORDER_ID
     , PRODUCT_ID
     , DATE_FORMAT(OUT_DATE, '%Y-%m-%d')
     , CASE WHEN OUT_DATE < '2022-05-02'  THEN '출고완료'
            WHEN OUT_DATE >= '2022-05-02' THEN '출고대기'
            ELSE '출고미정'
       END '출고여부'
  FROM FOOD_ORDER
 ORDER BY ORDER_ID
;