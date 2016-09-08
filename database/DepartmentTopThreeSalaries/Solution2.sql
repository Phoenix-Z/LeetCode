/*
(707ms)
方法二
*/
select D.Name as Department, t.Name as Employee, t.Salary as Salary
from
(
    select Name, 
           Salary,
           DepartmentId,
           (
               case when @prev_departId <> (@prev_departId := DepartmentId) then @rank := ((@prev_salary := Salary) = Salary)
                    when @prev_salary <> (@prev_salary := Salary) then @rank := @rank + 1
                    else @rank
               end
           ) as rank
    from
    (
        select *
        from Employee 
        order by DepartmentId, Salary desc
    ) A, (select @rank := 0, @prev_departId := -1, @prev_salary := -1) Init
) t, Department D
where t.rank in (1, 2, 3) and t.DepartmentId = D.Id