SELECT a.ANIMAL_ID,a.NAME
FROM ANIMAL_OUTS a
LEFT OUTER JOIN ANIMAL_INS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.ANIMAL_ID NOT IN (SELECT ANIMAL_ID
                         FROM ANIMAL_INS)
ORDER BY a.ANIMAL_ID
