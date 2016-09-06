/*
(644ms)
方法二：这个方法基本思路与方法一是一致的，但是它是先将所有Score都唯一化，并且作为一个临时表，
MySQL每次进行查询时就利用这个临时表，因此性能比方法一好很多
*/
select Score, 
	(select count(*) from (select distinct Score as s from Scores) as tmp where s >= Score) as Rank
from Scores
order by Score desc