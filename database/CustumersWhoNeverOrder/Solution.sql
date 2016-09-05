/*(469ms)
注意查询结果需要写上别名
*/
select Name as Customers
from Customers
where Id not in (select CustomerId
					from Orders)