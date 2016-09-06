/*
(1125ms)
这个方法简单粗暴，但是很有效，
需要注意的是Num相等的条件应该分开写，而不应该写成这样：a.Num = b.Num = c.Num，
因为这不表示三个值相等，而是在比较完a.Num和b.Num是否相等之后，
将返回值(可能是0或1)与c.Num相比，很大可能是不相等的
*/
select distinct a.Num as ConsecutiveNums
from Logs as a, Logs as b, Logs as c
where a.Num = b.Num 
	and b.Num = c.Num
	and b.Id = a.Id + 1
	and c.Id = b.Id + 1