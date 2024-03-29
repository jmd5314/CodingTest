SELECT a.PRODUCT_ID,PRODUCT_NAME,SUM(PRICE*AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT a
JOIN FOOD_ORDER b 
ON a.PRODUCT_ID = b.PRODUCT_ID
WHERE DATE_FORMAT(b.PRODUCE_DATE,'%Y-%m') = '2022-05'
GROUP BY a.PRODUCT_ID
ORDER BY TOTAL_SALES DESC,a.PRODUCT_ID