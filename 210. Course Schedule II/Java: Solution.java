public class Solution {
    // 和Course Schedule完全一样，只需加一个result数组用来返回课程顺序
    // 时间复杂度O(V + E)，V为节点个数，E为边数
    // 空间复杂度O(V)
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<Integer>[] graph = new List[numCourses];
        int[] result = new int[numCourses];
        int[] indegrees = new int[numCourses];
        // 初始化有向图
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        // 建构图的有向边
        for(int[] prerequisite : prerequisites)
        {
            graph[prerequisite[1]].add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++)
        {
            if(indegrees[i] == 0)
                queue.offer(i);
        }
        
        int index = 0, count = 0;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            count++;
            // 把课程加入结果数组
            result[index++] = node;
            List<Integer> nextList = graph[node];
            for(int next : nextList)
            {
                indegrees[next]--;
                if(indegrees[next] == 0)
                    queue.offer(next);
            }
        }
        return count == numCourses ? result : new int[0];
    }
}
