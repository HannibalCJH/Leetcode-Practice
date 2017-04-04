public class Solution {
    public bool CanFinish(int numCourses, int[,] prerequisites) 
    {
        List<int>[] graph = new List<int>[numCourses];
        int[] indegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new List<int>();
        
        for(int i = 0; i < prerequisites.GetLength(0); i++)
        {
            graph[prerequisites[i, 1]].Add(prerequisites[i, 0]);
            indegrees[prerequisites[i, 0]]++;
        }
        
        Queue<int> queue = new Queue<int>();
        for(int i = 0; i < numCourses; i++)
        {
            if(indegrees[i] == 0)
                queue.Enqueue(i);
        }
        
        int count = 0;
        while(queue.Count > 0)
        {
            int node = queue.Dequeue();
            count++;
            List<int> nextList = graph[node];
            foreach(int next in nextList)
            {
                indegrees[next]--;
                if(indegrees[next] == 0)
                    queue.Enqueue(next);
            }
        }
        return count == numCourses;
    }
}
