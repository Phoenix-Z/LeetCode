/*
解法二：这种解法同解法一类似，只是用"<"来代替"not in"
注意：需要查询到的结果需要使用别名
*/
select max(Salary) as SecondHighestSalary
from Employee 
where Salary <(select max(Salary) 
				from Employee);
