/*
(1076ms)
方法三：
这种做法比较符合正常思维，它是将Scores表按一定条件inner Join，
比如对于id=1,Score=4.0，将大于等于这个成绩的选出来附加在其后，那么在求rank时，
只需要看附加了多少条不同的成绩就可以知道排名了。
*/
select s.Score, count(distinct t.Score) as Rank
from Scores as s join Scores as t 
on s.Score <= t.Score
group by s.Id
order by s.Score desc