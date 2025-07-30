# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(CASE WHEN order_date = customer_pref_delivery_date THEN 1 END) * 100.0 
        / COUNT(DISTINCT customer_id), 
        2
    ) AS immediate_percentage
FROM 
    Delivery d
WHERE 
    order_date = (
        SELECT MIN(order_date)
        FROM Delivery
        WHERE customer_id = d.customer_id
    );



#select count(*)*100/(count(distinct customer_id)) as immediate_percentage from Delivery where order_date=customer_pref_delivery_date;