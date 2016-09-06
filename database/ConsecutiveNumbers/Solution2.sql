/*
(1081ms)
这个方法是在discuss中看到的，提交时确实比方法一稍微快些
*/
select distinct Num as ConsecutiveNums
from
(
    select Num, 
           (
            case when @prev <> (@prev := Num) then @consecutive_cnt := 1
                 else @consecutive_cnt :=  @consecutive_cnt + 1
            end
           ) as consecutive_cnt
    from Logs,
         (
          select @consecutive_cnt := 0, 
                 @prev := (select Num from Logs limit 1)
         ) as init
) as t
where consecutive_cnt = 3;
