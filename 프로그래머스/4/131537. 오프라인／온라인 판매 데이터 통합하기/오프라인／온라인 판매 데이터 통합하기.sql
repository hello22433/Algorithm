-- 코드를 입력하세요
SELECT SALES_DATE, PRODUCT_ID, USER_ID,	SALES_AMOUNT
from (
    select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, product_id, user_id, sales_amount
    from online_sale
    where SALES_DATE >= '2022-03-01' and SALES_DATE <= '2022-03-31'
    
    union all
    
    select date_format(sales_date, '%Y-%m-%d') as SALES_DATE, product_id, null as user_id, sales_amount
    from offline_sale
    where SALES_DATE >= '2022-03-01' and SALES_DATE <= '2022-03-31'
) as total_sales
group by sales_date, product_id, USER_ID, SALES_AMOUNT
order by SALES_DATE asc, product_id asc, user_id asc;