/*
这种思路较为普遍，而且效率较高，衍生出了很多做法，其实思路是一样的。(820ms左右)
唯一的不同在于，用于比较时间的函数不一样。介绍以下几种：
(1)unix_timestamp:使用unix时间戳，需要注意的是相隔一天，时间戳相应相差86400 = 24 * 60 * 60
(2)to_days(date):从0年0月0日到date对应日期的天数，所以相差一天可以表示为：to_days(a.Date) - to_days(b.Date) = 1
(3)datediff(a.Date, b.Date): 这个方法相当容易理解，应该是最好的方案，就是两个日期相差几天
(4)subdate(a.Date, interval 1 day) = b.Date: subdate函数就是传入的date减去给定的第二个参数，也挺容易理解
*/
select w1.Id
from Weather as w1, Weather as w2
where w1.Temperature > w2.Temperature
--	and unix_timestamp(w1.Date) - unix_timestamp(w2.Date) = 86400
	and datediff(w1.Date, w2.Date) = 1