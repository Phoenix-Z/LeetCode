import java.util.ArrayList;
import java.util.List;

/**
 * (7ms)
 * 这是个分治的做法，一旦遇到运算符，就将分别计算左右两边的结果，如果某一个部分只剩下数字，就返回这个数字。
 * Created by Phoenix-Z on 2017/5/4.
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftAns = diffWaysToCompute(leftPart);
                List<Integer> rightAns = diffWaysToCompute(rightPart);
                for(int p1 : leftAns) {
                    for(int p2 : rightAns) {
                        int p = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                p = p1 + p2;
                                break;
                            case '-':
                                p = p1 - p2;
                                break;
                            case '*':
                                p = p1 * p2;
                                break;
                        }
                        ans.add(p);
                    }
                }
            }
        }
        if(ans.isEmpty()) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
//        System.out.println(Arrays.toString(input.split("-|\\+|\\*")));
//        System.out.println(Arrays.toString(input.split("\\d+")));
        DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
        System.out.println(test.diffWaysToCompute(input));
    }
}
