-- 코드를 입력하세요
SELECT title, r.board_id, reply_id, r.writer_id, r.contents, r.created_date
from used_goods_board b
inner join used_goods_reply r on b.board_id = r.board_id
where b.created_date > '2022-09-30' and b.created_date < '2022-11-01'
order by r.created_date ASC, b.TITLE ASC;