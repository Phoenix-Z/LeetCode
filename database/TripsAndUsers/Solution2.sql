/*
(140ms)
这个方法与方法一差不多，主要的区别在于这个方法使用的是sum聚合函数
*/
select 
t.Request_at Day, 
round(sum(case when t.Status like 'cancelled_%' then 1 else 0 end)/count(*),2) 'Cancellation Rate'
from Trips t 
inner join Users u 
on t.Client_Id = u.Users_Id and u.Banned='No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at