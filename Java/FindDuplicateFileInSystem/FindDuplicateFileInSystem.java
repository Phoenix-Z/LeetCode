import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (58ms)
 * Created by Phoenix-Z on 2017/6/5.
 */
public class FindDuplicateFileInSystem {

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] parts = path.split(" ");
            String dirName = parts[0];
            for(int i = 1; i < parts.length; i++) {
                int index = parts[i].lastIndexOf("(");
                String content = parts[i].substring(index);
                String fileName = parts[i].substring(0,index);
                List<String> now = map.get(content);
                if(now == null) {
                    now = new ArrayList<>();
                    map.put(content, now);
                }
                now.add(dirName + "/" + fileName);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> value : map.values()) {
            if(value.size() > 1)
                ans.add(value);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}
