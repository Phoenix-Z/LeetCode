/*
(1055ms)
这个方法容易理解，先将Employee表和Department表内连接，然后在Employee表中找大于某个元组Salary的个数
不超过三个的，那么这个元组就在结果集中。当然可以看出这个方法效率偏低
*/
select d.Name as Department, e1.Name as Employee, e1.Salary
from Employee e1 
join Department d
on e1.DepartmentId = d.Id
where 3 > (select count(distinct(e2.Salary)) 
                  from Employee e2 
                  where e2.Salary > e1.Salary 
                  and e1.DepartmentId = e2.DepartmentId
                  );