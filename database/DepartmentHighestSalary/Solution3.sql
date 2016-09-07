/*
(730ms)
方法三：
使用存在量词来做,这种做法很清晰易懂，而且效率也不错
*/
SELECT D.Name as Department, E.Name as Employee, E.Salary 
FROM 
	Employee E,
	Department D   
WHERE E.DepartmentId = D.Id 
  AND NOT EXISTS 
  (SELECT 1 FROM Employee B WHERE B.Salary > E.Salary AND E.DepartmentId = B.DepartmentId) 