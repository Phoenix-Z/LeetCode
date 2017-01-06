#coding:utf-8
# (35ms)
# 这个方法使用正则表达式的做法，由于Python对‘+’以及‘*’都进行的重载，所以对于3[a]2[bc]
# 而言，它就相当于3*('a')+2*('bc'),对于3[a2[c]],相当于3*('a' + 2 * ('c')),所以这个方法
# 的目标就是将原字符串使用正则表达式改成Python接受的形式。
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        while '[' in s:
            s = re.sub(r'(\d+)\[([a-z]*)\]', lambda m: int(m.group(1)) * m.group(2), s)
        return s

# (48ms)	
# 这个方法与java的思路基本一致，就是用栈来存储重复次数和重复字符串，由于Python的list
# 可以放置不同的数据类型，所以可以只使用一个栈，当然需要注意push和pop的顺序	
class Solution2(object):
    def decodeString(self, s):
		stack = []
		ans = ''
		count = 0
		for c in s:
			if c.isdigit():
				count = count * 10 + int(c)
				continue
			elif c == '[':
				stack.append(count)
				stack.append(ans)
				ans = ''
				count = 0
			elif c == ']':
				ans = stack.pop() + ans * stack.pop()
			else:
				ans += c
		return ans
		
print Solution2().decodeString("3[a]2[bc]")
print Solution2().decodeString("3[a2[c]]")
print Solution2().decodeString("2[abc]3[cd]ef")