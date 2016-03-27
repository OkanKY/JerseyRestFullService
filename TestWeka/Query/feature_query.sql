SELECT p.productID,fp.profitValue,f.addressID,f.area
FROM Field AS f
LEFT JOIN Product AS p
ON f.fieldID = p.fieldID
LEFT JOIN FinishedProduct AS fp
ON p.productID = fp.productID  
GROUP BY p.productID;