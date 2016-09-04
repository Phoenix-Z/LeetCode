/*(951ms)
这题这么做已经可以了，有说使用left join或者inner join可以提高查询效率，
但在提交之后给出的结果来看，没有很大的区别。
*/
select e1.Name as Employee
from Employee as e1, Employee as e2
where e1.ManagerId = e2.Id
	and e1.Salary > e2.Salary