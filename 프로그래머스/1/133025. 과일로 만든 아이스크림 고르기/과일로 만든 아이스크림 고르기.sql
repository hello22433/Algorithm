-- 코드를 입력하세요
SELECT i.FLAVOR
from ICECREAM_INFO i
join FIRST_HALF f on f.FLAVOR = i.FLAVOR
where TOTAL_ORDER >= 3000 AND INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER desc;