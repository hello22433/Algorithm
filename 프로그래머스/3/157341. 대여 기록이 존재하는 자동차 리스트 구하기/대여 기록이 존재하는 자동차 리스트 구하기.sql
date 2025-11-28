-- 코드를 입력하세요
SELECT distinct(c.CAR_ID)
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY r on c.CAR_ID = r.CAR_ID
where c.CAR_TYPE = '세단' and r.START_DATE between '2022-10-01' and '2022-10-31'
order by c.CAR_ID desc;