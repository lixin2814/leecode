package duilie;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class test2071 {
    static class Solution {
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

            // 先对任务和工人进行排序
            // 然后猜试一个中间值，判断是不是力气最大的m个工人每个人都完成了一个任务
            Arrays.sort(tasks);
            Arrays.sort(workers);
            int s = 0, e = Math.min(tasks.length, workers.length);

            while (s < e) {
                int  mid = (s + e+1) /2;
                int p=pills;
                //  任务始终往后走，递增
                int j = 0;
                boolean flag = true;
                // 双端队列
                Deque<Integer> q = new ArrayDeque<>();
                for (int i = workers.length-mid; i < workers.length; i++){
                    while (j<mid&&tasks[j]<=workers[i]+strength){
                        q.addLast(tasks[j]);
                        j++;
                    }
                    if (q.isEmpty()){
                        flag=false;
                        break;
                    }
                    if (q.getFirst()<=workers[i]){
                        q.pollFirst();
                    }else {
                        if (p==0){
                            flag=false;
                            break;
                        }
                        p--;
                        q.pollLast();
                    }
                }
                if (flag){
                    s=mid;
                }else {
                    e=mid-1;
                }
                // System.out.println(s+" "+e);
            }
            return s;
        }

        public static void main(String[] args) {
            int[] workers={0,3,3};
            int[] tasks={1,2,3};
            int strength=1;
            int pills=1;
            System.out.println(new Solution().maxTaskAssign(workers,tasks,pills,strength));
        }

    }

}
