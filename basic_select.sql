-- output total number of cities minus unique cities
select count(city) - count(distinct city) from station


-- print city, length of city name for shortest and longest city names
-- if there's more than one, show alphabetically first city
select city as c, char_length(city) as cl from station order by cl asc, c asc limit 1;
select city as c, char_length(city) as cl from station order by cl desc, c asc limit 1;
