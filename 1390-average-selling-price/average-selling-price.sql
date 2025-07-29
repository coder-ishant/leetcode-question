# Write your MySQL query statement below
SELECT 
  p.product_id,
   ROUND(
        IFNULL(SUM(u.units * p.price) / SUM(u.units), 0)
    , 2) AS average_price
FROM 
  Prices p
left JOIN 
  UnitsSold u ON p.product_id = u.product_id and u.purchase_date between start_date and end_date
GROUP BY 
  p.product_id;
