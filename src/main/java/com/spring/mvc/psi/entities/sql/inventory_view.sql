-- 庫存 1
-- 建立一個View, 名稱 : Inventory
-- id, name, 買進數量, 買進總價, 賣出數量, 賣出總價
SELECT p.id, p.name, p.image,
       pu.q as pu_qty, pu.pq as pu_total,
       sa.q as sa_qty, sa.pq as sa_total
FROM Product p
LEFT JOIN (SELECT p.ID as pid, SUM(pu.QUANTITY) as q, SUM(pu.PRICE * pu.QUANTITY) as pq FROM PRODUCT p, PURCHASE pu WHERE p.ID = pu.PID GROUP BY p.ID) as pu
ON p.id = pu.pid
LEFT JOIN (SELECT p.ID as pid, SUM(sa.QUANTITY) as q, SUM(sa.PRICE * sa.QUANTITY) as pq FROM PRODUCT p, Sales sa WHERE p.ID = sa.PID GROUP BY p.ID) as sa
ON p.id = sa.pid
