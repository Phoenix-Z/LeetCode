/*
这题的解决思路与查询第二高薪水的方法三相似，需要注意的是N-1，而不是N
*/
create function getNthHighestSalary(N int) returns int
begin
  return (
	select salary from Employee as em1
	where N-1 = (select count(distinct(em2.salary))
		   from Employee as em2
		   where em2.salary > em1.salary)
	--加上limit字句有利于加快查询速度，而且不需要写max就可以返回一个结果	
	limit 1
  );
end
