-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(s.SALES) AS TOTAL_SALES
from BOOK b
join BOOK_SALES s on b.BOOK_ID = s.BOOK_ID
where s.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.CATEGORY
order by b.CATEGORY;