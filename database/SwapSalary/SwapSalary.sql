# Write your MySQL query statement below
# (612ms)
# 这个解法很不错，使用了异或操作
update salary 
set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));

# (517ms)
# 使用IF语句
UPDATE salary 
SET sex = IF(sex = 'm', 'f', 'm')

# (516ms)
# 使用CASE语句
UPDATE salary
SET sex  = (CASE WHEN sex = 'm' 
    THEN  'f' 
    ELSE 'm' 
    END)
