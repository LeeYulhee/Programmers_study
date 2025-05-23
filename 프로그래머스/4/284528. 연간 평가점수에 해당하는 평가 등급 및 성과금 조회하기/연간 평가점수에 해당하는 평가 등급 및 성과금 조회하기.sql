WITH GRADE_TABLE AS (
    SELECT EMP_NO
         , CASE WHEN TRUNCATE(AVG(SCORE), 0) >= 96 THEN 'S'
                WHEN TRUNCATE(AVG(SCORE), 0) >= 90 THEN 'A'
                WHEN TRUNCATE(AVG(SCORE), 0) >= 80 THEN 'B'
                ELSE 'C'
            END AS `GRADE`
      FROM HR_GRADE
     GROUP BY EMP_NO
)
SELECT E.EMP_NO
     , E.EMP_NAME
     , G.GRADE
     , CASE WHEN GRADE = 'S' THEN TRUNCATE(E.SAL * 0.2, 0)
            WHEN GRADE = 'A' THEN TRUNCATE(E.SAL * 0.15, 0)
            WHEN GRADE = 'B' THEN TRUNCATE(E.SAL * 0.1, 0)
            ELSE 0
        END AS `BONUS`
  FROM HR_EMPLOYEES E
 INNER JOIN GRADE_TABLE G
    ON G.EMP_NO = E.EMP_NO
 ORDER BY E.EMP_NO
;
