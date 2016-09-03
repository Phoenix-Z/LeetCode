/*
这个解法也很自然，先按Email分组，找出count>1的即为重复的email
*/
select Email
from Person
group by Email
having count(*) > 1
