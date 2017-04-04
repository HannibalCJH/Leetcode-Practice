public class Solution {
    // 拓扑排序
    // 时间复杂度O(V + E)，V为节点总数，E为边数
    // 空间复杂度O(V)
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<Integer>[] graph = new List[numCourses];
        int[] indegrees = new int[numCourses];
        // 初始化有向图中每个节点
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        // 建图并计算每个节点的入度
        for(int[] prerequisite : prerequisites)
        {
            graph[prerequisite[1]].add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        // 寻找所有的根节点即入度为0的节点
        for(int i = 0; i < numCourses; i++)
        {
            if(indegrees[i] == 0)
                queue.offer(i);
        }
        
        // 如果有环，那在环中的节点的入度不可能被减到0，所以不会加入queue，也不会计入count，
        // 最后得到的节点总数会小于numCourses
        int count = 0;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            count++;
            List<Integer> nextList = graph[node];
            // 删除node节点，把所有node指向的节点的入度减1
            for(int next : nextList)
            {
                indegrees[next]--;
                // 下一个节点的入度为0，加入queue
                if(indegrees[next] == 0)
                    queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
