/* Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'. */
select sum(population) from city where city.CountryCode in (select code from country where continent = 'Asia');


/* Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.*/
select name from city where countrycode in (select code from country where continent = 'Africa');


/* Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) and their respective
average city populations (CITY.Population) rounded down to the nearest integer. */
select country.continent, floor(avg(city.population)) from city inner join country on city.countrycode = country.code
group by country.continent;


