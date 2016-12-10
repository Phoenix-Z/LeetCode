#方法一是使用awk命令来完成的
#(28ms)
#先遍历文件，并存放在一维数组中，然后在END块中打印
awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
            s[i] = $i;
        } else {
            s[i] = s[i] " " $i;
        }
    }
}
END {
	#ubuntu不支持length函数，可做如下更改
	#for(i = 1; s[i] != ""; i++)
    for (i = 1; i <= length(s); i++) {
        print s[i];
    }
}' file.txt

#方法二只是用了bash提供的工具，先存放在一个二维数组中，再进行输出，效率很低
#(398ms)
declare -A matrix
rowcount=0
while read line; 
do
    colcount=0
    for word in $line; 
	do
        matrix[$rowcount,$colcount]=$word
        let colcount++
    done
    let rowcount++
done < file.txt

for ((i=0; i<colcount; i++)); 
do
    echo -n ${matrix[0,$i]}
    for ((j=1; j<rowcount; j++)); 
	do
        echo -n ' '${matrix[$j,$i]}
    done
    echo
done