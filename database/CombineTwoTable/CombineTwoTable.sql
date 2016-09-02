select FirstName, LastName, City, State
from Person as P
--注意使用left join on 来确保左表一定出现在查询结果集中
left join Address as A
on P.PersonId = A.PersonId
