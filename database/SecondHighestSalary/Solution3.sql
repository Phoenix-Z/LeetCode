/*
解法三思路：假如我们要找第二高的薪水，那么我们允许其中一个最大值存在，
然后在其余的数字中找出最大的，即为整个的第二大的值
这种解法相对于前面两种解法速度慢些，但是可扩展到找到第N高的薪水的方法，
只需要将语句中的1改为N-1即可。
注意：需要查询到的结果需要使用别名
*/
select max(Salary) as SecondHighestSalary
from Employee as e1
where 1 = (select count(distinct(e2.salary))
		from Employee as e2
		where e2.Salary > e1.Salary);
