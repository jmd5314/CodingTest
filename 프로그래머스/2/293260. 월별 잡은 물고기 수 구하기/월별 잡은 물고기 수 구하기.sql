SELECT COUNT(ID) AS FISH_COUNT, MONTH(TIME) as 'MONTH'
FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY MONTH