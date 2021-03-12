

-- ---------------------------------------------------------------------------
-- puzzle link: https://www.hackerrank.com/challenges/weather-observation-station-17/problem 

select round(long_w, 4) from station where lat_n > 38.7780 order by lat_n asc limit 1
-- ---------------------------------------------------------------------------


-- ---------------------------------------------------------------------------
-- puzzle link: https://www.hackerrank.com/challenges/the-report/problem

select
CASE
    WHEN g.grade > 7 THEN s.name
    ELSE 'NULL'
END,
g.grade, s.marks
from students s, grades g where s.marks >= g.min_mark and s.marks <= g.max_mark
order by g.grade desc, s.name asc
-- ---------------------------------------------------------------------------


-- ---------------------------------------------------------------------------
-- puzzle link: https://www.hackerrank.com/challenges/asian-population/problem

select sum(ci.population) from city ci, country co where ci.countrycode = co.code and co.continent = 'Asia'
-- ---------------------------------------------------------------------------


-- ---------------------------------------------------------------------------
-- puzzle link: https://www.hackerrank.com/challenges/revising-aggregations-sum/problem

SELECT SUM(POPULATION) FROM CITY WHERE DISTRICT = 'California';
-- ---------------------------------------------------------------------------

