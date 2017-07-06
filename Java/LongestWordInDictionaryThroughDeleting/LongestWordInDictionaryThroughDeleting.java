import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (57ms)
 * Created by Phoenix-Z on 2017/7/6.
 */
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String ss : d) {
            if(ss.length() >= res.length() && canTransform(s, ss)) {
                if(ss.compareTo(res) < 0 || ss.length() > res.length())
                    res = ss;
            }
        }
        return res;
    }

    private boolean canTransform(String s, String ss) {
        int i = 0, j = 0;
        while(i < s.length() && j < ss.length()) {
            if(s.charAt(i++) == ss.charAt(j))
                j++;
        }
        return j == ss.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        LongestWordInDictionaryThroughDeleting test = new LongestWordInDictionaryThroughDeleting();
        System.out.println(test.findLongestWord(s, d));
    }

}
