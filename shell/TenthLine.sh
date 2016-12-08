#方法一：使用sed，只显示第十行的数据
#(9ms)
sed -n '10p' file.txt
#也可以添加一些附加条件，有可能使得查询速度更快
#如：sed -n '10;11q' file.txt

#方法二：使用amk
#(19ms)
awk 'FNR == 10 {print }'  file.txt
#或者
#因为awk的默认动作是{print $0}，所以这里可以省略动作
awk 'NR == 10' file.txt

#方法三: 使用循环结构
#(12ms)
cnt=0
while read line && [ $cnt -le 10 ]; 
do
  cnt=$(($cnt+1))
  if [ $cnt -eq 10 ]; then
    echo $line
    exit 0
  fi
done < file.txt

#方法四：使用tail和head
#(12ms)
tail -n +10 file.txt | head -n -1