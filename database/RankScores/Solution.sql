/*
(1071ms)
方法一：这个方法就是将Scores表按照Score降序排列
Rank是通过使用一个查询来实现的，查询Scores 表中大于等于当前Score的成绩个数(使用distinct实现不出现holes)
*/
select Score, 
	(select count(distinct Score) from Scores where Score >= s.Score) as Rank
from Scores as s
order by Score desc