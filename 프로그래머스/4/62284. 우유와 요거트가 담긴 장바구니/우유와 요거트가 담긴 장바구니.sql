SELECT CART_ID
  FROM ( SELECT CART_ID
              , GROUP_CONCAT(NAME, ' ') AS `CONCAT_NAME`
           FROM CART_PRODUCTS
          GROUP BY CART_ID
         HAVING CONCAT_NAME LIKE '%Yogurt%'
            AND CONCAT_NAME LIKE '%Milk%'
  ) T
 GROUP BY CART_ID
 ORDER BY CART_ID
;