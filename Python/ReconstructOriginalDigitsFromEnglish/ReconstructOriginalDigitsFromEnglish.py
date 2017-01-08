# coding:utf-8
class Solution(object):
	# (62ms)
	# 这个方法就是利用一个特定的字母与数字建立联系，整个程序使用的主要是count方法
	# 由于添加的顺序是按照数字顺序添加的，所以不需要排序
    def originalDigits(self, s):
		ans = '0' * s.count('z')
		ans += '1' * (s.count('o') - sum(map(s.count, ['z', 'w', 'u'])))
		ans += '2' * s.count('w')
		ans += '3' * (s.count('h') - s.count('g'))
		ans += '4' * s.count('u')
		ans += '5' * (s.count('f') - s.count('u'))
		ans += '6' * s.count('x')
		ans += '7' * (s.count('s') - s.count('x'))
		ans += '8' * s.count('g')
		ans += '9' * (sum(map(s.count, ['i', 's'])) - sum(map(s.count, ['x', 'g', 'x', 'v'])))
		return ans

	#(192ms) 
	# 这个方法就是java的方法一，但是代码简洁许多
	def originalDigits(self, s):
		d = collections.Counter(s)
		res = []
		for x in '0eroz 6six 7evens 5fiev 8eihtg 4ourf 3treeh 2tow 1neo 9nnei'.split():
			res.append(x[0] * d[x[-1]])
			for c in x:
				d[c] -= d[x[-1]]
		return ''.join(sorted(res))