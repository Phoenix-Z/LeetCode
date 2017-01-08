/**
 * (16ms)
 * 这个方法先是统计各个字母出现的次数，考虑到只有0的英文会有'z'，所以有几个'z'就代表有几个0，以此便可以使用
 * 单个字母出现的次数来推理出出现了几个相应的数字，但是这种写法太过丑陋，而且包含了很多不必要的代码，因此在
 * 方法二中给出了改进措施。
 * @author Phoenix-Z
 *
 */
public class ReconstructOriginalDigitsFromEnglish {

	public static String originalDigits(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
        	count[c - 'a']++;
        }
        // zero : 0
        if (count[25] != 0) {
			count['e' - 'a'] -= count[25];
			count['r' - 'a'] -= count[25];
			count['o'- 'a'] -= count[25];
			while(count[25]-- > 0) {
				ans.append('0');
			}
		}
        // two : 2
        if(count[22] != 0) {
        	count['t' - 'a'] -= count[22];
        	count['o' - 'a'] -= count[22];
        	while(count[22]-- > 0) {
        		ans.append('2');
        	}
        }
        // four : 4
        if(count[20] != 0) {
        	count['f' - 'a'] -= count[20];
        	count['o' - 'a'] -= count[20];
        	count['r' - 'a'] -= count[20];
        	while(count[20]-- > 0) {
        		ans.append('4');
        	}
        }
        // one : 1
        if(count[14] != 0) {
        	count['n' - 'a'] -= count[14];
        	count['e' - 'a'] -= count[14];
        	int index = ans.lastIndexOf("0");
        	StringBuilder tmp = new StringBuilder();
        	while(count[14]-- > 0) {
        		tmp.append('1');
        	}
        	ans.insert(index + 1, tmp);
        }
        // three : 3
        if(count[17] != 0) {
        	count['t' - 'a'] -= count[17];
        	count['h' - 'a'] -= count[17];
        	count['e' - 'a'] -= count[17] * 2;
        	StringBuilder tmp = new StringBuilder();
        	while(count[17]-- > 0) {
        		tmp.append('3');
        	}
        	int index = ans.indexOf("4");
        	if(index >= 0) {
        		ans.insert(index, tmp);
        	} else {
        		ans.append(tmp);
        	}
        }
        // five : 5
        if(count[5] != 0) {
        	count['i' - 'a'] -= count[5];
        	count['v' - 'a'] -= count[5];
        	while(count[5]-- > 0) {
        		ans.append('5');
        	}
        }
        // six : 6
        if(count[23] != 0) {
        	count['s' - 'a'] -= count[23];
        	count['i' - 'a'] -= count[23];
        	while(count[23]-- > 0){
        		ans.append('6');
        	}
        }
        // seven : 7
        if(count[18] != 0) {
        	count['e' - 'a'] -= 2 * count[18];
        	count['v' - 'a'] -= count[18];
        	count['n' - 'a'] -= count[18];
        	while(count[18]-- > 0) {
        		ans.append('7');
        	}
        }
        // eight : 8
        if(count[6] != 0) {
        	count['e' - 'a'] -= count[6];
        	count['i' - 'a'] -= count[6];
        	count['h' - 'a'] -= count[6];
        	count['t' - 'a'] -= count[6];
        	while(count[6]-- > 0) {
        		ans.append('8');
        	}
        }
        // nine : 9
        if(count[8] != 0) {
        	count['n' - 'a'] -= count[8] * 2;
        	count['e' - 'a'] -= count[8];
        	while(count[8]-- > 0) {
        		ans.append('9');
        	}
        }
        return ans.toString();
    }
	
	public static void main(String[] args) {
		String s = "owtneo";
		System.out.println(originalDigits(s));
	}
}