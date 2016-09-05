/*(710ms)
根据Email分组，找出最小的Id保存下来，然后删除Id不在保存下来的Id中的记录
注意这里使用了导出表，需要起个别名为p
而且min(Id)也需要起别名！这就告诉MySQL不使用同一张表，而是导出表
*/
delete from Person
where Id not in (select Id
					from (select min(Id) as Id
							from Person
							group by Email) as p)