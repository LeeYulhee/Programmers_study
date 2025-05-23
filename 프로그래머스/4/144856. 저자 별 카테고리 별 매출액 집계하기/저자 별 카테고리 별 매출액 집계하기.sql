SELECT B.AUTHOR_ID
     , A.AUTHOR_NAME
     , B.CATEGORY
     , SUM(S.SALES * B.PRICE) AS `TOTAL_SALES`
  FROM BOOK B
 INNER JOIN AUTHOR A
    ON B.AUTHOR_ID = A.AUTHOR_ID
 INNER JOIN BOOK_SALES S
    ON S.BOOK_ID = B.BOOK_ID
 WHERE DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01'    
 GROUP BY B.AUTHOR_ID, B.CATEGORY
 ORDER BY B.AUTHOR_ID, B.CATEGORY DESC