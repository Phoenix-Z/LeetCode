/*
(528ms)
方法四(create by StefanPochmann):
性能很好，还得继续学啊
*/
SELECT
  Score,
  @rank := @rank + (@prev <> (@prev := Score)) Rank
FROM
  Scores,
  (SELECT @rank := 0, @prev := -1) init
ORDER BY Score desc