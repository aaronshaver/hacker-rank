-- output total number of cities minus unique cities
select count(city) - count(distinct city) from station


-- print city, length of city name for shortest and longest city names
-- if there's more than one, show alphabetically first city
select city as c, char_length(city) as cl from station order by cl asc, c asc limit 1;
select city as c, char_length(city) as cl from station order by cl desc, c asc limit 1;


/* get city names starting with vowels, no dupes */
select distinct city from station where city RLIKE '^[aeiou]';


/* get city names ending with vowels, no dupes */
select distinct city from station where city RLIKE '[aeiou]$';


/* get city names both beginning and ending with vowels, no dupes */
select distinct city from station where city RLIKE '[aeiou]$' and city RLIKE '^[aeiou]';


/* get city names that do not start with vowels, no dupes */
select distinct city from station where not city RLIKE '^[aeiou]';


/* get city names that do not end with vowels, no dupes */
select distinct city from station where not city RLIKE '[aeiou]$';


/* get city names that do not end with vowels, OR that do not begin with vowels, no dupes */
select distinct city from station where not city RLIKE '[aeiou]$' or not city RLIKE '^[aeiou]' ;


/* get city names that do not end with vowels, AND that do not begin with vowels, no dupes */
select distinct city from station where not city RLIKE '[aeiou]$' and not city RLIKE '^[aeiou]' ;


/* show students with marks greater than 75; order by last 3 chars of name; if last 3 match, secondary order by
ascending id */
select name from students where marks > 75 order by substring(name, -3), id asc;


/* Write a query that prints a list of employee names (i.e.: the name attribute) for employees in Employee having a
salary greater than  per month who have been employees for less than  months. Sort your result by ascending
employee_id. */
select name from employee where salary > 2000 and months < 10;


