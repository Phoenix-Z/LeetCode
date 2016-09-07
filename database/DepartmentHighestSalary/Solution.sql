/*
(1278ms)
这题的关键是选出部门中所有最高薪水的员工，由于同一个部门获得最高薪水的员工不止一个，
而max只返回一个结果，所以不能仅适用max函数
方法一：
方法一是在条件语句中，判断DepartmentId和Salary数值对在是否是部门最高薪，使用一个嵌套查询实现
*/
select Department.Name as Department, 
		Employee.Name as Employee,
		Salary
from Employee, Department
where DepartmentId = Department.Id
	and (DepartmentId,Salary) in (select DepartmentId, max(Salary) as Salary
									from Employee 
									group by DepartmentId)