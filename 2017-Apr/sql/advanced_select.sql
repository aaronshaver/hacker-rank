/*
Write a query identifying the type of each record in the TRIANGLES table using its three side lengths.
*/

SELECT CASE
    WHEN (a + c <= b) or (a + b <= c) or (b + c <= a) then 'Not A Triangle'
    WHEN (a = b) and (b = c) and (a = c) THEN 'Equilateral'
    WHEN a != b and b != c and c != a THEN 'Scalene'
    ELSE 'Isosceles'
END
FROM Triangles;