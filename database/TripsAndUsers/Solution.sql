/*
(122ms)
这个解法很优美，容易理解。在count中使用if也是第一次见
需要注意的是Cancellation Rate需要加上引号，以表示是一个整体
另外Banned，Request_at，Status这些列的值也需要加上引号，
*/
select Request_at as Day,
       round(count(if(Status != 'completed', true, null)) / count(*), 2) as 'Cancellation Rate'
from Trips
where (Request_at between '2013-10-01' and '2013-10-03')
      and Client_id not in (select Users_Id from Users where Banned = 'Yes')
group by Request_at;