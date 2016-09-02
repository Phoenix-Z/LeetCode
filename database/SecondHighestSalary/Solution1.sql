/*
解法一：取出的不包含最大值的数字中的最大值，即为第二大值
注意：需要查询到的结果需要使用别名
*/
select max(Salary) as SecondHighestSalary
from Employee 
where Salary not in(select max(Salary) 
				from Employee);
