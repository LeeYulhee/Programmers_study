SELECT P.PRODUCT_CODE
     , SUM(O.SALES_AMOUNT) * P.PRICE SALES
  FROM PRODUCT P
 INNER JOIN OFFLINE_SALE O
    ON O.PRODUCT_ID = P.PRODUCT_ID
 GROUP BY O.PRODUCT_ID
 ORDER BY SALES DESC, P.PRODUCT_CODE
;
 