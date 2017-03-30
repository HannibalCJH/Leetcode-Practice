/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int findCelebrity(int n) 
    {
        int candidate = 0;
        // 第一次遍历，找到可能的名人k，注意找到的这个是唯一的候选人，原因如下
        // 1. 假设我们从候选人0开始，第一次交换的位置为k，那么在0~k-1，候选人0不认识当前的k，
        //    所以0不符合要求中的名人不认识其他人。而0又不认识1~k-1中的任何一个，所以0能一直作为候选人直到碰到一个他认识的人k才被交换，
        //    所以1~k-1的人都不符合名人的另一个要求，其他人都得认识名人。
        // 2. 对于k+1~n-1的人，k都不认识，所以他能保持候选人到最后成为被选出的唯一候选人，而k+1~n-1的人不符合名人的要求中所有人必须认识
        //    名人这一条，最起码k不认识他们。
        // 3. 综上所述，0~k-1的人不符合要求而k+1~n-1的也不符合要求，只有k是唯一可能的人选
        for(int i = 1; i < n; i++)
        {
            if(knows(candidate, i))
                candidate = i;
        }
        
        // 第二次遍历，我们要确保对于这个唯一的候选人k，其他人都认识他但是他不认识其他人
        for(int i = 0; i < n; i++)
        {
            // 对于0~k-1的人，如果候选人k认识任何的一个人或者有人不认识k，那k就不是名人
            if(i < candidate && (knows(candidate, i) || !knows(i, candidate))) 
                return -1;
            // 对于k+1~n-1的人，我们只需检查是不是有人不认识k，因为k不认识其他人在第一次遍历已经确认了，参考第一次遍历中的第二点注释
            if(i > candidate && !knows(i, candidate)) 
                return -1;
        }
        return candidate;
    }
}
