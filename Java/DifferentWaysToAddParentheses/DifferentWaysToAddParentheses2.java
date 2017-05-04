import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (2ms)
 * 这个方法就是对第一段代码的优化，使用了Map来存储中间结果。
 * Created by Phoenix-Z on 2017/5/4.
 */
public class DifferentWaysToAddParentheses2 {

    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<>());
    }

    private List<Integer> dfs(String input, Map<String, List<Integer>> map){
        if(map.containsKey(input))
            return map.get(input);

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char curChar = input.charAt(i);
            if(curChar == '+' || curChar == '-' || curChar == '*'){
                String leftPart = input.substring(0,i);
                String rightPart = input.substring(i+1);
                List<Integer> leftResult = dfs(leftPart, map);
                List<Integer> rightResult = dfs(rightPart, map);
                for(Integer left: leftResult){
                    for(Integer right: rightResult){
                        int curResult = 0;
                        switch (curChar){
                            case '+':
                                curResult = left + right;
                                break;
                            case '-':
                                curResult = left - right;
                                break;
                            case '*':
                                curResult = left * right;
                                break;
                            default:
                                break;
                        }
                        result.add(curResult);
                    }
                }
            }
        }

        if(result.size() == 0){
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);
        return result;
    }

}
