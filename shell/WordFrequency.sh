#方法一使用的是awk命令，awk的数组类似于Python的数组，可以存储键值对，
#而且如果键第一次出现，它对于的值默认为0，所以代码显得很简洁。
#至于排序输出，是通过管道的方式，使用sort处理后进行输出。
#(9ms)
awk '
{
    for(i = 1; i <= NF; i++){
        freq[$i]++;
    }
}
END{
    for(key in freq){
        print key " " freq[key];
    }
}
' words.txt | sort -r -n -t ' ' -k 2 
#-r 表示反序输出，因为awk默认从小到大输出，-n表示使用纯数字排序，因为awk默认根据字符串进行排序
#-t 表示分隔符，这里可以不写，因为awk默认以空格符进行分割，-k表示根据第几列排序

#方法二没有使用awk的字典的数据结构，而是使用多个命令结合管道实现了功能
#首先使用tr将文件中的空格符替换成换行符，这样每一行只有一个单词
#在使用uniq命令之前需要先排序，然后使用uniq时加上-c的参数，这样就可以统计重复的次数了
#然后再根据第一列表示的出现的次数进行排序了，需要加上-r-n等参数
#最后再使用awk将打印的顺序调整一下。
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{ print $2, $1 }'