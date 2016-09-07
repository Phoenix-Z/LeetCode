/*
(711ms)
方法二：
方法二是对方法一的优化，由于对每一对(Department,Salary)都要查询部门最高薪，太浪费时间
索性先把这些信息查询出来作为临时表，附加在from字句中，可以很好的提高性能。
查询时就查询类似下表的结构：
+----+-------+--------+--------------+------+-----------+-------+-------+
|E.Id| E.Name| Salary | DepartmentId | Did  | maxSalary | D.Id  | D.Name|
+----+-------+--------+--------------+------+-----------+-------+-------+
| 1  | Joe   | 70000  | 1            |  1   |   90000   |   1   |  IT   |
| 2  | Henry | 80000  | 2            |  2   |   80000   |   2   | Sales |
| 3  | Sam   | 60000  | 2            |  2   |   80000   |   2   | Sales |
| 4  | Max   | 90000  | 1            |  1   |   90000   |   1   |  IT   |
+----+-------+--------+--------------+------+-----------+-------+-------+
可以看到这个表结构有冗余信息，可以使用Join来优化
*/
select Department.Name as Department, 
		Employee.Name as Employee,
		Salary
from Employee, 
	(select DepartmentId as Did, max(Salary) as maxSalary
	 from Employee 
	 group by DepartmentId) as tmp,
	Department
where DepartmentId = Department.Id
	and DepartmentId = Did
	and Salary = maxSalary
	
/*
(653ms)使用Join优化：
SELECT d1.Name as Department
    , e1.Name as Employee
    , e1.Salary
FROM (
    SELECT d.Id
        , MAX(d.Name) AS Name
        , MAX(e.Salary) AS Salary
    FROM Department d
    JOIN Employee e
    ON e.DepartmentId = d.Id
    GROUP BY d.Id
) d1
JOIN Employee e1
ON d1.Id = e1.DepartmentId AND e1.Salary = d1.Salary
*/