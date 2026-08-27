SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
-- join the same table to itself, offsetting id by 1 and 2,
-- so each row lines up with the next two consecutive rows
JOIN Logs l2 
    ON l1.id + 1 = l2.id 
    AND l1.num = l2.num
JOIN Logs l3 
    ON l1.id + 2 = l3.id 
    AND l1.num = l3.num;
-- if l1.num, l2.num, and l3.num are all equal for three consecutive ids,
-- then that num appears at least 3 times in a row