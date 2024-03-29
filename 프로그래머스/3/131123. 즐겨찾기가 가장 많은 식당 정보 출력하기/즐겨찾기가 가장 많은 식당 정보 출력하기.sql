SELECT FOOD_TYPE
     , REST_ID
     , REST_NAME
     , FAVORITES
 FROM (
        SELECT FOOD_TYPE
             , REST_ID
             , ROW_NUMBER() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) AS RN
             , FAVORITES
             , REST_NAME
          FROM REST_INFO
      ) AS SUBQUERY
WHERE RN = 1
ORDER BY FOOD_TYPE DESC