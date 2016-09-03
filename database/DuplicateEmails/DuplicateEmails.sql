/*最简单的做法，没有之一*/
select distinct(p1.Email)
from Person as p1,Person as p2
where p1.Id != p2.Id and p1.Email = p2.Email
/*以下做法想法类似，不过使用了self join 
select distinct(a.Email)
form Person a join Person b
on (a.Email = b.Email)
where a.Id != b.Id
*/
