import java.util.*;

/**
 * (96ms)
 * Created by Phoenix-Z on 2017/5/15.
 */
public class KillProcess {

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> childProcess = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            List<Integer> children = childProcess.get(ppid.get(i));
            if(children == null)
                children = new ArrayList<>();
            children.add(pid.get(i));
            childProcess.put(ppid.get(i), children);
        }
        Queue<Integer> candidate = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(kill);
        candidate.add(kill);
        while(!candidate.isEmpty()) {
            int cur = candidate.poll();
            List<Integer> children = childProcess.get(cur);
            if(children != null) {
                ans.addAll(children);
                candidate.addAll(children);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>(Arrays.asList(1, 3, 5, 10));
        List<Integer> ppid = new ArrayList<>(Arrays.asList(3, 0, 3, 5));
        System.out.println(killProcess(pid, ppid, 5));
    }
}
