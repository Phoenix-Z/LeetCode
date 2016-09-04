/*
这种嵌套写法，效率很低，不值得推荐(1474ms)
*/
select Id
from Weather as w1
where Temperature > (select Temperature
					 from Weather as w2
					 where unix_timestamp(w1.Date) = unix_timestamp(w2.Date) + 86400)